package com.idat.EC2KINTSONREATEGUI.DTO;

import com.idat.EC2KINTSONREATEGUI.Controller.Productos;

public class BodegasDTOResponse {


    private Integer idBodega;
    private String nombre;
    private String direccion;
    private Integer producto;

    private Productos productos;

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
