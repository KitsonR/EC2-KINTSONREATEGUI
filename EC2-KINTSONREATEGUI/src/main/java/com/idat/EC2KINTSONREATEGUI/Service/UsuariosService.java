package com.idat.EC2KINTSONREATEGUI.Service;

import java.util.List;

import com.idat.EC2KINTSONREATEGUI.DTO.UsuariosDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.UsuariosDTOResponse;


public interface UsuariosService {

    void guardarUsuario(UsuariosDTORequest usuario);
    void actualizarUsuario(UsuariosDTORequest usuario);
    void eliminarUsuario(Integer id);
    List<UsuariosDTOResponse> listarUsuarios();
    UsuariosDTOResponse obtenerUsuarioId(Integer id);
}
