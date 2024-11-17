package br.com.aceleraprogramador.gerenciamento_pedidos.service;
import br.com.aceleraprogramador.gerenciamento_pedidos.adapter.ClienteAdapter;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import br.com.aceleraprogramador.gerenciamento_pedidos.repository.ClienteRepository;
import br.com.aceleraprogramador.gerenciamento_pedidos.utils.ObjectMapperUtilsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteResponse criarCliente(CreateClienteRequest createClienteRequest) {

        log.info("Criando um novo cliente...");
        log.info("JSON: {}", ObjectMapperUtilsConfig.pojoParaJson(createClienteRequest));

        Cliente cliente = ClienteAdapter.toCliente(createClienteRequest);

        clienteRepository.save(cliente);

        ClienteResponse clienteResponse = ClienteAdapter.toClienteResponse(cliente);

        log.info("Cliente criado com sucesso...");

        return clienteResponse;
    }
}
