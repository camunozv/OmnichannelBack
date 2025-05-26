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
        for (int i = 0; i < 10; i++) {
            Queja queja = new Queja();
            queja.setEmpresa(empresa);
            queja.setIdQueja(i);
        }
        when(quejaRepository.findQuejasByEmpresa_NombreEmpresaEquals(empresa.getNombreEmpresa())).thenReturn(quejasEmpresa);

        ArrayList<Queja> quejasEmpresaTest = (ArrayList<Queja>) quejaServiceImplementation.getAllQuejasEmpresa("Empresa de prueba");

        for (int i = 0; i < quejasEmpresaTest.size(); i++) {
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
        for (int i = 0; i < 10; i++) {
            Queja queja = new Queja();
            queja.setIdQueja(i);
            queja.setEstado("RESPONDIDA");
            quejas.add(queja);
        }

        when(quejaRepository.findQuejasByEstado("RESPONDIDA")).thenReturn(quejas);

        ArrayList<Queja> quejasTest = (ArrayList<Queja>) quejaServiceImplementation.getQuejasByEstado("RESPONDIDA");

        for (int i = 0; i < quejasTest.size(); i++) {
            assertEquals(quejas.get(i), quejasTest.get(i));
        }

        verify(quejaRepository, times(1)).findQuejasByEstado("RESPONDIDA");
    }

    @Test
    public void testCreateQueja() {
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
    public void testAssignProfesionalAllQuejasAssignedCase1() {
        /*
         * All quejas get assigned case.
         * */
        ArrayList<Queja> quejasVencidas = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        Empresa empresa = new Empresa();
        empresa.setUsuario(usuario);
        empresa.setNombreEmpresa("Emcali");

        for (int i = 0; i < 10; i++) {
            Queja queja = new Queja();
            queja.setEmpresa(empresa);
            queja.setIdQueja(i);
            queja.setTiempoMinimoRespuesta(LocalDate.of(2001, 1, 1));
            queja.setEstado("SIN RESPONDER");
            quejasVencidas.add(queja);
        }

        ArrayList<Profesional> profesionalesLibres = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Profesional profesional = new Profesional();
            profesional.setIdProfesional(i);
            profesional.setCantidadQuejasEncargadas(1);
            profesionalesLibres.add(profesional);
        }

        when(quejaRepository.findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now())).thenReturn(quejasVencidas);
        when(profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3)).thenReturn(profesionalesLibres);

        boolean assigned = quejaServiceImplementation.assignProfesional();
        assertEquals(true, assigned);
        verify(profesionalRepository, times(1)).findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);
        verify(quejaRepository, times(1)).findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now());
    }

    @Test
    public void testAssignProfesionalAllQuejasAssignedCase2() {
        /*
         * More quejas than professionals assigned case.
         * */
        ArrayList<Queja> quejasVencidas = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        Empresa empresa = new Empresa();
        empresa.setUsuario(usuario);
        empresa.setNombreEmpresa("Emcali");

        for (int i = 0; i < 20; i++) {
            Queja queja = new Queja();
            queja.setEmpresa(empresa);
            queja.setIdQueja(i);
            queja.setTiempoMinimoRespuesta(LocalDate.of(2001, 1, 1));
            queja.setEstado("SIN RESPONDER");
            quejasVencidas.add(queja);
        }

        ArrayList<Profesional> profesionalesLibres = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Profesional profesional = new Profesional();
            profesional.setIdProfesional(i);
            profesional.setCantidadQuejasEncargadas(1);
            profesionalesLibres.add(profesional);
        }

        when(quejaRepository.findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now())).thenReturn(quejasVencidas);
        when(profesionalRepository.findProfesionalsByCantidadQuejasEncargadasIsLessThan(3)).thenReturn(profesionalesLibres);

        boolean assigned = quejaServiceImplementation.assignProfesional();
        assertEquals(false, assigned);
        verify(profesionalRepository, times(1)).findProfesionalsByCantidadQuejasEncargadasIsLessThan(3);
        verify(quejaRepository, times(1)).findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate.now());
    }

    @Test
    public void testUpdateDailyQuejas() {
        ArrayList<Queja> quejasProximasVencer = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Queja queja = new Queja();
            queja.setIdQueja(i);
            queja.setTiempoMinimoRespuesta(LocalDate.of(2001, 1, 1));
            queja.setEstado("SIN RESPONDER");
            quejasProximasVencer.add(queja);
        }

        when(quejaRepository.findQuejasByTiempoMinimoRespuestaEquals(LocalDate.now().plusDays(2))).thenReturn(quejasProximasVencer);

        boolean updatedQuejas = quejaServiceImplementation.updateDailyQuejas();

        assertEquals(true, updatedQuejas);
        verify(quejaRepository, times(1)).findQuejasByTiempoMinimoRespuestaEquals(LocalDate.now().plusDays(2));
    }

    @Test
    public void testDeleteQuejaById() {
        Queja queja = new Queja();
        queja.setIdQueja(1);
        queja.setEstado("RESPONDIDA");

        doNothing().when(quejaRepository).deleteQuejaByIdQueja(1);

        boolean deleted = quejaServiceImplementation.deleteQuejaById(1);

        assertEquals(true, deleted);

        verify(quejaRepository, times(1)).deleteQuejaByIdQueja(1);

    }

}
