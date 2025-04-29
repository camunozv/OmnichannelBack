package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.services.EmpresaService;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.repositories.QuejaRepository;
import com.proyectopd.omnichannel.services.QuejaService;
import com.proyectopd.omnichannel.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuejaServiceImplementation implements QuejaService {

    QuejaRepository quejaRepository;
    EmpresaService empresaService;
    UsuarioService usuarioService;

    public QuejaServiceImplementation(QuejaRepository quejaRepository, EmpresaService empresaService, UsuarioService usuarioService) {
        this.quejaRepository = quejaRepository;
        this.empresaService = empresaService;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Queja> getAllQuejasEmpresa(Long idEmpresa) {
        return List.of();
    }

    @Override
    public List<Queja> getAllQuejasUsuario(Long idUsuario) {
        return List.of();
    }

    @Override
    public Queja getQuejaByCompany(Long idEmpresa, Long idQueja) {
        return null;
    }

    @Override
    public boolean createQueja(Queja queja) {
        boolean created;

        try {
            quejaRepository.save(queja);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }

    @Override
    public boolean answerQueja(String respuesta, Long idQueja) {

        boolean answered = false;
        Optional<Queja> quejaOptional = quejaRepository.findById(idQueja);

        /*if (quejaOptional.isPresent()) {
            Queja queja = quejaOptional.get();
            queja.setRespuesta(respuesta);
            quejaRepository.save(queja);
            answered = true;
        }*/

        return answered;
    }


    @Override
    public boolean deleteQueja(Long idEmpresa, Long idUsuario, Long idQueja) {
        return false;
    }

    @Override
    public boolean updateQueja(Queja queja, Long idQueja) {
        return false;
    }
}
