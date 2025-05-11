package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.models.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        return new ResponseEntity<>(empresaService.getAllEmpresas(), HttpStatus.OK);
    }

    @GetMapping("/{nombreEmpresa}")
    public ResponseEntity<Empresa> getEmpresaByName(@PathVariable String nombreEmpresa) {
        return new ResponseEntity<>(empresaService.getEmpresaByName(nombreEmpresa), HttpStatus.OK);
    }

}
