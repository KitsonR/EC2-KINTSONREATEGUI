package com.idat.EC2KINTSONREATEGUI.Modelo;

import javax.persistence.*;

@Entity
@Table(name="bodegas")
public class Bodegas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBodega;
    private String nombre;
    private String direccion;

    @OneToOne
    @JoinColumn(
            name = "idProducto",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idProducto) references Productos(idProducto)")
    )
    private Productos producto;

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

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}
