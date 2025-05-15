package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Notificacion;
import com.proyectopd.omnichannel.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    Notificacion getNotificacionByIdNotificacion(Integer idNotificacion);

    void deleteNotificacionByIdNotificacionEquals(Integer idNotificacion);

    List<Notificacion> getNotificacionsByUsuarioEquals(Usuario usuario);
}
