package com.proyectopd.omnichannel.queja;

import com.proyectopd.omnichannel.usuario.Usuario;

import java.util.List;

public interface QuejaService {

    // Implemented
    List<Queja> getAllQuejasEmpresa(Long idEmpresa);
    List<Queja> getAllQuejasUsuario(Long idUsuario);
    boolean createQueja (Queja queja, Long cedula, Long nit);
    boolean updateQueja (Queja queja, Long idQueja);

    // Not implemented
    boolean deleteQueja (Long idEmpresa, Long idUsuario, Long idQueja);
    Queja getQuejaByCompany(Long idEmpresa, Long idQueja);
//    boolean updateQueja (Queja queja, Long idQueja, Long idEmpresa, Long idUsuario);

}
