package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.*;

import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.repositories.QuejaRepository;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.QuejaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class QuejaServiceImplementation implements QuejaService {

    private final ProfesionalService profesionalService;
    private ProfesionalRepository profesionalRepository;
    private QuejaRepository quejaRepository;
    private NotificacionRepository notificacionRepository;

    public QuejaServiceImplementation(ProfesionalRepository profesionalRepository, QuejaRepository quejaRepository, NotificacionRepository notificacionRepository, ProfesionalService profesionalService) {
        this.profesionalRepository = profesionalRepository;
        this.quejaRepository = quejaRepository;
        this.notificacionRepository = notificacionRepository;
        this.profesionalService = profesionalService;
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
    public boolean createQueja(Queja queja) {
        boolean created;

        try {
            quejaRepository.save(queja);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }


    @Override
    public boolean answerQueja(Respuesta respuesta, Integer idQueja) {

        boolean answered = false;
        Optional<Queja> quejaOptional = quejaRepository.findById(idQueja);

        if (quejaOptional.isPresent()) {
            Queja queja = quejaOptional.get();
            queja.setRespuesta(respuesta);
            queja.setEstado("RESPONDIDA");
            queja.setTiempoMinimoRespuesta(LocalDate.of(5874897,12,31));
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
    public boolean deleteQuejaById(Integer idQueja) {

        boolean deleted;

        try {
            quejaRepository.deleteQuejaByIdQueja(idQueja);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }

}
