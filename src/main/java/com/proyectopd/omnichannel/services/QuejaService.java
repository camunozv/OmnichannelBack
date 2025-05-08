package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.*;

import java.util.List;

public interface QuejaService {

    // Implemented
    List<Queja> getAllQuejasEmpresa(String nombreEmpresa);
    List<Queja> getAllQuejasUsuario(Long idUsuario);

    Queja getQuejaById(Integer idQueja);


    boolean createQueja (Queja queja);
    boolean answerQueja(Respuesta respuesta, Integer idQueja);
    boolean assignProfesional();

    boolean updateDailyQuejas();

    // Not implemented
    boolean deleteQueja (Long idEmpresa, Long idUsuario, Long idQueja);
    Queja getQuejaByCompany(Long idEmpresa, Long idQueja);
    boolean updateQueja (Queja queja, Long idQueja);
//    boolean updateQueja (Queja queja, Long idQueja, Long idEmpresa, Long idUsuario);

}
