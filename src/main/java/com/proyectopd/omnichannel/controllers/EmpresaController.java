package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.models.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.proyectopd.omnichannel.mappers.TipoServicioEmpresaDTOMapper.mapEmpresaToEmpresaDTO;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // Integration test pending
    @GetMapping("/all")
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        return new ResponseEntity<>(empresaService.getAllEmpresas(), HttpStatus.OK);
    }

    // Integration test pending
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

    @DeleteMapping("/borrar")
    public ResponseEntity<Boolean> deleteEmpresa(@RequestParam Integer idUsuario) {

        boolean deleted = empresaService.deleteEmpresaById(idUsuario);

        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
