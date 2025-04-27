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

    @PostMapping
    public ResponseEntity<String> createEmpresa(@RequestBody Empresa empresa) {
        boolean created = empresaService.createEmpresa(empresa);

        if (created) {
            return new ResponseEntity<>("Empresa creada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo crear la empresa", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        return new ResponseEntity<>(empresaService.getAllEmpresas(), HttpStatus.OK);
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long empresaId) {
        Empresa empresa = empresaService.getEmpresaById(empresaId);
        if (empresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        }
    }
}
