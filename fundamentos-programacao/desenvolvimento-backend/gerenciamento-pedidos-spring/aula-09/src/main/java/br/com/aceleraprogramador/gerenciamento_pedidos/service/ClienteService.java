package br.com.aceleraprogramador.gerenciamento_pedidos.service;
import br.com.aceleraprogramador.gerenciamento_pedidos.adapter.ClienteAdapter;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.exceptions.RecursoNaoEncontradoException;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import br.com.aceleraprogramador.gerenciamento_pedidos.repository.ClienteRepository;
import br.com.aceleraprogramador.gerenciamento_pedidos.utils.ObjectMapperUtilsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public List<ClienteResponse> buscarTodosOsClientes() {

        log.info("Buscando todos os clientes...");

        List<Cliente> clientes = clienteRepository.findAll();

        List<ClienteResponse> clientesResponse = ClienteAdapter.toClientesResponseList(clientes);

        log.info("Clientes retornados com sucesso.");

        return clientesResponse;
    }

    public ClienteResponse buscarClientePorId(Long idCliente) {

        log.info("Buscando cliente com ID:{}", idCliente);

        Cliente clienteExistente = retornarClientePorId(idCliente);

        ClienteResponse clienteResponse = ClienteAdapter.toClienteResponse(clienteExistente);

        log.info("Cliente com retornado com sucesso.");

        return clienteResponse;

    }

    private Cliente retornarClientePorId(Long idCliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        if (clienteOptional.isEmpty()) {
            String erro = "Cliente não encontrado com o ID: " + idCliente;
            log.error(erro);
            throw new RecursoNaoEncontradoException(erro);
        } else {
            return clienteOptional.get();
        }
    }
}
