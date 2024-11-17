package br.com.aceleraprogramador.gerenciamento_pedidos.controller;


import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import br.com.aceleraprogramador.gerenciamento_pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TesteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/teste")
    public void teste(){

        Cliente cliente = new Cliente();
        cliente.setNome("Wesley");

        clienteRepository.save(cliente);
        List<Cliente> clientes = clienteRepository.findAll();
    }

}
