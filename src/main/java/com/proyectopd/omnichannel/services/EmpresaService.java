package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaToQuejaEmpresaDTO;

public interface EmpresaService {

    boolean deleteEmpresaById(Integer idUsuario) ;
    boolean createEmpresa(Empresa empresa);
    List<Empresa> getAllEmpresas();
    Empresa getEmpresaByName(String nombreEmpresa);
    ArrayList<QuejaEmpresaDTO> getAllQuejasEmpresa(String nombreEmpresa);
    List<EmpresaDTO> getEmpresasByTipoServicio(String tipoServicio);

}
