package com.example.automobilesapi.modules.car.repository;

import com.example.automobilesapi.modules.car.model.Carro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {


    @Query(value = "SELECT * FROM CARRO WHERE ID = ?1", nativeQuery = true)
    List<Carro> getCarroById(Integer id);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO CARRO (AUTONOMIA, COMBUSTIVEL, DESCRICAO, DISPONIBILIDADE, MODELO, MOTOR, NOME, PLACA, POTENCIA, TAXA, VALOR_DIA) " +
            "VALUES (:#{#carro.autonomia}, :#{#carro.combustivel}, :#{#carro.descricao}, :#{#carro.disponibilidade}, :#{#carro.modelo}, " +
            ":#{#carro.motor}, :#{#carro.nome}, :#{#carro.placa}, :#{#carro.potencia}, :#{#carro.taxa}, :#{#carro.valorDia})", nativeQuery = true)
    void createCarro(@Param("carro") Carro carro);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CARRO SET PLACA = :#{#carro.placa}, MODELO = :#{#carro.modelo}, DESCRICAO = :#{#carro.descricao}, " +
            "DISPONIBILIDADE = :#{#carro.disponibilidade}, COMBUSTIVEL = :#{#carro.combustivel}, NOME = :#{#carro.nome}, " +
            "MOTOR = :#{#carro.motor}, POTENCIA = :#{#carro.potencia}, AUTONOMIA = :#{#carro.autonomia}, VALOR_DIA = :#{#carro.valorDia}, TAXA = :#{#carro.taxa} " +
            "WHERE ID = :#{#carro.id}", nativeQuery = true)
    void updateCarro(@Param("carro") Carro carro);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM CARRO WHERE ID = ?1", nativeQuery = true)
    void deleteCarro(Integer id);

    @Query(value = "SELECT * FROM CARRO WHERE DISPONIBILIDADE = TRUE", nativeQuery = true)
    List<Carro> findAllDisponiveis();
//
//    @Query(value = "SELECT * FROM CARRO WHERE ID = :id AND DISPONIBILIDADE = TRUE", nativeQuery = true)
//    Optional<Carro> findDisponivelById(@Param("id") Integer id);
//
//    @Modifying
//    @Query(value = "UPDATE CARRO SET DISPONIBILIDADE = :disponibilidade WHERE ID = :id", nativeQuery = true)
//    void updateDisponibilidadeById(@Param("id") Integer id, @Param("disponibilidade") Boolean disponibilidade);

}
