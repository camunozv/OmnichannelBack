package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.NotificacionAdmin;
import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.services.NotificacionServiceAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImplementation implements NotificacionServiceAdmin {

    NotificacionRepository notificacionAdminRepository;

    public NotificacionServiceImplementation() {
    }

    @Override
    public List<NotificacionAdmin> getAllNotificaciones() {
        return notificacionAdminRepository.findAll();
    }

    @Override
    public boolean createNotificacion(String textoNotificacion) {
        NotificacionAdmin notificacion = new NotificacionAdmin();
        notificacion.setTextoNotificacion(textoNotificacion);
        boolean created;
        try{
            notificacionAdminRepository.save(notificacion);
            created = true;
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
        }

        return created;
    }

    @Override
    public boolean deleteNotificacion(Integer idNotificacion) {

        boolean deleted;
        try{
            notificacionAdminRepository.deleteById(idNotificacion);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }
        return deleted;
    }

    @Override
    public NotificacionAdmin getNotificacionById(Integer idNotificacion) {
        return notificacionAdminRepository.getNotificacionAdminByIdNotificacion(idNotificacion);
    }
}
