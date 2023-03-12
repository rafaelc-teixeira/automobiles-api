package com.example.automobilesapi.modules.car.service;

import com.example.automobilesapi.config.exception.ResourceNotFoundException;
import com.example.automobilesapi.modules.car.dto.CarroDTO;
import com.example.automobilesapi.modules.car.model.Carro;
import com.example.automobilesapi.modules.car.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {


    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
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
}
