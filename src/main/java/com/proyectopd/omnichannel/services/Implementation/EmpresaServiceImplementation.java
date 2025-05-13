package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.Usuario;
import com.proyectopd.omnichannel.repositories.EmpresaRepository;
import com.proyectopd.omnichannel.repositories.UsuarioRepository;
import com.proyectopd.omnichannel.services.EmpresaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.proyectopd.omnichannel.mappers.QuejaEmpresaDTOMapper.mapQuejaToQuejaEmpresaDTO;

@Service
public class EmpresaServiceImplementation implements EmpresaService {

    private EmpresaRepository empresaRepository;
    private UsuarioRepository usuarioRepository;

    public EmpresaServiceImplementation(EmpresaRepository empresaRepository, UsuarioRepository usuarioRepository) {
        this.empresaRepository = empresaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean createEmpresa(Empresa empresa) {

        boolean created;

        try {
            empresaRepository.save(empresa);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }

    @Override
    public boolean deleteEmpresaById(Integer idUsuario) {

        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

        boolean deleted = false;
        if (usuario != null) {
            empresaRepository.deleteEmpresaByNombreEmpresa(usuario.getEmpresa().getNombreEmpresa());
            usuarioRepository.deleteUsuarioByIdUsuario(idUsuario);
            deleted = true;
        }

        return deleted;
    }

    @Override
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa getEmpresaByName(String nombreEmpresa) {
        return empresaRepository.findEmpresaByNombreEmpresa(nombreEmpresa);
    }

    @Override
    public ArrayList<QuejaEmpresaDTO> getAllQuejasEmpresa(String nombreEmpresa) {

        Empresa empresa = empresaRepository.findEmpresaByNombreEmpresa(nombreEmpresa);
        ArrayList<QuejaEmpresaDTO> listOfComplains = new ArrayList<>();

        if (empresa != null) {
            for (Queja quejaToMap : empresa.getQuejas()) {
                listOfComplains.add(mapQuejaToQuejaEmpresaDTO(quejaToMap));
            }
        }

        return listOfComplains;
    }
}
