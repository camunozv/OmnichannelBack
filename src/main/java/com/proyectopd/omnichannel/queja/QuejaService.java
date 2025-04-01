package com.proyectopd.omnichannel.queja;

import java.util.List;

public interface QuejaService {

    List<Queja> getAllQuejasEmpresa(Long idEmpresa);
    List<Queja> getAllQuejasUsuario(Long idUsuario);
    Queja getQuejaByCompany(Long idEmpresa, Long idQueja);

    boolean createQueja (Queja queja);
    boolean deleteQueja (Long idEmpresa, Long idUsuario, Long idQueja);
    boolean updateQueja (Queja queja, Long idQueja);
//    boolean updateQueja (Queja queja, Long idQueja, Long idEmpresa, Long idUsuario);

}
