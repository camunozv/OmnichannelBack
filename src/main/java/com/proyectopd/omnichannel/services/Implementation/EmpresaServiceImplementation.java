package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.repositories.EmpresaRepository;
import com.proyectopd.omnichannel.services.EmpresaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImplementation implements EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaServiceImplementation(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public boolean createEmpresa(Empresa empresa) {

        boolean created;

        try{
            empresaRepository.save(empresa);
            created = true;
        } catch(Exception e) {
            created = false;
        }

        return created;
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
        return empresaRepository.findAll();
    }

    @Override
    public Empresa getEmpresaByName(String nombreEmpresa) {
        return empresaRepository.findEmpresaByNombreEmpresa(nombreEmpresa);
    }
}
