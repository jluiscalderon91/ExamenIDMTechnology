package com.bci.apicliente.repository;
import com.bci.apicliente.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    //Optional<Cliente> findOneByUsuario(String usuario);
}
