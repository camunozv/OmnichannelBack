package com.proyectopd.omnichannel.dtos.createrespuesta;

public class QuejaRespuestaDTO {

    private Integer idRespuesta;
    private String textoRespuesta;

    private Integer idQueja;

    public QuejaRespuestaDTO(Integer idRespuesta, String textoRespuesta, Integer idQueja) {
        this.idRespuesta = idRespuesta;
        this.textoRespuesta = textoRespuesta;
        this.idQueja = idQueja;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public Integer getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(Integer idQueja) {
        this.idQueja = idQueja;
    }
}
