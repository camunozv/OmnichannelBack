package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.services.ProfesionalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalServiceImplementation implements ProfesionalService {

    ProfesionalRepository profesionalRepository;

    public ProfesionalServiceImplementation(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;
    }

    @Override
    public boolean crearProfesional(Profesional newProfesional) {

        boolean created;

        try {
            profesionalRepository.save(newProfesional);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }

    @Override
    public Profesional getProfesionalById(Integer profesionalId) {
        return profesionalRepository.getProfesionalByIdProfesional(profesionalId);
    }

    @Override
    public List<Profesional> getAllFreeProfesionales() {
        return profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);
    }

}
