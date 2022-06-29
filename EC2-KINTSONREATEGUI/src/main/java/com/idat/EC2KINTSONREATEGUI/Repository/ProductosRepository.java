package com.idat.EC2KINTSONREATEGUI.Repository;

import com.idat.EC2KINTSONREATEGUI.Modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos,Integer> {
}
