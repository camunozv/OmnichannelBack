package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.repositories.RespuestaRepository;
import com.proyectopd.omnichannel.services.Implementation.RespuestaServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RespuestaServiceTests {

    @Mock
    RespuestaRepository respuestaRepository;

    @InjectMocks
    RespuestaServiceImplementation respuestaServiceImplementation;

    @Test
    public void testCreateRespuesta() {
        Respuesta respuesta = new Respuesta();
        respuesta.setIdRespuesta(1);
        respuesta.setTextoRespuesta("Test answer");

        boolean created = respuestaServiceImplementation.createRespuesta(respuesta);

        assertEquals(true, created);
        verify(respuestaRepository, times(1)).save(respuesta);
    }

    @Test
    public void testDeleteRespuestaById() {
        Respuesta respuesta = new Respuesta();
        respuesta.setIdRespuesta(1);
        respuesta.setTextoRespuesta("Test answer");

        boolean deleted = respuestaServiceImplementation.deleteRespuestaById(1);

        assertEquals(true, deleted);
        verify(respuestaRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetRespuestaById() {
        Respuesta respuesta = new Respuesta();
        respuesta.setIdRespuesta(1);
        respuesta.setTextoRespuesta("Test answer");

        when(respuestaRepository.getRespuestaByIdRespuesta(1)).thenReturn(respuesta);

        Respuesta respuestaTest = respuestaServiceImplementation.getRespuestaById(1);

        assertEquals(respuesta, respuestaTest);
        verify(respuestaRepository, times(1)).getRespuestaByIdRespuesta(1);
    }

}
