package com.proyectopd.omnichannel.controller;

import com.proyectopd.omnichannel.controllers.QuejaController;
import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.dtos.createrespuesta.QuejaRespuestaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.RespuestaService;
import com.proyectopd.omnichannel.services.TipoQuejaService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import com.google.gson.Gson;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaToQuejaEmpresaDTO;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuejaController.class)
@AutoConfigureMockMvc(addFilters = false)
public class QuejaControllerTests {

    String BASE_URL = "/quejas";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuejaService quejaService;
    @MockBean
    private TipoQuejaService tipoQuejaService;
    @MockBean
    private EmpresaService empresaService;
    @MockBean
    private RespuestaService respuestaService;


    @Test
    public void testGetQuejaById() throws Exception {
        TipoQueja tipoQueja = new TipoQueja();
        tipoQueja.setTipoQueja("Falla");

        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Empresa 1");

        Respuesta respuesta = new Respuesta();
        respuesta.setTextoRespuesta("Respuesta de la queja");

        Queja queja = new Queja();
        queja.setIdQueja(1);
        queja.setEstado("SIN RESOLVER");
        queja.setEmpresa(empresa);
        queja.setRespuesta(respuesta);
        queja.setTipoQueja(tipoQueja);

        when(quejaService.getQuejaById(1)).thenReturn(queja);

        QuejaEmpresaDTO quejaToReturn = mapQuejaToQuejaEmpresaDTO(queja);


        mockMvc.perform(get(BASE_URL + "/queja").param("idQueja", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoQueja").value("Falla"))
                .andExpect(jsonPath("$.nombreEmpresa").value("Empresa 1"))
                .andExpect(jsonPath("$.estado").value("SIN RESOLVER"));

    }

    @Test
    public void testGetRespuestaByQuejaId() throws Exception {
        Respuesta respuesta = new Respuesta();
        respuesta.setTextoRespuesta("Respuesta de la queja");

        Queja queja = new Queja();
        queja.setIdQueja(1);
        queja.setEstado("SIN RESOLVER");
        queja.setRespuesta(respuesta);

        when(quejaService.getQuejaById(1)).thenReturn(queja);

        mockMvc.perform(get(BASE_URL + "/respuesta").param("idQueja", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.textoRespuesta").value("Respuesta de la queja"));
    }

    /*@Test
    public void testRegistrarQueja() throws Exception {
        QuejaEmpresaDTO newQueja = new QuejaEmpresaDTO(1, "SIN RESOLVER", LocalDate.now(), "Descripcion", "BASE 64 STRING", "Falla", "Emcali");

        TipoQueja tipoQueja = new TipoQueja();
        tipoQueja.setTipoQueja("Falla");
        tipoQueja.setDias(10);

        when(tipoQuejaService.getTipoQuejaById(newQueja.getTipoQueja())).thenReturn(tipoQueja);

        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa("Empresa 1");

        when(empresaService.getEmpresaByName(newQueja.getNombreEmpresa())).thenReturn(empresa);

        when(quejaService.createQueja(ArgumentMatchers.any(Queja.class))).thenReturn(null);

        String requestBody = "{"
                + "\"estado\": \"" + newQueja.getEstado() + "\","
                + "\"tiempoMinimoRespuesta\": \"" + Date.valueOf(newQueja.getTiempoMinimoRespuesta()) + "\","
                + "\"descripcion\": \"" + newQueja.getDescripcion() + "\","
                + "\"archivo\": \"" + newQueja.getArchivo() + "\","
                + "\"tipoQueja\": \"" + newQueja.getTipoQueja() + "\","
                + "\"nombreEmpresa\": \"" + newQueja.getNombreEmpresa() + "\""
                + "}";


        mockMvc.perform(post(BASE_URL + "/nuevaQueja")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody).characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idQueja").value(1))
                .andExpect(jsonPath("$.estado").value("SIN RESOLVER"));
    }*/

    @Test
    public void testResponderQueja() throws Exception {
        QuejaRespuestaDTO newRespuestaDTO = new QuejaRespuestaDTO();
        newRespuestaDTO.setIdQueja(1);
        newRespuestaDTO.setTextoRespuesta("Respuesta a la queja 1");

        Queja quejaToAnswer = new Queja();
        quejaToAnswer.setIdQueja(1);
        quejaToAnswer.setEstado("SIN RESOLVER");
        quejaToAnswer.setEmpresa(new Empresa());
        quejaToAnswer.setTipoQueja(new TipoQueja());
        quejaToAnswer.setDescripcion("Descripcion");
        quejaToAnswer.setTiempoMinimoRespuesta(LocalDate.now());

        when(quejaService.getQuejaById(1)).thenReturn(quejaToAnswer);
        when(respuestaService.createRespuesta(ArgumentMatchers.any(Respuesta.class))).thenReturn(true);
        when(quejaService.answerQueja(ArgumentMatchers.any(Respuesta.class), ArgumentMatchers.anyInt())).thenReturn(true);

        Gson gson = new Gson();

        String body = gson.toJson(newRespuestaDTO);

        mockMvc.perform(put(BASE_URL + "/responderQueja")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idQueja").value(1))
                .andExpect(jsonPath("$.textoRespuesta").value("Respuesta a la queja 1"));
    }

    @Test
    public void testDeleteQueja() throws Exception {
        when(quejaService.deleteQuejaById(1)).thenReturn(true);

        mockMvc.perform(delete(BASE_URL + "/borrarQueja").param("idQueja", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }


    @Test
    public void testGetQuejasPorEstado() throws Exception {
        TipoQueja tipoQueja1 = new TipoQueja();
        tipoQueja1.setTipoQueja("Falla");

        Empresa empresa1 = new Empresa();
        empresa1.setNombreEmpresa("Empresa A");

        Queja queja1 = new Queja();
        queja1.setIdQueja(1);
        queja1.setEstado("RESUELTO");
        queja1.setEmpresa(empresa1);
        queja1.setTipoQueja(tipoQueja1);
        queja1.setDescripcion("Problema resuelto");
        queja1.setTiempoMinimoRespuesta(LocalDate.now());

        Respuesta respuesta1 = new Respuesta();
        respuesta1.setTextoRespuesta("Respuesta para queja 1");
        queja1.setRespuesta(respuesta1);


        TipoQueja tipoQueja2 = new TipoQueja();
        tipoQueja2.setTipoQueja("Soporte");

        Empresa empresa2 = new Empresa();
        empresa2.setNombreEmpresa("Empresa B");

        Queja queja2 = new Queja();
        queja2.setIdQueja(2);
        queja2.setEstado("RESUELTO");
        queja2.setEmpresa(empresa2);
        queja2.setTipoQueja(tipoQueja2);
        queja2.setDescripcion("Soporte brindado");
        queja2.setTiempoMinimoRespuesta(LocalDate.now());

        Respuesta respuesta2 = new Respuesta();
        respuesta2.setTextoRespuesta("Respuesta para queja 2");
        queja2.setRespuesta(respuesta2);

        ArrayList<Queja> resolvedQuejas = new ArrayList<>();

        resolvedQuejas.add(queja1);
        resolvedQuejas.add(queja2);

        when(quejaService.getQuejasByEstado("RESUELTO")).thenReturn(resolvedQuejas);

        mockMvc.perform(get(BASE_URL + "/quejasPorEstado").param("estado", "RESUELTO"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].descripcion").value("Problema resuelto"))
                .andExpect(jsonPath("$[1].descripcion").value("Soporte brindado"));
    }
}
