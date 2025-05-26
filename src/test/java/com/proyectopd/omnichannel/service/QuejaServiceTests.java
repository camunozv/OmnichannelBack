package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.repositories.QuejaRepository;
import com.proyectopd.omnichannel.services.Implementation.QuejaServiceImplementation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuejaServiceTests {

    @Mock
    private ProfesionalRepository profesionalRepository;
    @Mock
    private QuejaRepository quejaRepository;
    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private QuejaServiceImplementation quejaServiceImplementation;


    /*
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
            queja.setTiempoMinimoRespuesta(LocalDate.MAX);
            quejaRepository.save(queja);
            answered = true;
        }

        return answered;
    }

    @Override
    public boolean assignProfesional() {

        List<Queja> quejasVencidas = quejaRepository.findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now());
        List<Profesional> profesionalesLibres = profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);

        int assigned = 0;
        int i = 0;
        for (Queja queja : quejasVencidas) {
            if (i < profesionalesLibres.size()) {
                Profesional profesional = profesionalesLibres.get(i);
                if (profesional.getCantidadQuejasEncargadas() < 3) {
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

                    assigned += 1;
                } else {
                    profesionalRepository.save(profesional);
                    i += 1;
                }
            } else {
                queja.setEstado("VENCIDA SIN PROFESIONAL ASIGNADO");
                quejaRepository.save(queja);
            }
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

    * */
}
