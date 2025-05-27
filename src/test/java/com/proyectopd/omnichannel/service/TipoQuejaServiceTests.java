package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.repositories.TipoQuejaRepository;
import com.proyectopd.omnichannel.services.Implementation.TipoQuejaServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TipoQuejaServiceTests {

    @Mock
    TipoQuejaRepository tipoQuejaRepository;

    @InjectMocks
    TipoQuejaServiceImplementation tipoQuejaServiceImplementation;

    @Test
    public void testCreateTipoQueja() {
        TipoQueja tipoQueja = new TipoQueja();
        tipoQueja.setTipoQueja("Negacion de atención");
        tipoQueja.setDias(15);

        boolean created = tipoQuejaServiceImplementation.createTipoQueja(tipoQueja);

        assertEquals(true, created);
        verify(tipoQuejaRepository, times(1)).save(tipoQueja);
    }

    @Test
    public void testGetTipoQuejaById() {
        TipoQueja tipoQueja = new TipoQueja();
        tipoQueja.setTipoQueja("Negacion de atención");
        tipoQueja.setDias(15);

        when(tipoQuejaRepository.getTipoQuejaByTipoQueja(tipoQueja.getTipoQueja())).thenReturn(tipoQueja);

        TipoQueja tipoQuejaTest = tipoQuejaServiceImplementation.getTipoQuejaById("Negacion de atención");

        assertEquals(tipoQueja, tipoQuejaTest);
        verify(tipoQuejaRepository, times(1)).getTipoQuejaByTipoQueja("Negacion de atención");
    }

    @Test
    public void testDeleteTipoQueja() {
        TipoQueja tipoQueja = new TipoQueja();
        tipoQueja.setTipoQueja("Negacion de atención");
        tipoQueja.setDias(15);

        boolean deleted = tipoQuejaServiceImplementation.deleteTipoQueja("Negacion de atención");

        assertEquals(true, deleted);
        verify(tipoQuejaRepository, times(1)).deleteTipoQuejaByTipoQuejaEquals("Negacion de atención");
    }
}
