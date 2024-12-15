package br.com.aceleraprogramador.gerenciamento_pedidos.service;
import br.com.aceleraprogramador.gerenciamento_pedidos.adapter.CobrancaClienteAdapter;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.CobrancaClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.enuns.TipoPagamento;
import br.com.aceleraprogramador.gerenciamento_pedidos.exceptions.MulttDigitalInteracaoException;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.adapter.MulttDigitalAdapter;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.api.MulttDigitalClienteAPI;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.api.MulttDigitalCobrancaAPI;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.request.MulttDigitalClienteRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.request.MulttDigitalCobrancaRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.response.MulttDigitalClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.response.MulttDigitalCobrancaResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrarCobrancaClienteService {

    private final MulttDigitalClienteAPI multtDigitalClienteAPI;
    private final MulttDigitalCobrancaAPI multtDigitalCobrancaAPI;

    public CobrancaClienteResponse registrarCobrancaPedido(Pedido pedido) {

        MulttDigitalClienteResponse multtDigitalClienteResponse = registrarClienteNaApi(pedido);

        MulttDigitalCobrancaResponse multtDigitalCobrancaResponse = registrarCobrancaNaApi(multtDigitalClienteResponse,
                pedido.getValorTotal(),
                pedido.getDataPedido().toLocalDate()
        );

        return preencherCobrancaClienteResponse(multtDigitalCobrancaResponse);
    }


    private MulttDigitalClienteResponse registrarClienteNaApi(Pedido pedido) {
        try {
            MulttDigitalClienteRequest multtDigitalClienteRequest = MulttDigitalAdapter.preencherClienteRequest(
                    pedido.getId().toString(),
                    pedido.getCliente().getNome(),
                    pedido.getCliente().getCpf(),
                    pedido.getCliente().getEmail(),
                    pedido.getCliente().getTelefone(),
                    true
            );
            return multtDigitalClienteAPI.criarCliente(multtDigitalClienteRequest);
        } catch (HttpClientErrorException e) {
            log.error("Erro ao criar cliente na API externa: {}", e.getMessage());
            throw new MulttDigitalInteracaoException("Erro ao registrar cliente: " + e.getResponseBodyAsString());
        }
    }

    private MulttDigitalCobrancaResponse registrarCobrancaNaApi(MulttDigitalClienteResponse multtDigitalClienteResponse, BigDecimal valorTotal, LocalDate dataVencimento) {
        try {
            MulttDigitalCobrancaRequest multtDigitalCobrancaRequest = MulttDigitalAdapter.preencherCobrancaRequest(
                    multtDigitalClienteResponse.getId(),
                    valorTotal,
                    TipoPagamento.PIX,
                    dataVencimento
            );
            return multtDigitalCobrancaAPI.registrarCobranca(multtDigitalCobrancaRequest);
        } catch (HttpClientErrorException e) {
            log.error("Erro ao registrar cobrança na API externa: {}", e.getMessage());
            throw new MulttDigitalInteracaoException("Erro ao registrar cobrança: " + e.getResponseBodyAsString());
        }
    }

    private CobrancaClienteResponse preencherCobrancaClienteResponse(MulttDigitalCobrancaResponse multtDigitalCobrancaResponse) {
        return CobrancaClienteAdapter.preencherRespostaRegistroPagamento(
                multtDigitalCobrancaResponse.getStatus(),
                multtDigitalCobrancaResponse.getInvoiceUrl(),
                multtDigitalCobrancaResponse.getPixCopiaECola(),
                multtDigitalCobrancaResponse.getEncodedImage()
        );
    }
}
