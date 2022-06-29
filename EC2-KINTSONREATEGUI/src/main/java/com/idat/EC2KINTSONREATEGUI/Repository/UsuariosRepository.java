package com.idat.EC2KINTSONREATEGUI.Repository;

import com.idat.EC2KINTSONREATEGUI.Modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {

}
