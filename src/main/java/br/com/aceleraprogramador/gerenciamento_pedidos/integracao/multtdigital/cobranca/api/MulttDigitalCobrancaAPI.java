package br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.api;
import br.com.aceleraprogramador.gerenciamento_pedidos.exceptions.MulttDigitalInteracaoException;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.config.MulttDigitalConfig;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.request.MulttDigitalCobrancaRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.response.MulttDigitalCobrancaResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.utils.ObjectMapperUtilsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MulttDigitalCobrancaAPI {

    private final MulttDigitalConfig multtDigitalConfig;
    private final MulttDigitalHelper multtDigitalHelper;

    public MulttDigitalCobrancaResponse registrarCobranca(MulttDigitalCobrancaRequest request) {
        try {

            log.info("Criando cobrança no ambiente de integração de pagamentos...");
            log.info("Request criarPagamento JSON: {}", ObjectMapperUtilsConfig.pojoParaJson(request));

            String url = multtDigitalConfig.getBaseUrl() + "/cobrancas/v1";
            Map<String, String> headers = Map.of(
                    "accept", "application/json",
                    "Authorization", "Bearer " + multtDigitalConfig.getToken(),
                    "Content-Type", "application/json"
            );

            MulttDigitalCobrancaResponse responseBody = multtDigitalHelper.executeRequest(url, HttpMethod.POST, request, MulttDigitalCobrancaResponse.class, headers);

            log.info("Cobrança registrado com sucesso no ambiente de integração de pagamentos.");
            log.info("Response criarPagamento JSON: {}", ObjectMapperUtilsConfig.pojoParaJson(responseBody));

            return responseBody;

        } catch (Exception e) {
            log.error("Erro ao criar cobrança no ambiente de pagamentos. {}", e.getMessage());
            throw new MulttDigitalInteracaoException(e.getMessage());
        }
    }
}
