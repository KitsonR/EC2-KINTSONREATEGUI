package com.idat.EC2KINTSONREATEGUI.Service;


import com.idat.EC2KINTSONREATEGUI.DTO.UsuariosDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.UsuariosDTOResponse;
import com.idat.EC2KINTSONREATEGUI.Modelo.Usuarios;
import com.idat.EC2KINTSONREATEGUI.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosServices implements UsuariosService{
    @Autowired
    private UsuariosRepository repository;

    @Override
    public void guardarUsuario(UsuariosDTORequest Usuario) {

        Usuarios p = new Usuarios();
        p.setIdUsuario(Usuario.getIdUsuario());
        p.setUsuario(p.getUsuario());
        p.setPassword(p.getPassword());
        p.setRol(p.getRol());

        repository.save(p);
    }

    @Override
    public void actualizarUsuario(UsuariosDTORequest Usuario) {
        // TODO Auto-generated method stub

        Usuarios p = new Usuarios();
        p.setIdUsuario(Usuario.getIdUsuario());
        p.setUsuario(Usuario.getUsuario());
        p.setPassword(p.getPassword());
        p.setRol(p.getRol());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<UsuariosDTOResponse> listarUsuarios() {

        List<UsuariosDTOResponse> listar = new ArrayList<>();

        UsuariosDTOResponse dto = null;

        List<Usuarios> p = repository.findAll();

        for (Usuarios Usuarios : p) {

            dto = new UsuariosDTOResponse();

            dto.setRol(Usuarios.getRol());
            dto.setPassword(Usuarios.getPassword());
            dto.setUsuario(Usuarios.getUsuario());
            dto.setIdUsuario(Usuarios.getIdUsuario());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public UsuariosDTOResponse obtenerUsuarioId(Integer id) {
        // TODO Auto-generated method stub

        Usuarios Usuarios = repository.findById(id).orElse(null);
        UsuariosDTOResponse dto = new UsuariosDTOResponse();

        dto.setIdUsuario(Usuarios.getIdUsuario());
        dto.setRol(Usuarios.getRol());
        dto.setPassword(Usuarios.getPassword());
        dto.setUsuario(Usuarios.getUsuario());
        dto.setIdUsuario(Usuarios.getIdUsuario());

        return dto;
    }


}
