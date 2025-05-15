package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.NotificacionAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionAdminRepository extends JpaRepository <NotificacionAdmin, Integer>{
    NotificacionAdmin getNotificacionAdminByIdNotificacion(Integer idNotificacion);
}
