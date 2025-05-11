package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.repositories.QuejaRepository;
import com.proyectopd.omnichannel.services.QuejaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class QuejaServiceImplementation implements QuejaService {

    private ProfesionalRepository profesionalRepository;
    private QuejaRepository quejaRepository;

    public QuejaServiceImplementation(ProfesionalRepository profesionalRepository, QuejaRepository quejaRepository) {
        this.profesionalRepository = profesionalRepository;
        this.quejaRepository = quejaRepository;
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
    public boolean deleteQueja(Integer idQueja) {
        return quejaRepository.deleteQuejaByIdQueja(idQueja);
    }

}
