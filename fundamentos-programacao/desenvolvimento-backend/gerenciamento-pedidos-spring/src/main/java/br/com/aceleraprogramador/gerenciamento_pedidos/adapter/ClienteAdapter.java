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
                .profissao(request.getProfissao())
                .build();
    }

    public static ClienteResponse toResponse(Cliente entidade) {
        return ClienteResponse
                .builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .email(entidade.getEmail())
                .endereco(entidade.getEndereco())
                .telefone(entidade.getTelefone())
                .profissao(entidade.getProfissao())
                .build();
    }

    public static List<ClienteResponse> toResponseList(List<Cliente> entidades) {
        return entidades
                .stream()
                .map(ClienteAdapter::toResponse)
                .collect(Collectors.toList());
    }
}
