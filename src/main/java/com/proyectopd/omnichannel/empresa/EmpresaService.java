package com.proyectopd.omnichannel.empresa;

import java.util.List;

public interface EmpresaService {
    // Declarations for methods within service implementation
    boolean createEmpresa(Empresa empresa);
    boolean updateEmpresa(Long nit, Empresa empresa);
    boolean deleteEmpresa(Long nit);

    List<Empresa> getAllEmpresas();
    Empresa getEmpresaById(Long nit);
}
