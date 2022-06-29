package com.idat.EC2KINTSONREATEGUI.Service;

import java.util.List;

import com.idat.EC2KINTSONREATEGUI.DTO.BodegasDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.BodegasDTOResponse;



public interface BodegasService {
    void guardarBodega(BodegasDTORequest bodega);
    void actualizarBodega(BodegasDTORequest bodega);
    void eliminarBodega(Integer id);
    List<BodegasDTOResponse> listarBodegas();
    BodegasDTOResponse obtenerBodegaId(Integer id);

}

