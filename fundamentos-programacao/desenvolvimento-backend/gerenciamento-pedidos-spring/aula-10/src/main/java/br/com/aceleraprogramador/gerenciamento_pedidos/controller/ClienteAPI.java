package br.com.aceleraprogramador.gerenciamento_pedidos.controller;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.PageResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.exceptions.ErroResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteAPI {


    @Operation(summary = "Criar um cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClienteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request - Requisição inválida", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErroResponse.class)))
    })
    ClienteResponse criarCliente(@Valid @RequestBody CreateClienteRequest request);

    @Operation(summary = "Listar todos os cliente")
    @ApiResponse(responseCode = "200", description = "Clientes Retornados com sucesso.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = PageResponse.class))))
    PageResponse<ClienteResponse> buscarTodosOsClientes(Pageable pageable);

    @Operation(summary = "Listar cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente Retornado com sucesso.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClienteResponse.class)))
    ClienteResponse buscarClientePorId(@Parameter(description = "Id do cliente", required = true) Long idCliente);
}
