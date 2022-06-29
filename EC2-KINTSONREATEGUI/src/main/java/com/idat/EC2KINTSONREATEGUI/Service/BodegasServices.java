package com.idat.EC2KINTSONREATEGUI.Service;

import com.idat.EC2KINTSONREATEGUI.DTO.BodegasDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.BodegasDTOResponse;
import com.idat.EC2KINTSONREATEGUI.Modelo.Bodegas;
import com.idat.EC2KINTSONREATEGUI.Repository.BodegasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodegasServices implements BodegasService {


    @Autowired
    private BodegasRepository repository;

    @Override
    public void guardarBodega(BodegasDTORequest Bodega) {

        Bodegas p = new Bodegas();
        p.setIdBodega(Bodega.getIdBodega());
        p.setDireccion(p.getDireccion());

        repository.save(p);
    }

    @Override
    public void actualizarBodega(BodegasDTORequest Bodega) {
        // TODO Auto-generated method stub

        Bodegas p = new Bodegas();
        p.setIdBodega(Bodega.getIdBodega());
        p.setNombre(Bodega.getNombre());
        p.setDireccion(p.getDireccion());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarBodega(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<BodegasDTOResponse> listarBodegas() {

        List<BodegasDTOResponse> listar = new ArrayList<>();

        BodegasDTOResponse dto = null;

        List<Bodegas> p = repository.findAll();

        for (Bodegas Bodegas : p) {

            dto = new BodegasDTOResponse();

            dto.setDireccion(Bodegas.getDireccion());
            dto.setNombre(Bodegas.getNombre());
            dto.setIdBodega(Bodegas.getIdBodega());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public BodegasDTOResponse obtenerBodegaId(Integer id) {
        // TODO Auto-generated method stub

        Bodegas Bodegas = repository.findById(id).orElse(null);
        BodegasDTOResponse dto = new BodegasDTOResponse();

        dto.setDireccion(Bodegas.getDireccion());
        dto.setNombre(Bodegas.getNombre());
        dto.setIdBodega(Bodegas.getIdBodega());

        return dto;
    }


}
