package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.Notificacion;

import java.util.List;

public interface NotificacionService {

    List<Notificacion> getAllNotificacionesUsuario(Integer idUsuario);
    Notificacion getNotificacionById(Integer idNotificacion);
    boolean deleteNotificacionById(Integer idNotificacion);

    // There's no creation of notifications since the use of that
    // was only done by the repository itself.
}
