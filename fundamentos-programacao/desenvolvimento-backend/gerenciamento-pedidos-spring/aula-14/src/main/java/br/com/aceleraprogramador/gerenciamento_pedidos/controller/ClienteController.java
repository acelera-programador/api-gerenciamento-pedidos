package br.com.aceleraprogramador.gerenciamento_pedidos.controller;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.UpdateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.PageResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @Override
    @GetMapping(value = "/v1/buscarPorNome", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse> buscarClientesPorNome(
            @RequestParam() String nome) {
        return clienteService.buscarClientePorNome(nome);
    }

    @Override
    @GetMapping(value = "/v1/buscarPorEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse> buscarClientesPorEmail(
            @RequestParam() String email) {
        return clienteService.buscarClientePorEmail(email);
    }

    @Override
    @GetMapping(value = "/v1/buscarPorProfissao", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse> buscarClientesPorProfissao(
            @RequestParam() String profissao) {
        return clienteService.buscarClientePorProfissao(profissao);
    }

    @Override
    @GetMapping(value = "/v1/buscarPorNomeEmailProfissao", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse> buscarClientePorNomeEmailProfissao(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String profissao) {
        return clienteService.buscarClientePorNomeEmailProfissao(nome, email, profissao);
    }

    @Override
    @PutMapping(value = "/v1/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarTodosOsDadosDoCliente(@PathVariable Long idCliente, UpdateClienteRequest request) {
        clienteService.atualizarTodosOsDadosDoCliente(idCliente, request);
    }

    @Override
    @PatchMapping(value = "/v1/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse atualizarParcialmenteOsDadosDoCliente(@PathVariable Long idCliente, UpdateClienteRequest request) {
        return clienteService.atualizarParcialmenteOsDadosDoCliente(idCliente, request);
    }

    @Override
    @DeleteMapping(value = "/v1/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Long idCliente) {
        clienteService.removerCliente(idCliente);
    }
}
