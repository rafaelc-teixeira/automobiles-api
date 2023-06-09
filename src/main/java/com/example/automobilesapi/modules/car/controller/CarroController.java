package com.example.automobilesapi.modules.car.controller;

import com.example.automobilesapi.modules.car.dto.AluguelDTO;
import com.example.automobilesapi.modules.car.dto.CarroDTO;

import com.example.automobilesapi.modules.car.dto.DevolverCarroDTO;
import com.example.automobilesapi.modules.car.service.CarroService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/carro")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<CarroDTO>> getAllAvailableCarros() {
        List<CarroDTO> carrosDTO = carroService.getAllAvailableCarros();
        return ResponseEntity.ok(carrosDTO);
    }

    @GetMapping("/carros")
    public ResponseEntity<List<CarroDTO>> getAllCarros() {
        List<CarroDTO> carrosDTO = carroService.getAllAvailableCarros();
        return ResponseEntity.ok(carrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getCarroById(@PathVariable Integer id) {
        CarroDTO carroDTO = carroService.getCarroById(id);
        if (carroDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carroDTO);
    }

    @GetMapping("/alugados/{id}")
    public ResponseEntity<List<CarroDTO>> getCarrosAlugados(@PathVariable Integer id) {
        List<CarroDTO> carrosDTO = carroService.getCarrosAlugados(id);
        return ResponseEntity.ok(carrosDTO);
    }

    @PostMapping
    public ResponseEntity<CarroDTO> createCarro(@RequestBody CarroDTO carroDTO) {
        carroService.createCarro(carroDTO.toCarro());
        return ResponseEntity.created(URI.create("/api/carro")).body(carroDTO);
    }

    @PostMapping("/aluguel")
    public ResponseEntity<String> createAluguel(@RequestBody AluguelDTO aluguel) {
        carroService.createAluguel(aluguel);
        return ResponseEntity.ok("Aluguel realizado com sucesso!");
    }

    @PostMapping("/devolver")
    public ResponseEntity<String> devolverCarro(@RequestBody DevolverCarroDTO devolverCarro) {
        carroService.devolverCarro(devolverCarro);
        return ResponseEntity.ok("Carro devolvido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> updateCarro(@PathVariable Integer id, @RequestBody CarroDTO carroDTO) {
        carroService.updateCarro(id, carroDTO.toCarro());
        carroDTO.setId(id);
        return ResponseEntity.ok(carroDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Integer id) {
        carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }

}
