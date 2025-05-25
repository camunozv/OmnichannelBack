package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.repositories.EmpresaRepository;
import com.proyectopd.omnichannel.repositories.TipoServicioRepository;
import com.proyectopd.omnichannel.services.Implementation.EmpresaServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class EmpresaServiceTests {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private TipoServicioRepository tipoServicioRepository;

    @InjectMocks
    private EmpresaServiceImplementation empresaServiceImplementation;

    @Test
    public void testCreateEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Emcali");

        when(empresaRepository.save(empresa)).thenReturn(empresa);

        Empresa empresaTest = empresaRepository.save(empresa);

        assertEquals(empresa, empresaTest);

        verify(empresaRepository, times(1)).save(empresa);
    }

    @Test
    public void testDeleteEmpresaByNombreEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Emcali");

        when(empresaRepository.deleteEmpresaByNombreEmpresa(empresa.getNombreEmpresa())).thenReturn(empresa);

        Empresa empresaTest = empresaRepository.deleteEmpresaByNombreEmpresa(empresa.getNombreEmpresa());

        assertEquals(empresa, empresaTest);

        verify(empresaRepository, times(1)).deleteEmpresaByNombreEmpresa(empresa.getNombreEmpresa());
    }

    @Test
    public void testGetAllEmpresas() {
        ArrayList<Empresa> listOfEmpresas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Empresa empresa = new Empresa();
            empresa.setNombreEmpresa("Empresa " + i);
            listOfEmpresas.add(empresa);
        }

        when(empresaRepository.findAll()).thenReturn(listOfEmpresas);

        assertEquals(listOfEmpresas, empresaRepository.findAll());

        verify(empresaRepository, times(1)).findAll();
    }

    @Test
    public void testFindEmpresaByNombreEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Emcali");

        when(empresaRepository.findEmpresaByNombreEmpresa(empresa.getNombreEmpresa())).thenReturn(empresa);

        Empresa empresaTest = empresaRepository.findEmpresaByNombreEmpresa(empresa.getNombreEmpresa());

        assertEquals(empresa, empresaTest);

        verify(empresaRepository, times(1)).findEmpresaByNombreEmpresa(empresa.getNombreEmpresa());
    }

    @Test
    public void testGetTipoServicioByNombreTipoServicio() {
        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setNombreServicio("Alcantarillado");

        when(tipoServicioRepository.getTipoServicioByNombreServicioEquals(tipoServicio.getNombreServicio())).thenReturn(tipoServicio);

        TipoServicio tipoServicioTest = tipoServicioRepository.getTipoServicioByNombreServicioEquals("Alcantarillado");

        assertEquals(tipoServicio, tipoServicioTest);

        verify(tipoServicioRepository, times(1)).getTipoServicioByNombreServicioEquals("Alcantarillado");
    }

    @Test
    public void testGetEmpresasByNombreTipoServicio() {
        ArrayList<Empresa> listOfEmpresas = new ArrayList<>();
        TipoServicio servicio = new TipoServicio();
        servicio.setNombreServicio("Alcantarillado");

        for (int i = 0; i < 10; i++) {
            Empresa empresa = new Empresa();
            empresa.setNombreEmpresa("Empresa " + i);
            empresa.setTipoServicio(servicio);
            listOfEmpresas.add(empresa);
        }

        when(empresaRepository.getEmpresasByTipoServicioEquals(servicio)).thenReturn(listOfEmpresas);

        assertEquals(listOfEmpresas, empresaRepository.getEmpresasByTipoServicioEquals(servicio));

        verify(empresaRepository, times(1)).getEmpresasByTipoServicioEquals(servicio);
    }
}
