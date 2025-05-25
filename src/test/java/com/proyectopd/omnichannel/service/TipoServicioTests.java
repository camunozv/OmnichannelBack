package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.repositories.TipoServicioRepository;
import com.proyectopd.omnichannel.services.Implementation.TipoServicioServiceImplementation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TipoServicioTests {

    @Mock
    TipoServicioRepository tipoServicioRepository;

    @InjectMocks
    TipoServicioServiceImplementation tipoServicioServiceImplementation;

    

}
