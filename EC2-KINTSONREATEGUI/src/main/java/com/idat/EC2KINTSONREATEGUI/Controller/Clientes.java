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

import com.idat.EC2KINTSONREATEGUI.DTO.ClientesDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.ClientesDTOResponse;
import com.idat.EC2KINTSONREATEGUI.Service.ClientesService;



@Controller
@RequestMapping( path = "/clientes/v1")
public class Clientes {

    @Autowired
    private ClientesService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<ClientesDTOResponse>> listar() {

        return new ResponseEntity<List<ClientesDTOResponse>>(service.listarClientes(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody ClientesDTORequest Clientes) {
        service.guardarCliente(Clientes);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ClientesDTOResponse p =service.obtenerClienteId(id);
        if(p != null) {
            service.eliminarCliente(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody ClientesDTORequest Clientes) {
        ClientesDTOResponse p =service.obtenerClienteId(Clientes.getIdCliente());
        if(p != null) {
            service.actualizarCliente(Clientes);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClientesDTOResponse> obtenerId(@PathVariable Integer id) {
        ClientesDTOResponse p =service.obtenerClienteId(id);
        if(p != null) {
            return  new ResponseEntity<ClientesDTOResponse>(service.obtenerClienteId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<ClientesDTOResponse>(HttpStatus.NOT_FOUND);
    }


}