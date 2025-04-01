package com.proyectopd.omnichannel.queja.Implementation;

import com.proyectopd.omnichannel.queja.Queja;
import com.proyectopd.omnichannel.queja.QuejaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuejaServiceImplementation implements QuejaService {

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
        return false;
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
