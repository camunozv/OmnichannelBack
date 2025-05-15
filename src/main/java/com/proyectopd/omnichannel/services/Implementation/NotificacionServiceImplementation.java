package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Notificacion;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.NotificacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImplementation implements NotificacionService {

    NotificacionRepository notificacionRepository;
    UsuarioRepository usuarioRepository;

    public NotificacionServiceImplementation(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }


    @Override
    public List<Notificacion> getAllNotificacionesUsuario(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            List<Notificacion> listOfNotifs = notificacionRepository.getNotificacionsByUsuarioEquals(usuario);
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
    public boolean deleteNotificacionById(Integer idNotificacion) {

        boolean deleted;

        try {
            notificacionRepository.deleteNotificacionByIdNotificacionEquals(idNotificacion);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }


}
