package com.example.automobilesapi.modules.car.repository;

import com.example.automobilesapi.modules.car.model.Carro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {

    @Query(value = "SELECT * FROM CARRO WHERE id = ?1", nativeQuery = true)
    Optional<Carro> getCarroById(Integer id);

    @Modifying
    @Query(value = "INSERT INTO CARRO (PLACA, MODELO, DESCRICAO, DISPONIBILIDADE, COMBUSTIVEL, NOME, MOTOR, POTENCIA, AUTONOMIA, VALOR_DIA, TAXA) " +
            "VALUES (:#{#carro.placa}, :#{#carro.modelo}, :#{#carro.descricao}, :#{#carro.disponibilidade}, :#{#carro.combustivel}, " +
            ":#{#carro.nome}, :#{#carro.motor}, :#{#carro.potencia}, :#{#carro.autonomia}, :#{#carro.valorDia}, :#{#carro.taxa})", nativeQuery = true)
    Carro createCarro(@Param("carro") Carro carro);

    @Modifying
    @Query(value = "UPDATE CARRO SET PLACA = :#{#carro.placa}, MODELO = :#{#carro.modelo}, DESCRICAO = :#{#carro.descricao}, " +
            "DISPONIBILIDADE = :#{#carro.disponibilidade}, COMBUSTIVEL = :#{#carro.combustivel}, NOME = :#{#carro.nome}, " +
            "MOTOR = :#{#carro.motor}, POTENCIA = :#{#carro.potencia}, AUTONOMIA = :#{#carro.autonomia}, VALOR_DIA = :#{#carro.valorDia}, TAXA = :#{#carro.taxa} " +
            "WHERE id = :#{#carro.id}", nativeQuery = true)
    Carro updateCarro(@Param("carro") Carro carro);

    @Modifying
    @Query(value = "DELETE FROM CARRO WHERE id = ?1", nativeQuery = true)
    void deleteCarro(Integer id);

    @Query(value = "SELECT * FROM CARRO WHERE DISPONIBILIDADE = TRUE", nativeQuery = true)
    List<Carro> findAllDisponiveis();

    @Query(value = "SELECT * FROM CARRO WHERE ID = :id AND DISPONIBILIDADE = TRUE", nativeQuery = true)
    Optional<Carro> findDisponivelById(@Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE CARRO SET DISPONIBILIDADE = :disponibilidade WHERE ID = :id", nativeQuery = true)
    void updateDisponibilidadeById(@Param("id") Integer id, @Param("disponibilidade") Boolean disponibilidade);

}
