package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.*;

import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.repositories.QuejaRepository;
import com.proyectopd.omnichannel.repositories.RespuestaRepository;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.QuejaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class QuejaServiceImplementation implements QuejaService {

    private final ProfesionalService profesionalService;
    private ProfesionalRepository profesionalRepository;
    private QuejaRepository quejaRepository;
    private NotificacionRepository notificacionRepository;
    private RespuestaRepository respuestaRepository;

    public QuejaServiceImplementation(ProfesionalService profesionalService, ProfesionalRepository profesionalRepository, QuejaRepository quejaRepository, NotificacionRepository notificacionRepository, RespuestaRepository respuestaRepository) {
        this.profesionalService = profesionalService;
        this.profesionalRepository = profesionalRepository;
        this.quejaRepository = quejaRepository;
        this.notificacionRepository = notificacionRepository;
        this.respuestaRepository = respuestaRepository;
    }

    @Override
    public List<Queja> getAllQuejasEmpresa(String nombreEmpresa) {
        return quejaRepository.findQuejasByEmpresa_NombreEmpresaEquals(nombreEmpresa);
    }


    @Override
    public Queja getQuejaById(Integer idQueja) {
        return quejaRepository.getQuejaByIdQueja(idQueja);
    }

    @Override
    public List<Queja> getQuejasByEstado(String estado) {
        return quejaRepository.findQuejasByEstado(estado);
    }


    @Override
    public Queja createQueja(Queja queja) {
        try {
            return quejaRepository.save(queja);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public boolean answerQueja(Respuesta respuesta, Integer idQueja) {

        boolean answered = false;
        Optional<Queja> quejaOptional = quejaRepository.findById(idQueja);

        if (quejaOptional.isPresent()) {
            Queja queja = quejaOptional.get();
            queja.setRespuesta(respuesta);
            queja.setEstado("RESPONDIDA");
            queja.setTiempoMinimoRespuesta(LocalDate.of(5874897, 12, 31));
            quejaRepository.save(queja);
            answered = true;
        }

        return answered;
    }

    @Override
    public boolean assignProfesional() {

        List<Queja> quejasVencidas = quejaRepository.findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now());
        List<Profesional> profesionalesLibres = profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);

        int i = 0;
        int begin = 0;
        int assigned = 0;

        Profesional profesional;
        Queja queja;

        while (i < profesionalesLibres.size()) {
            profesional = profesionalesLibres.get(i);
            while (profesional.getCantidadQuejasEncargadas() < 3 && begin < quejasVencidas.size()) {
                // Asignar profesional
                queja = quejasVencidas.get(begin);
                queja.setProfesional(profesional);
                queja.setEstado("VENCIDA");
                quejaRepository.save(queja);
                profesional.setCantidadQuejasEncargadas(profesional.getCantidadQuejasEncargadas() + 1);

                // Notificación al profesional encargado
                Notificacion nuevaNotificacionProfesional = new Notificacion();
                nuevaNotificacionProfesional.setTextoNotificacion("Nueva queja asignada con id: " + queja.getIdQueja());
                nuevaNotificacionProfesional.setUsuario(profesional.getUsuario());
                notificacionRepository.save(nuevaNotificacionProfesional);

                // Notificación a la empresa que incumple
                Notificacion nuevaNotificacionEmpresa = new Notificacion();
                nuevaNotificacionEmpresa.setTextoNotificacion("Hay un aviso de incumplimiento por Queja con id: " + queja.getIdQueja() + ".");
                nuevaNotificacionEmpresa.setUsuario(queja.getEmpresa().getUsuario());
                notificacionRepository.save(nuevaNotificacionEmpresa);

                assigned++;
                begin++;
            }
            // Una vez el profesional queja asignado se guarda
            profesionalRepository.save(profesional);
            i++;
        }

        while (begin < quejasVencidas.size()) {
            queja = quejasVencidas.get(begin);
            queja.setEstado("VENCIDA SIN PROFESIONAL ASIGNADO");
            quejaRepository.save(queja);
            begin++;
        }

        return assigned == quejasVencidas.size();
    }

    @Override
    public boolean updateDailyQuejas() {

        List<Queja> quejasProximasAVencer = quejaRepository.findQuejasByTiempoMinimoRespuestaEquals(LocalDate.now().plusDays(2));

        int counter = 0;

        for (Queja queja : quejasProximasAVencer) {
            queja.setEstado("PROXIMA A VENCER");
            quejaRepository.save(queja);
            counter++;
        }

        return counter == quejasProximasAVencer.size();
    }


    @Override
    @Transactional
    public boolean deleteQuejaById(Integer idQueja) {

        boolean deleted;

        try {
            Queja queja = quejaRepository.getQuejaByIdQueja(idQueja);
            try {
                respuestaRepository.deleteById(queja.getRespuesta().getIdRespuesta());
            } catch (Exception e) {
                e.printStackTrace();
            }

            quejaRepository.deleteById(idQueja);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }

}
