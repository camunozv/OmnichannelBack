package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.NotificacionAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository <NotificacionAdmin, Integer>{
    NotificacionAdmin getNotificacionAdminByIdNotificacion(Integer idNotificacion);
}
