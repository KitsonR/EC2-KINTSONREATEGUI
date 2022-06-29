package com.idat.EC2KINTSONREATEGUI.Service;

import java.util.List;

import com.idat.EC2KINTSONREATEGUI.DTO.ProductosDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.ProductosDTOResponse;



public interface ProductosService {

    void guardarProducto(ProductosDTORequest producto);
    void actualizarProducto(ProductosDTORequest producto);
    void eliminarProducto(Integer id);
    List<ProductosDTOResponse> listarProductos();
    ProductosDTOResponse obtenerProductoId(Integer id);
}
