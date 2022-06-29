package com.idat.EC2KINTSONREATEGUI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC2KINTSONREATEGUI.DTO.UsuariosDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.UsuariosDTOResponse;
import com.idat.EC2KINTSONREATEGUI.Security.JWTUtil;
import com.idat.EC2KINTSONREATEGUI.Security.UserDetailService;


@RestController
public class Usuarios {

    @Autowired
    private JWTUtil util;

    @Autowired
    private UserDetailService service;


    @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
    public ResponseEntity<?> crearToken(@RequestBody UsuariosDTORequest request){

        UserDetails user = service.loadUserByUsername(request.getUsuario());
        return ResponseEntity.ok(new UsuariosDTOResponse(util.generateToken(user.getUsername())));

    }


}
