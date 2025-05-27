package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.EmpresaController;
import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.services.EmpresaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

@WebMvcTest(EmpresaController.class)
@AutoConfigureMockMvc(addFilters = false)
public class EmpresaControllerTests {

    String BASE_URL = "/empresa";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpresaService empresaService;

    @Test
    public void testGetAllEmpresas() throws Exception {

        ArrayList<Empresa> empresas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Empresa newEmpresa = new Empresa();
            newEmpresa.setNombreEmpresa("Empresa " + i);
            newEmpresa.setCiudad("Cali");
            empresas.add(newEmpresa);
        }

        when(empresaService.getAllEmpresas()).thenReturn(empresas);

        mockMvc.perform(get(BASE_URL + "/all")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].nombreEmpresa").value("Empresa 0"))
                .andExpect(jsonPath("$[1].nombreEmpresa").value("Empresa 1"))
                .andExpect(jsonPath("$[2].nombreEmpresa").value("Empresa 2"))
                .andExpect(jsonPath("$[3].nombreEmpresa").value("Empresa 3"))
                .andExpect(jsonPath("$[4].nombreEmpresa").value("Empresa 4"))
                .andExpect(jsonPath("$[0].ciudad").value("Cali"))
                .andExpect(jsonPath("$[1].ciudad").value("Cali"))
                .andExpect(jsonPath("$[2].ciudad").value("Cali"))
                .andExpect(jsonPath("$[3].ciudad").value("Cali"))
                .andExpect(jsonPath("$[4].ciudad").value("Cali"));
    }

    @Test
    public void testGetEmpresaByName() throws Exception {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setNombre("Emcali");

        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Emcali");

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        empresa.setUsuario(usuario);

        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setNombreServicio("Alcantarillado");

        empresa.setTipoServicio(tipoServicio);

        when(empresaService.getEmpresaByName("Emcali")).thenReturn(empresa);

        mockMvc.perform(get(BASE_URL + "/nombre").param("nombreEmpresa", "Emcali"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Emcali"));
    }

    @Test
    public void testGetAllQuejasEmpresa() throws Exception {
        ArrayList<QuejaEmpresaDTO> quejas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            QuejaEmpresaDTO queja = new QuejaEmpresaDTO();
            queja.setIdQueja(i);
            queja.setTipoQueja("Incumplimiento");
            queja.setDescripcion("No hay servicio");
            queja.setNombreEmpresa("Emcali");
            quejas.add(queja);
        }

        when(empresaService.getAllQuejasEmpresa("Emcali")).thenReturn(quejas);

        mockMvc.perform(get(BASE_URL + "/quejasEmpresa").param("nombreEmpresa", "Emcali"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].idQueja").value(0))
                .andExpect(jsonPath("$[1].idQueja").value(1))
                .andExpect(jsonPath("$[2].idQueja").value(2))
                .andExpect(jsonPath("$[3].idQueja").value(3))
                .andExpect(jsonPath("$[4].idQueja").value(4));
    }

    @Test
    public void testDeleteEmpresa() throws Exception {
        when(empresaService.deleteEmpresaById(1)).thenReturn(true);

        mockMvc.perform(delete(BASE_URL + "/borrarEmpresaById").param("idUsuario", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllEmpresasPorTipoServicio() throws Exception {
        ArrayList<EmpresaDTO> empresas = new ArrayList<>();
        TipoServicio tipoServicio = new TipoServicio();
        for (int i = 0; i < 5; i++) {
            EmpresaDTO empresa = new EmpresaDTO();
            empresa.setNombre("Emcali");

            empresa.setTipoServicio("Alcantarillado");
            empresas.add(empresa);
        }

        when(empresaService.getEmpresasByTipoServicio("Alcantarillado")).thenReturn(empresas);

        mockMvc.perform(get(BASE_URL + "/empresasPorTipoServicio").param("nombreServicio", "Alcantarillado"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].nombre").value("Emcali"))
                .andExpect(jsonPath("$[1].nombre").value("Emcali"))
                .andExpect(jsonPath("$[2].nombre").value("Emcali"))
                .andExpect(jsonPath("$[3].nombre").value("Emcali"))
                .andExpect(jsonPath("$[4].nombre").value("Emcali"));
    }
}
