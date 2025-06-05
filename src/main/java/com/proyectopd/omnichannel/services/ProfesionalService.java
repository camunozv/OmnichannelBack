package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.Profesional;

import java.util.List;

public interface ProfesionalService {

    boolean crearProfesional(Profesional newProfesional);

    Profesional getProfesionalById(Integer idUsuario);

    boolean deleteProfesionalById(Integer idUsuario);

    List<Profesional> getAllProfesionales();

    List<Profesional> getAllFreeProfesionales();
}
