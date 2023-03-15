package com.example.automobilesapi.modules.car.service;

import com.example.automobilesapi.config.exception.ResourceNotFoundException;
import com.example.automobilesapi.modules.car.dto.AluguelDTO;
import com.example.automobilesapi.modules.car.dto.CarroDTO;
import com.example.automobilesapi.modules.car.dto.DevolverCarroDTO;
import com.example.automobilesapi.modules.car.model.Carro;
import com.example.automobilesapi.modules.car.repository.CarroRepository;
import com.example.automobilesapi.modules.client.model.Cliente;
import com.example.automobilesapi.modules.client.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {


    private final CarroRepository carroRepository;

    private final ClienteRepository clienteRepository;

    public CarroService(CarroRepository carroRepository, ClienteRepository clienteRepository) {
        this.carroRepository = carroRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<CarroDTO> getAllCarros() {
        List<Carro> carros = carroRepository.findAllDisponiveis();
        return carros.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CarroDTO getCarroById(Integer id) {
        List<Carro> optionalCarro = carroRepository.getCarroById(id);
        if (!optionalCarro.isEmpty()) {
            return optionalCarro.get(0).convertToDTO();
        } else {
            throw new ResourceNotFoundException("Carro not found with id " + id);
        }
    }

    public void createCarro(Carro carro) {
        carroRepository.createCarro(carro);
    }

    public void updateCarro(Integer id, Carro carro) {
        List<Carro> optionalCarro = carroRepository.getCarroById(id);
        if (!optionalCarro.isEmpty()) {
            carro.setId(id);
            carroRepository.updateCarro(carro);
        } else {
            throw new ResourceNotFoundException("Carro not found with id " + id);
        }
    }

    public void deleteCarro(Integer id) {
        List<Carro> optionalCarro = carroRepository.getCarroById(id);
        if (!optionalCarro.isEmpty()) {
            carroRepository.deleteCarro(id);
        } else {
            throw new ResourceNotFoundException("Carro not found with id " + id);
        }
    }

    private CarroDTO convertToDTO(Carro carro) {
        return carro.convertToDTO();
    }

    private Carro convertToEntity(CarroDTO carroDTO) {
        Carro carro = new Carro();
        carro.setPlaca(carroDTO.getPlaca());
        carro.setModelo(carroDTO.getModelo());
        carro.setDescricao(carroDTO.getDescricao());
        carro.setDisponibilidade(carroDTO.getDisponibilidade());
        carro.setCombustivel(carroDTO.getCombustivel());
        carro.setNome(carroDTO.getNome());
        carro.setMotor(carroDTO.getMotor());
        carro.setPotencia(carroDTO.getPotencia());
        carro.setAutonomia(carroDTO.getAutonomia());
        return carro;
    }

    public void createAluguel(AluguelDTO aluguel) {
        List<Cliente> cliente = clienteRepository.verifyClienteCpf(aluguel.getCpf());

        if (!cliente.isEmpty()) {
            carroRepository.createAluguel(cliente.get(0).getId(), aluguel.getCarroId(), aluguel.getData());
        } else {
            throw new ResourceNotFoundException("Cliente not found with cpf " + aluguel.getCpf());
        }
    }

    public void devolverCarro(DevolverCarroDTO devolverCarro) {
        List<Cliente> cliente = clienteRepository.verifyClienteCpf(devolverCarro.getCpf());
        List<Carro> carro = carroRepository.verifyCarroPlaca(devolverCarro.getPlaca());

        if (!cliente.isEmpty() && !carro.isEmpty()) {
            carroRepository.returnCarro(cliente.get(0).getId(), carro.get(0).getId());
        } else {
            throw new ResourceNotFoundException("Cliente not found with cpf or placa " + devolverCarro.getCpf() + "//"+ devolverCarro.getPlaca());
        }

    }

    public List<CarroDTO> getCarrosAlugados(Integer id) {
        List<Carro> carros = carroRepository.getCarrosAlugados(id);
        return carros.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
