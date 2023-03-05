package com.example.automobilesapi.modules.car.controller;

import com.example.automobilesapi.modules.car.dto.CarroDTO;

import com.example.automobilesapi.modules.car.service.CarroService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/carro")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> getAllCarros() {
        List<CarroDTO> carrosDTO = carroService.getAllCarros();
        return ResponseEntity.ok(carrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getCarroById(@PathVariable Integer id) {
        CarroDTO carro = carroService.getCarroById(id);
        if (carro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<CarroDTO> createCarro(@RequestBody CarroDTO carroDTO) {
        CarroDTO savedCarro = carroService.createCarro(carroDTO.toCarro());
        return ResponseEntity.created(URI.create("/carros/" + savedCarro.getId())).body(savedCarro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> updateCarro(@PathVariable Integer id, @RequestBody CarroDTO carroDTO) {
        CarroDTO updatedCarro = carroService.updateCarro(id, carroDTO.toCarro());
        return ResponseEntity.ok(updatedCarro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Integer id) {
        carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }

}