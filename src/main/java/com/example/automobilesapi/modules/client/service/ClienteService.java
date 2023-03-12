package com.example.automobilesapi.modules.client.service;

import com.example.automobilesapi.config.exception.ResourceNotFoundException;
import com.example.automobilesapi.modules.client.dto.ClienteDTO;
import com.example.automobilesapi.modules.client.dto.ClienteDTOAdminRequest;
import com.example.automobilesapi.modules.client.model.Cliente;
import com.example.automobilesapi.modules.client.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAllDisponiveis();
        return clientes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO getClienteById(Integer id) {
        List<Cliente> optionalCliente = clienteRepository.getClienteById(id);
        if (!optionalCliente.isEmpty()) {
            return optionalCliente.get(0).convertToDTO();
        } else {
            throw new ResourceNotFoundException("Cliente not found with id " + id);
        }
    }

    public void createCliente(Cliente cliente) {
        clienteRepository.createCliente(cliente);
    }

    public void updateCliente(Integer id, Cliente cliente) {
        List<Cliente> optionalCliente = clienteRepository.getClienteById(id);
        if (!optionalCliente.isEmpty()) {
            cliente.setId(id);
            clienteRepository.updateCliente(cliente);
        } else {
            throw new ResourceNotFoundException("Cliente not found with id " + id);
        }
    }

    public void deleteCliente(Integer id) {
        List<Cliente> optionalCliente = clienteRepository.getClienteById(id);
        if (optionalCliente.isEmpty()) {
            clienteRepository.deleteCliente(id);
        } else {
            throw new ResourceNotFoundException("Cliente not found with id " + id);
        }
    }

    private ClienteDTO convertToDTO(Cliente cliente) {
        return cliente.convertToDTO();
    }

    public ClienteDTO verifyCliente(ClienteDTOAdminRequest cliente) {
        List<Cliente> optionalCliente = clienteRepository.verifyCliente(cliente);
        if (!optionalCliente.isEmpty()) {
            return optionalCliente.get(0).convertToDTO();
        } else {
            throw new ResourceNotFoundException("Cliente not found with cpf " + cliente.getCpf());
        }
    }
}
