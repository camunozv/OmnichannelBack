package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.NotificacionAdmin;
import com.proyectopd.omnichannel.repositories.NotificacionAdminRepository;
import com.proyectopd.omnichannel.services.NotificacionAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificacionAdminImplementation implements NotificacionAdminService {

    NotificacionAdminRepository notificacionAdminRepository;

    public NotificacionAdminImplementation(NotificacionAdminRepository notificacionAdminRepository) {
        this.notificacionAdminRepository = notificacionAdminRepository;
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
            // Requires test
            notificacionAdminRepository.save(notificacion);
            created = true;
        } catch (Exception e) {
            e.printStackTrace();
            created = false;
        }

        return created;
    }

    @Override
    @Transactional
    public boolean deleteNotificacion(Integer idNotificacion) {

        boolean deleted;
        try{
            // Requires test
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
        return notificacionAdminRepository.findById(idNotificacion).orElse(null);
    }
}
