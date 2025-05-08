package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.repositories.QuejaRepository;
import com.proyectopd.omnichannel.services.ProfesionalService;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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
    public List<Queja> getAllQuejasUsuario(Long idUsuario) {
        return List.of();
    }

    @Override
    public Queja getQuejaById(Integer idQueja) {
        return quejaRepository.getQuejaByIdQueja(idQueja);
    }

    @Override
    public Queja getQuejaByCompany(Long idEmpresa, Long idQueja) {
        return null;
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
            quejaRepository.save(queja);
            answered = true;
        }

        return answered;
    }

    @Override
    public boolean assignProfesional(Integer idQueja) {

        Optional<Queja> quejaOptional = quejaRepository.findById(idQueja);

        boolean assigned = false;

        if (quejaOptional.isPresent()) {
            List<Profesional> profesionales = profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);
            Random random = new Random();
            Integer randomProfesional = random.nextInt(profesionales.size());
            Profesional profesional = profesionales.get(randomProfesional);
            Queja queja = quejaOptional.get();
            queja.setProfesional(profesional);
            quejaRepository.save(queja);
            profesional.setCantidadQuejasEncargadas(profesional.getCantidadQuejasEncargadas() + 1);
            profesionalRepository.save(profesional);
            assigned = true;
        }

        return assigned;
    }

    @Override
    public boolean updateDailyQuejas() {
        return false;
    }


    @Override
    public boolean deleteQueja(Long idEmpresa, Long idUsuario, Long idQueja) {
        return false;
    }

    @Override
    public boolean updateQueja(Queja queja, Long idQueja) {
        return false;
    }
}
