package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.models.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.proyectopd.omnichannel.mappers.TipoServicioEmpresaDTOMapper.mapEmpresaToEmpresaDTO;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // Tested
    @GetMapping("/all")
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        return new ResponseEntity<>(empresaService.getAllEmpresas(), HttpStatus.OK);
    }

    // Tested
    @GetMapping("/nombre")
    public ResponseEntity<EmpresaDTO> getEmpresaByName(@RequestParam String nombreEmpresa) {

        Empresa empresa = empresaService.getEmpresaByName(nombreEmpresa);
        EmpresaDTO empresaDTO = null;
        if (empresa != null) {
            empresaDTO = mapEmpresaToEmpresaDTO(empresa);
            return new ResponseEntity<>(empresaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    // Tested
    // Reenvío de queja a la empresa, según parametrización
    @GetMapping("/quejasEmpresa")
    public ResponseEntity<ArrayList<QuejaEmpresaDTO>> getAllQuejasEmpresa(@RequestParam String nombreEmpresa) {
        try {
            ArrayList<QuejaEmpresaDTO> list = empresaService.getAllQuejasEmpresa(nombreEmpresa);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Tested
    @DeleteMapping("/borrarEmpresaById")
    public ResponseEntity<Boolean> deleteEmpresa(@RequestParam Integer idUsuario) {

        boolean deleted = empresaService.deleteEmpresaById(idUsuario);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // Tested
    @GetMapping("/empresasPorTipoServicio")
    public ResponseEntity<List<EmpresaDTO>> getAllEmpresasPorTipoServicio(@RequestParam String nombreServicio) {
        List<EmpresaDTO> empresas = empresaService.getEmpresasByTipoServicio(nombreServicio);
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }
}
