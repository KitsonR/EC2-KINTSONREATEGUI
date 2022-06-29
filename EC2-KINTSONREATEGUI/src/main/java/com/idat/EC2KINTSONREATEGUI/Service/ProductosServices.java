package com.idat.EC2KINTSONREATEGUI.Service;

import com.idat.EC2KINTSONREATEGUI.DTO.ProductosDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.ProductosDTOResponse;
import com.idat.EC2KINTSONREATEGUI.Modelo.Productos;
import com.idat.EC2KINTSONREATEGUI.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosServices implements ProductosService {

    @Autowired
    private ProductosRepository repository;

    @Override
    public void guardarProducto(ProductosDTORequest Producto) {

        Productos p = new Productos();
        p.setIdProducto(Producto.getIdProducto());
        p.setProducto(p.getProducto());
        p.setDescripcion(p.getDescripcion());
        p.setPrecio(p.getPrecio());
        p.setStock(p.getStock());

        repository.save(p);
    }

    @Override
    public void actualizarProducto(ProductosDTORequest Producto) {
        // TODO Auto-generated method stub

        Productos p = new Productos();
        p.setIdProducto(Producto.getIdProducto());
        p.setProducto(Producto.getProducto());
        p.setDescripcion(p.getDescripcion());
        p.setPrecio(p.getPrecio());
        p.setStock(p.getStock());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarProducto(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<ProductosDTOResponse> listarProductos() {

        List<ProductosDTOResponse> listar = new ArrayList<>();

        ProductosDTOResponse dto = null;

        List<Productos> p = repository.findAll();

        for (Productos Productos : p) {

            dto = new ProductosDTOResponse();

            dto.setStock(Productos.getStock());
            dto.setPrecio(Productos.getPrecio());
            dto.setDescripcion(Productos.getDescripcion());
            dto.setProducto(Productos.getProducto());
            dto.setIdProducto(Productos.getIdProducto());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public ProductosDTOResponse obtenerProductoId(Integer id) {
        // TODO Auto-generated method stub

        Productos Productos = repository.findById(id).orElse(null);
        ProductosDTOResponse dto = new ProductosDTOResponse();

        dto.setStock(Productos.getStock());
        dto.setPrecio(Productos.getPrecio());
        dto.setDescripcion(Productos.getDescripcion());
        dto.setProducto(Productos.getProducto());
        dto.setIdProducto(Productos.getIdProducto());

        return dto;
    }



}
