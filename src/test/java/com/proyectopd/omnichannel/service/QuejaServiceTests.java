package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.*;
import com.proyectopd.omnichannel.repositories.NotificacionRepository;
import com.proyectopd.omnichannel.repositories.ProfesionalRepository;
import com.proyectopd.omnichannel.repositories.QuejaRepository;
import com.proyectopd.omnichannel.services.Implementation.QuejaServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuejaServiceTests {

    @Mock
    private ProfesionalRepository profesionalRepository;
    @Mock
    private QuejaRepository quejaRepository;
    @Mock
    private NotificacionRepository notificacionRepository;

    @InjectMocks
    private QuejaServiceImplementation quejaServiceImplementation;

    @Test
    public void testGetAllQuejasEmpresa() {
        ArrayList<Queja> quejasEmpresa = new ArrayList<>();
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Empresa de prueba");
        for(int i = 0; i < 10; i++) {
            Queja queja = new Queja();
            queja.setEmpresa(empresa);
            queja.setIdQueja(i);
        }
        when(quejaRepository.findQuejasByEmpresa_NombreEmpresaEquals(empresa.getNombreEmpresa())).thenReturn(quejasEmpresa);

        ArrayList<Queja> quejasEmpresaTest = (ArrayList<Queja>) quejaServiceImplementation.getAllQuejasEmpresa("Empresa de prueba");

        for(int i = 0; i < quejasEmpresaTest.size(); i++) {
            assertEquals(quejasEmpresa.get(i), quejasEmpresaTest.get(i));
        }

        verify(quejaRepository, times(1)).findQuejasByEmpresa_NombreEmpresaEquals("Empresa de prueba");
    }

    @Test
    public void testGetQuejaById() {
        Queja queja = new Queja();
        queja.setIdQueja(1);
        queja.setEstado("RESPONDIDA");
        when(quejaRepository.getQuejaByIdQueja(1)).thenReturn(queja);

        Queja quejaTest = quejaServiceImplementation.getQuejaById(1);

        assertEquals(queja, quejaTest);
        verify(quejaRepository, times(1)).getQuejaByIdQueja(1);
    }

    @Test
    public void testGetQuejasByEstado() {
        ArrayList<Queja> quejas = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Queja queja = new Queja();
            queja.setIdQueja(i);
            queja.setEstado("RESPONDIDA");
            quejas.add(queja);
        }

        when(quejaRepository.findQuejasByEstado("RESPONDIDA")).thenReturn(quejas);

        ArrayList<Queja> quejasTest = (ArrayList<Queja>) quejaServiceImplementation.getQuejasByEstado("RESPONDIDA");

        for(int i = 0; i < quejasTest.size(); i++) {
            assertEquals(quejas.get(i), quejasTest.get(i));
        }

        verify(quejaRepository, times(1)).findQuejasByEstado("RESPONDIDA");
    }

    @Test
    public void testCreateQueja () {
        Queja queja = new Queja();
        queja.setIdQueja(1);
        queja.setEstado("RESPONDIDA");
        when(quejaRepository.save(queja)).thenReturn(queja);

        boolean created = quejaServiceImplementation.createQueja(queja);

        assertEquals(true, created);

        verify(quejaRepository, times(1)).save(queja);
    }

    @Test
    public void testAnswerQueja() {
        int idQueja = 1;
        Queja queja = new Queja();
        queja.setIdQueja(idQueja);

        Respuesta respuesta = new Respuesta();
        respuesta.setIdRespuesta(1);
        respuesta.setQueja(queja);
        respuesta.setTextoRespuesta("Hola");

        when(quejaRepository.findById(idQueja)).thenReturn(Optional.of(queja));
        when(quejaRepository.save(queja)).thenReturn(queja);

        boolean answered = quejaServiceImplementation.answerQueja(respuesta, idQueja);

        assertEquals(true, answered);

        verify(quejaRepository, times(1)).findById(idQueja);
        verify(quejaRepository, times(1)).save(queja);
    }

    @Test
    public void testAssignProfesionalAllQuejasAssigned() {
        ArrayList<Queja> quejasVencidas = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        Empresa empresa = new Empresa();
        empresa.setUsuario(usuario);
        empresa.setNombreEmpresa("Emcali");

        for(int i = 0; i < 4; i++) {
            Queja queja = new Queja();
            queja.setEmpresa(empresa);
            queja.setIdQueja(i);
            queja.setTiempoMinimoRespuesta(LocalDate.of(2001, 1, 1));
            queja.setEstado("SIN RESPONDER");
            quejasVencidas.add(queja);
        }

        ArrayList<Profesional> profesionalesLibres = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Profesional profesional = new Profesional();
            profesional.setIdProfesional(i);
            profesional.setCantidadQuejasEncargadas(0);
            profesionalesLibres.add(profesional);
        }

        when(quejaRepository.findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now())).thenReturn(quejasVencidas);
        when(profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3)).thenReturn(profesionalesLibres);

        boolean assigned = quejaServiceImplementation.assignProfesional();
        assertEquals(true, assigned);
    }
    /*

    @Override
    public boolean assignProfesional() {

        List<Queja> quejasVencidas = quejaRepository.findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now());
        List<Profesional> profesionalesLibres = profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);

        int assigned = 0;
        int i = 0;
        for (Queja queja : quejasVencidas) {
            if (i < profesionalesLibres.size()) {
                Profesional profesional = profesionalesLibres.get(i);
                if (profesional.getCantidadQuejasEncargadas() < 3) {
                    queja.setProfesional(profesional);
                    queja.setEstado("VENCIDA");

                    // not mock
                    quejaRepository.save(queja);

                    profesional.setCantidadQuejasEncargadas(profesional.getCantidadQuejasEncargadas() + 1);

                    // Notificación al profesional encargado
                    Notificacion nuevaNotificacionProfesional = new Notificacion();
                    nuevaNotificacionProfesional.setTextoNotificacion("Nueva queja asignada con id: " + queja.getIdQueja());
                    nuevaNotificacionProfesional.setUsuario(profesional.getUsuario());

                    // not mock
                    notificacionRepository.save(nuevaNotificacionProfesional);

                    // Notificación a la empresa que incumple
                    Notificacion nuevaNotificacionEmpresa = new Notificacion();
                    nuevaNotificacionEmpresa.setTextoNotificacion("Hay un aviso de incumplimiento por Queja con id: " + queja.getIdQueja() + ".");
                    nuevaNotificacionEmpresa.setUsuario(queja.getEmpresa().getUsuario());

                    // not mock
                    notificacionRepository.save(nuevaNotificacionEmpresa);

                    assigned += 1;
                } else {

                    // not mock
                    profesionalRepository.save(profesional);
                    i += 1;
                }
            } else {
                queja.setEstado("VENCIDA SIN PROFESIONAL ASIGNADO");

                // not mock
                quejaRepository.save(queja);
            }
        }

        return assigned == quejasVencidas.size();
    }

    @Override
    public boolean updateDailyQuejas() {

        List<Queja> quejasProximasAVencer = quejaRepository.findQuejasByTiempoMinimoRespuestaEquals(LocalDate.now().plusDays(2));

        int counter = 0;

        for (Queja queja : quejasProximasAVencer) {
            queja.setEstado("PROXIMA A VENCER");
            quejaRepository.save(queja);
            counter++;
        }

        return counter == quejasProximasAVencer.size();
    }


    @Override
    public boolean deleteQuejaById(Integer idQueja) {

        boolean deleted;

        try {
            quejaRepository.deleteQuejaByIdQueja(idQueja);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }

    * */
}
