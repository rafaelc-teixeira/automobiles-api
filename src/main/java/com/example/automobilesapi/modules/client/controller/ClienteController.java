package com.example.automobilesapi.modules.client.controller;

import com.example.automobilesapi.modules.client.dto.ClienteDTO;
import com.example.automobilesapi.modules.client.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientesDTO = clienteService.getAllClientes();
        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        ClienteDTO clienteDTO = clienteService.getClienteById(id);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.createCliente(clienteDTO.toCliente());
        return ResponseEntity.created(URI.create("/api/cliente")).body(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.updateCliente(id, clienteDTO.toCliente());
        clienteDTO.setId(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Integer id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
