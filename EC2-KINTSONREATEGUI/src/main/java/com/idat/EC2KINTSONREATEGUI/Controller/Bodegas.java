package com.idat.EC2KINTSONREATEGUI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EC2KINTSONREATEGUI.DTO.BodegasDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.BodegasDTOResponse;
import com.idat.EC2KINTSONREATEGUI.Service.BodegasService;

@Controller
@RequestMapping( path = "/bodegas/v1")
public class Bodegas {

	@Autowired
    private BodegasService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<BodegasDTOResponse>> listar() {

        return new ResponseEntity<List<BodegasDTOResponse>>(service.listarBodegas(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody BodegasDTORequest Bodegas) {
        service.guardarBodega(Bodegas);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        BodegasDTOResponse p =service.obtenerBodegaId(id);
        if(p != null) {
            service.eliminarBodega(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody BodegasDTORequest Bodegas) {
        BodegasDTOResponse p =service.obtenerBodegaId(Bodegas.getIdBodega());
        if(p != null) {
            service.actualizarBodega(Bodegas);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<BodegasDTOResponse> obtenerId(@PathVariable Integer id) {
        BodegasDTOResponse p =service.obtenerBodegaId(id);
        if(p != null) {
            return  new ResponseEntity<BodegasDTOResponse>(service.obtenerBodegaId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<BodegasDTOResponse>(HttpStatus.NOT_FOUND);
    }

}


