package com.proyectopd.omnichannel.profesional.implementation;

import com.proyectopd.omnichannel.profesional.Profesional;
import com.proyectopd.omnichannel.profesional.ProfesionalRepository;
import com.proyectopd.omnichannel.profesional.ProfesionalService;

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
