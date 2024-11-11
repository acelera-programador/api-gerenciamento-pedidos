package br.com.aceleraprogramador.gerenciamento_pedidos.adapter;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClienteAdapter {

    public static Cliente toCliente(CreateClienteRequest createClienteRequest) {
        return Cliente.builder()
                .build();
    }

    public static ClienteResponse toClienteResponse(Cliente cliente) {
        return ClienteResponse.builder().build();
    }
}
