package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.NotificacionAdmin;

import java.util.List;

public interface NotificacionAdminService {
    List<NotificacionAdmin> getAllNotificaciones();
    boolean createNotificacion(String textoNotificacion);
    boolean deleteNotificacion(Integer idNotificacion);
    NotificacionAdmin getNotificacionById(Integer idNotificacion);
}
