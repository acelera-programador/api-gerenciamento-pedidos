package br.com.aceleraprogramador.gerenciamento_pedidos.adapter;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.request.CreateClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import lombok.experimental.UtilityClass;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ClienteAdapter {

    public static Cliente toCliente(CreateClienteRequest request) {
        return Cliente
                .builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .endereco(request.getEndereco())
                .telefone(request.getTelefone())
                .build();
    }

    public static ClienteResponse toClienteResponse(Cliente cliente) {
        return ClienteResponse
                .builder()
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .telefone(cliente.getTelefone())
                .build();
    }

    public static List<ClienteResponse> toClientesResponseList(List<Cliente> clientes) {
        return clientes
                .stream()
                .map(ClienteAdapter::toClienteResponse)
                .collect(Collectors.toList());
    }
}
