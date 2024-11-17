package br.com.aceleraprogramador.gerenciamento_pedidos.controller;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteAPI {


    @Operation(summary = "Criar um cliente")
    @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClienteResponse.class)))
    ClienteResponse criarCliente(@Valid @RequestBody CreateClienteRequest request);
}
