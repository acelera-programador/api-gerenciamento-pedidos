package br.com.aceleraprogramador.gerenciamento_pedidos.controller;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.exceptions.ErroResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

@ApiResponses({
        @ApiResponse(responseCode = "400", description = "Bad Request - Requisição inválida", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErroResponse.class)))
})
public interface ClienteAPI {


    @Operation(summary = "Criar um cliente")
    @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClienteResponse.class)))
    ClienteResponse criarCliente(@Valid @RequestBody CreateClienteRequest request);
}
