package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.Queja;
import com.proyectopd.omnichannel.models.TipoQueja;

import java.util.List;

public interface QuejaService {

    // Implemented
    List<Queja> getAllQuejasEmpresa(Long idEmpresa);
    List<Queja> getAllQuejasUsuario(Long idUsuario);


    boolean createQueja (Queja queja);
    boolean answerQueja (String respuesta, Long idQueja);

    // Not implemented
    boolean deleteQueja (Long idEmpresa, Long idUsuario, Long idQueja);
    Queja getQuejaByCompany(Long idEmpresa, Long idQueja);
    boolean updateQueja (Queja queja, Long idQueja);
//    boolean updateQueja (Queja queja, Long idQueja, Long idEmpresa, Long idUsuario);

}
