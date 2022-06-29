package com.idat.EC2KINTSONREATEGUI.Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String producto;
    private String descripcion;
    private Double precio;
    private Integer stock;

    @OneToOne(mappedBy = "producto")
    private Bodegas bodega;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "productosClientes",
            joinColumns = @JoinColumn(
                    name = "idProducto",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition =
                            "foreign key (idProducto) references productos(idProducto)")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "idCliente",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition =
                            "foreign key (idCliente) references clientes(idCliente)")
            )

    )	private List<Clientes> cliente = new ArrayList<>();

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Bodegas getBodega() {
        return bodega;
    }

    public void setBodega(Bodegas bodega) {
        this.bodega = bodega;
    }
}
