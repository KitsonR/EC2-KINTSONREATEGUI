package com.idat.EC2KINTSONREATEGUI.Repository;

import com.idat.EC2KINTSONREATEGUI.Modelo.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes,Integer> {
}
