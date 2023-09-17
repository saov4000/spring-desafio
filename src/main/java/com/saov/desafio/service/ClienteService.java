package com.saov.desafio.service;

import com.saov.desafio.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);
    void inserir(Cliente client);
    void atualizar(Long id, Cliente client);
    void deletar(Long id);
}
