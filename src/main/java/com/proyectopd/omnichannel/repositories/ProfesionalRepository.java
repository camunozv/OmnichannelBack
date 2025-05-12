package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {

    Profesional getProfesionalByIdProfesional(Integer profesionalId);

    List<Profesional> findProfesionalsByCantidadQuejasEncargadasIsLessThan(Integer cantidadQuejasEncargadasIsLessThan);

    Profesional findProfesionalByUsuario_IdUsuario(Integer usuarioIdUsuario);

    void deleteProfesionalByUsuario(Usuario usuario);
}
