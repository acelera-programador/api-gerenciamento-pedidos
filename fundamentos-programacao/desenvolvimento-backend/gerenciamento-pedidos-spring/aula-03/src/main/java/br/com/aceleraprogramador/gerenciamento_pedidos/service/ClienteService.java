package br.com.aceleraprogramador.gerenciamento_pedidos.service;
import br.com.aceleraprogramador.gerenciamento_pedidos.adapter.ClienteAdapter;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import br.com.aceleraprogramador.gerenciamento_pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteResponse criarCliente(CreateClienteRequest createClienteRequest) {

        Cliente cliente = ClienteAdapter.toCliente(createClienteRequest);

        clienteRepository.save(cliente);

        return ClienteAdapter.toClienteResponse(cliente);
    }
}
