package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.services.ProfesionalService;

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
}
