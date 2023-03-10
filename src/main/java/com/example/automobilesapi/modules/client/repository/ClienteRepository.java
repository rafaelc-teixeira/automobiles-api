package com.example.automobilesapi.modules.client.repository;

import com.example.automobilesapi.modules.client.model.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM CLIENTE WHERE id = ?1", nativeQuery = true)
    List<Cliente> getClienteById(Integer id);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO CLIENTE (IS_ADMIN, CPF, NOME, EMAIL, SENHA) " +
            "VALUES (:#{#cliente.admin}, :#{#cliente.cpf}, :#{#cliente.nome}, :#{#cliente.email}, :#{#cliente.senha})", nativeQuery = true)
    void createCliente(@Param("cliente") Cliente cliente);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CLIENTE SET IS_ADMIN = :#{#cliente.admin}, CPF = :#{#cliente.cpf}, NOME = :#{#cliente.nome}, " +
            "EMAIL = :#{#cliente.email}, SENHA = :#{#cliente.senha} " +
            "WHERE ID = :#{#cliente.id}", nativeQuery = true)
    void updateCliente(@Param("cliente") Cliente cliente);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM CLIENTE WHERE ID = ?1", nativeQuery = true)
    void deleteCliente(Integer id);

    @Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
    List<Cliente> findAllDisponiveis();
}
