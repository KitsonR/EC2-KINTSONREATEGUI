package com.idat.EC2KINTSONREATEGUI.Repository;

import com.idat.EC2KINTSONREATEGUI.Modelo.Bodegas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegasRepository extends JpaRepository<Bodegas,Integer> {
}
