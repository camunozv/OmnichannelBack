package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Profesional;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.ProfesionalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesionalServiceImplementation implements ProfesionalService {

    ProfesionalRepository profesionalRepository;
    UsuarioRepository usuarioRepository;

    public ProfesionalServiceImplementation(ProfesionalRepository profesionalRepository, UsuarioRepository usuarioRepository) {
        this.profesionalRepository = profesionalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean crearProfesional(Profesional newProfesional) {

        boolean created;

        try {
            // Requires test
            profesionalRepository.save(newProfesional);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }

    @Override
    public Profesional getProfesionalById(Integer idUsuario) {

        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        Profesional profesional = null;
        if (usuario != null) {
            // Requires test
            profesional = profesionalRepository.findProfesionalByUsuario_IdUsuario(idUsuario);
        }

        return profesional;
    }

    @Override
    @Transactional
    public boolean deleteProfesionalById(Integer idUsuario) {

        boolean deleted = false;

        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            // Requires test
            profesionalRepository.deleteProfesionalByUsuario(usuario);
            // Doesn't requires test
            usuarioRepository.deleteUsuarioByIdUsuario(idUsuario);
            deleted = true;
        }

        return deleted;
    }


    @Override
    public List<Profesional> getAllFreeProfesionales() {
        // Requires test
        return profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);
    }

}
