package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.TipoServicioRepository;
import com.proyectopd.omnichannel.services.Implementation.TipoServicioServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.proyectopd.omnichannel.mappers.TipoServicioEmpresaDTOMapper.mapEmpresaToEmpresaDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TipoServicioTests {

    @Mock
    TipoServicioRepository tipoServicioRepository;

    @InjectMocks
    TipoServicioServiceImplementation tipoServicioServiceImplementation;

    @Test
    public void testCreateTipoServicio() {
        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setNombreServicio("Prueba");

        boolean created = tipoServicioServiceImplementation.createTipoServicio(tipoServicio);

        assert (created);
        verify(tipoServicioRepository, times(1)).save(tipoServicio);
    }

    @Test
    public void testGellAllEmpresasPorTipoServicio() {
        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setNombreServicio("Prueba");

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        ArrayList<Empresa> listOfEmpresasTipoServicio = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Empresa empresa = new Empresa();
            empresa.setNombreEmpresa("Test " + i);
            empresa.setTipoServicio(tipoServicio);
            empresa.setUsuario(usuario);
            empresa.setCiudad("Cali");
            listOfEmpresasTipoServicio.add(empresa);
        }

        tipoServicio.setEmpresa(listOfEmpresasTipoServicio);
        when(tipoServicioRepository.findTipoServicioByNombreServicio("Prueba")).thenReturn(tipoServicio);

        ArrayList<EmpresaDTO> mappedEmpresas = new ArrayList<>();

        for (Empresa empresa : listOfEmpresasTipoServicio) {
            EmpresaDTO empresaDTO = mapEmpresaToEmpresaDTO(empresa);
            mappedEmpresas.add(empresaDTO);
        }

        ArrayList<EmpresaDTO> empresasDTOTest = tipoServicioServiceImplementation.getAllEmpresasPorTipoServicio("Prueba");

        for (int i = 0; i < 10; i++) {
            assertEquals(mappedEmpresas.get(i).getNombre(), empresasDTOTest.get(i).getNombre());
            assertEquals(mappedEmpresas.get(i).getTipoServicio(), empresasDTOTest.get(i).getTipoServicio());
            assertEquals(mappedEmpresas.get(i).getCiudad(), empresasDTOTest.get(i).getCiudad());
        }
        verify(tipoServicioRepository, times(1)).findTipoServicioByNombreServicio("Prueba");
    }

    @Test
    public void testDeleteTipoServicioByNombreTipoServicio() {
        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setNombreServicio("Prueba");

        doNothing().when(tipoServicioRepository).deleteTipoServicioByNombreServicioEquals(tipoServicio.getNombreServicio());

        boolean deleted = tipoServicioServiceImplementation.deleteTipoServicioByNombreTipoServicio("Prueba");

        assertEquals(true, deleted);
        verify(tipoServicioRepository, times(1)).deleteTipoServicioByNombreServicioEquals("Prueba");
    }

}
