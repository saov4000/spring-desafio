package com.saov.desafio.service.impl;

import com.saov.desafio.model.Cliente;
import com.saov.desafio.model.ClienteRepository;
import com.saov.desafio.model.Endereco;
import com.saov.desafio.model.EnderecoRepository;
import com.saov.desafio.service.ClienteService;
import com.saov.desafio.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clientRepository;

    @Autowired
    private EnderecoRepository adressRepository;

    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clientRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void inserir(Cliente client) {
        String cep = client.getEndereco().getCep();;
        Endereco endereco = adressRepository.findById(client.getEndereco().getCep()).orElseGet(()->{
            Endereco newAdress = viaCepService.consultarCep(cep);
            adressRepository.save(newAdress);
            return newAdress;});
        client.setEndereco(endereco);
        clientRepository.save(client);
    }

    public void atualizar(Long id, Cliente client) {
        Optional<Cliente> clientbd = clientRepository.findById(id);
        if(clientbd.isPresent()){
            String cep = client.getEndereco().getCep();;
            Endereco endereco = adressRepository.findById(client.getEndereco().getCep()).orElseGet(()->{
                Endereco newAdress = viaCepService.consultarCep(cep);
                adressRepository.save(newAdress);
                return newAdress;});
            client.setEndereco(endereco);
            clientRepository.save(client);
        }
    }

    @Override
    public void deletar(Long id) {
        clientRepository.deleteById(id);
    }
}
