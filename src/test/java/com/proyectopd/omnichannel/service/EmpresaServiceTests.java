package com.proyectopd.omnichannel.service;

import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.EmpresaRepository;
import com.proyectopd.omnichannel.repositories.TipoServicioRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.Implementation.EmpresaServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class EmpresaServiceTests {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private TipoServicioRepository tipoServicioRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private EmpresaServiceImplementation empresaServiceImplementation;

    @Test
    public void testCreateEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Emcali");

        when(empresaRepository.save(empresa)).thenReturn(empresa);

        boolean empresaTest = empresaServiceImplementation.createEmpresa(empresa);

        assertEquals(true, empresaTest);

        verify(empresaRepository, times(1)).save(empresa);
    }

    @Test
    public void testDeleteEmpresaByNombreEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Emcali");

        Usuario usuario = new Usuario();
        Rol rol = new Rol();

        rol.setNombreRol("Empresa");
        usuario.setRol(rol);

        usuario.setEmpresa(empresa);
        usuario.setIdUsuario(1);

        empresa.setUsuario(usuario);

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        doNothing().when(usuarioRepository).deleteUsuarioByIdUsuario(1);

        boolean empresaTest = empresaServiceImplementation.deleteEmpresaById(1);

        assertEquals(true, empresaTest);

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

        assertEquals(listOfEmpresas, empresaServiceImplementation.getAllEmpresas());

        verify(empresaRepository, times(1)).findAll();
    }

    @Test
    public void testFindEmpresaByNombreEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Emcali");

        when(empresaRepository.findEmpresaByNombreEmpresa(empresa.getNombreEmpresa())).thenReturn(empresa);

        Empresa empresaTest = empresaServiceImplementation.getEmpresaByName("Emcali");

        assertEquals(empresa, empresaTest);

        verify(empresaRepository, times(1)).findEmpresaByNombreEmpresa(empresa.getNombreEmpresa());
    }


    @Test
    public void testGetEmpresasByNombreTipoServicio() {
        ArrayList<Empresa> listOfEmpresas = new ArrayList<>();
        TipoServicio servicio = new TipoServicio();
        servicio.setNombreServicio("Alcantarillado");

        for (int i = 0; i < 10; i++) {
            Empresa empresa = new Empresa();
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(i);
            empresa.setNombreEmpresa("Empresa " + i);
            empresa.setTipoServicio(servicio);
            empresa.setUsuario(usuario);
            listOfEmpresas.add(empresa);
        }

        when(empresaRepository.getEmpresasByTipoServicioEquals(servicio)).thenReturn(listOfEmpresas);
        when(tipoServicioRepository.getTipoServicioByNombreServicioEquals(servicio.getNombreServicio())).thenReturn(servicio);

        ArrayList<EmpresaDTO> returnEmpresas = (ArrayList<EmpresaDTO>) empresaServiceImplementation.getEmpresasByTipoServicio("Alcantarillado");

        for (int i = 0; i < 10; i++) {
            assertEquals(returnEmpresas.get(i).getNombre(), listOfEmpresas.get(i).getNombreEmpresa());
        }

        verify(empresaRepository, times(1)).getEmpresasByTipoServicioEquals(servicio);
    }
}
