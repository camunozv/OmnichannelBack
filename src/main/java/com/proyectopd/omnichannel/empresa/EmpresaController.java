package com.proyectopd.omnichannel.empresa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
