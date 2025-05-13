package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.*;

import java.util.List;

public interface QuejaService {
    List<Queja> getAllQuejasEmpresa(String nombreEmpresa);
    Queja getQuejaById(Integer idQueja);
    boolean createQueja (Queja queja);
    boolean answerQueja(Respuesta respuesta, Integer idQueja);
    boolean assignProfesional();
    boolean updateDailyQuejas();
    boolean deleteQuejaById(Integer idQueja);
}
