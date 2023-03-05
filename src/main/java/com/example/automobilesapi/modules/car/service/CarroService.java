package com.example.automobilesapi.modules.car.service;

import com.example.automobilesapi.config.exception.ResourceNotFoundException;
import com.example.automobilesapi.modules.car.dto.CarroDTO;
import com.example.automobilesapi.modules.car.model.Carro;
import com.example.automobilesapi.modules.car.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarroDTO> getAllCarros() {
        List<Carro> carros = (List<Carro>) carroRepository.findAll();
        return carros.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CarroDTO getCarroById(Integer id) {
        Optional<Carro> optionalCarro = carroRepository.getCarroById(id);
        if (optionalCarro.isPresent()) {
            return optionalCarro.get().convertToDTO();
        } else {
            throw new ResourceNotFoundException("Carro not found with id " + id);
        }
    }

    public CarroDTO createCarro(Carro carro) {
        Carro savedCarro = carroRepository.createCarro(carro);
        return convertToDTO(savedCarro);
    }

    public CarroDTO updateCarro(Integer id, Carro carro) {
        Optional<Carro> optionalCarro = carroRepository.getCarroById(id);
        if (optionalCarro.isPresent()) {
            carro.setId(id);
            Carro updatedCarro = carroRepository.updateCarro(carro);
            return convertToDTO(updatedCarro);
        } else {
            throw new ResourceNotFoundException("Carro not found with id " + id);
        }
    }

    public void deleteCarro(Integer id) {
        Optional<Carro> optionalCarro = carroRepository.findById(id);
        if (optionalCarro.isPresent()) {
            carroRepository.deleteCarro(id);
        } else {
            throw new ResourceNotFoundException("Carro not found with id " + id);
        }
    }

    private CarroDTO convertToDTO(Carro carro) {
        return new CarroDTO(carro.getId(), carro.getPlaca(), carro.getModelo(),
                carro.getDescricao(), carro.getDisponibilidade(), carro.getCombustivel(),
                carro.getNome(), carro.getMotor(), carro.getPotencia(), carro.getAutonomia(), carro.getValorDia(), carro.getTaxa());
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
