package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.TipoQueja;
import com.proyectopd.omnichannel.repositories.TipoQuejaRepository;
import com.proyectopd.omnichannel.services.TipoQuejaService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TipoQuejaServiceImplementation implements TipoQuejaService {

    TipoQuejaRepository tipoQuejaRepository;

    public TipoQuejaServiceImplementation(TipoQuejaRepository tipoQuejaRepository) {
        this.tipoQuejaRepository = tipoQuejaRepository;
    }


    @Override
    public boolean createTipoQueja(TipoQueja tipoQueja) {
        boolean created;
        try {
            tipoQuejaRepository.save(tipoQueja);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }

    @Override
    public TipoQueja getTipoQuejaById(String nombreTipoQueja) {

        TipoQueja tipoQueja = tipoQuejaRepository.getTipoQuejaByTipoQueja(nombreTipoQueja);

        if (Objects.equals(tipoQueja.getTipoQueja(), nombreTipoQueja)) {
            return tipoQueja;
        } else {
            return null;
        }

    }

    @Override
    public boolean deleteTipoQueja(String nombreTipoQueja) {

        boolean deleted = false;

        try {
            tipoQuejaRepository.deleteTipoQuejaByTipoQuejaEquals(nombreTipoQueja);
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            deleted = false;
        }

        return deleted;
    }
}
