package br.com.aceleraprogramador.gerenciamento_pedidos.controller;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.PageResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController implements ClienteAPI {

    @Autowired
    ClienteService clienteService;

    @Override
    @PostMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponse criarCliente(CreateClienteRequest request) {
        return clienteService.criarCliente(request);
    }

    @Override
    @GetMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<ClienteResponse> buscarTodosOsClientes(Pageable pageable) {
        return clienteService.buscarTodosOsClientes(pageable);
    }

    @Override
    @GetMapping(value = "/v1/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse buscarClientePorId(@PathVariable Long idCliente) {
        return clienteService.buscarClientePorId(idCliente);
    }
}
