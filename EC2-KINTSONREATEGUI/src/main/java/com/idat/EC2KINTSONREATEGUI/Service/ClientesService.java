package com.idat.EC2KINTSONREATEGUI.Service;

import java.util.List;

import com.idat.EC2KINTSONREATEGUI.DTO.ClientesDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.ClientesDTOResponse;



public interface ClientesService {

    void guardarCliente(ClientesDTORequest cliente);
    void actualizarCliente(ClientesDTORequest cliente);
    void eliminarCliente(Integer id);
    List<ClientesDTOResponse> listarClientes();
    ClientesDTOResponse obtenerClienteId(Integer id);
    
}