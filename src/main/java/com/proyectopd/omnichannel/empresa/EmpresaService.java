package com.proyectopd.omnichannel.empresa;

import java.util.List;

public interface EmpresaService {
    // Declarations for methods within service implementation
    // Not implemented
    boolean updateEmpresa(Long nit, Empresa empresa);
    boolean deleteEmpresa(Long nit);

    // Implemented
    boolean createEmpresa(Empresa empresa);
    List<Empresa> getAllEmpresas();
    Empresa getEmpresaById(Long nit);
}
