package com.proyectopd.omnichannel.empresa.Implementation;

import com.proyectopd.omnichannel.empresa.Empresa;
import com.proyectopd.omnichannel.empresa.EmpresaService;

import java.util.List;

public class EmpresaServiceImplementation implements EmpresaService {
    @Override
    public boolean createEmpresa(Empresa empresa) {
        return false;
    }

    @Override
    public boolean updateEmpresa(Long nit, Empresa empresa) {
        return false;
    }

    @Override
    public boolean deleteEmpresa(Long nit) {
        return false;
    }

    @Override
    public List<Empresa> getAllEmpresas() {
        return List.of();
    }

    @Override
    public Empresa getEmpresaById(Long nit) {
        return null;
    }
}
