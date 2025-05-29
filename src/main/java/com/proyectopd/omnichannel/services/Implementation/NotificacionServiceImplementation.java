package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Notificacion;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.NotificacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImplementation implements NotificacionService {

    NotificacionRepository notificacionRepository;
    UsuarioRepository usuarioRepository;

    public NotificacionServiceImplementation(NotificacionRepository notificacionRepository, UsuarioRepository usuarioRepository) {
        this.notificacionRepository = notificacionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Notificacion> getAllNotificacionesUsuario(Integer idUsuario) {
        // Requires test
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        if (usuario.isPresent()) {
            Usuario usuario1 = usuario.get();
            List<Notificacion> listOfNotifs = notificacionRepository.getNotificacionsByUsuarioEquals(usuario1);
            return listOfNotifs;
        } else {
            return null;
        }

    }

    @Override
    public Notificacion getNotificacionById(Integer idNotificacion) {
        return notificacionRepository.getNotificacionByIdNotificacion(idNotificacion);
    }

    @Override
    @Transactional
    public boolean deleteNotificacionById(Integer idNotificacion) {

        boolean deleted;

        try {
            // Requires test
            notificacionRepository.deleteNotificacionByIdNotificacionEquals(idNotificacion);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }


}
