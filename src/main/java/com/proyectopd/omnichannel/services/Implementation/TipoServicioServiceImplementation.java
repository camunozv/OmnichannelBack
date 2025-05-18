package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.repositories.EmpresaRepository;
import com.proyectopd.omnichannel.repositories.TipoServicioRepository;
import com.proyectopd.omnichannel.services.TipoServicioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.proyectopd.omnichannel.mappers.TipoServicioEmpresaDTOMapper.mapEmpresaToEmpresaDTO;

@Service
public class TipoServicioServiceImplementation implements TipoServicioService {

    TipoServicioRepository tipoServicioRepository;

    // Comment it for the initialization to begin with the other constructor
    // ohterwise we get null pointer exception, witout any tipoServicioRepository
    // object initialized
    /*public TipoServicioServiceImplementation() {
    }*/

    public TipoServicioServiceImplementation(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    @Override
    public boolean createTipoServicio(TipoServicio newServicio) {

        boolean created;

        try {
            tipoServicioRepository.save(newServicio);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }

    @Override
    public ArrayList<EmpresaDTO> getAllEmpresasPorTipoServicio(String nombreServicio) {

        TipoServicio tipoServicio = tipoServicioRepository.findTipoServicioByNombreServicio(nombreServicio);
        List<Empresa> empresasTipoServicio = tipoServicio.getEmpresa();
        ArrayList<EmpresaDTO> empresasDTO = new ArrayList<>();
        for (Empresa empresa : empresasTipoServicio) {
            empresasDTO.add(mapEmpresaToEmpresaDTO(empresa));
        }
        return empresasDTO;
    }

    @Override
    public boolean deleteTipoServicioByNombreTipoServicio(String nombreServicio) {

        boolean deleted;

        try {
            tipoServicioRepository.deleteTipoServicioByNombreServicioEquals(nombreServicio);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }
}
