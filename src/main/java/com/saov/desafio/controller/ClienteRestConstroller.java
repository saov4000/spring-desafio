package com.saov.desafio.controller;

import com.saov.desafio.model.Cliente;
import com.saov.desafio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestConstroller {
    @Autowired
    private ClienteService clientService;
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clientService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clientService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente client){
        clientService.inserir(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente client) {
        clientService.atualizar(id,client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clientService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
