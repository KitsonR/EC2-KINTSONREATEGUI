package com.idat.EC2KINTSONREATEGUI.Service;

import com.idat.EC2KINTSONREATEGUI.DTO.ClientesDTORequest;
import com.idat.EC2KINTSONREATEGUI.DTO.ClientesDTOResponse;
import com.idat.EC2KINTSONREATEGUI.Modelo.Clientes;
import com.idat.EC2KINTSONREATEGUI.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesServices implements ClientesService {

    @Autowired
    private ClientesRepository repository;

    @Override
    public void guardarCliente(ClientesDTORequest Cliente) {

        Clientes p = new Clientes();
        p.setIdCliente(Cliente.getIdCliente());
        p.setDireccion(p.getDireccion());
        p.setDni(p.getDni());

        repository.save(p);
    }

    @Override
    public void actualizarCliente(ClientesDTORequest Cliente) {
        // TODO Auto-generated method stub

        Clientes p = new Clientes();
        p.setIdCliente(Cliente.getIdCliente());
        p.setNombres(Cliente.getNombres());
        p.setDireccion(p.getDireccion());
        p.setDni(p.getDni());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarCliente(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<ClientesDTOResponse> listarClientes() {

        List<ClientesDTOResponse> listar = new ArrayList<>();

        ClientesDTOResponse dto = null;

        List<Clientes> p = repository.findAll();

        for (Clientes Clientes : p) {

            dto = new ClientesDTOResponse();

            dto.setDni(Clientes.getDni());
            dto.setDireccion(Clientes.getDireccion());
            dto.setNombres(Clientes.getNombres());
            dto.setIdCliente(Clientes.getIdCliente());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public ClientesDTOResponse obtenerClienteId(Integer id) {
        // TODO Auto-generated method stub

        Clientes Clientes = repository.findById(id).orElse(null);
        ClientesDTOResponse dto = new ClientesDTOResponse();

        dto.setDni(Clientes.getDni());
        dto.setDireccion(Clientes.getDireccion());
        dto.setNombres(Clientes.getNombres());
        dto.setIdCliente(Clientes.getIdCliente());

        return dto;
    }

}
