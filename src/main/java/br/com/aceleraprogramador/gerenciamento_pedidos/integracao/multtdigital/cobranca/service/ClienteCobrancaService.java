package br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.service;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.request.ClienteCobrancaRequest;
import br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.dto.response.ClienteCobrancaResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.utils.ObjectMapperUtilsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteCobrancaService {

    private final MulttDigitalCobrancaConfig multtDigitalCobrancaConfig;
    private final RestTemplate restTemplate;

    public ClienteCobrancaResponse criarCliente(ClienteCobrancaRequest request) {
        try {
            log.info("Criando cliente no ambiente de integração de pagamentos...");
            log.info("Request criarCliente JSON: {}", ObjectMapperUtilsConfig.pojoParaJson(request));

            HttpHeaders headers = new HttpHeaders();
            headers.add("accept", "application/json");
            headers.add("Authorization", "Bearer " + multtDigitalCobrancaConfig.getToken());
            headers.add("Content-Type", "application/json");

            HttpEntity<ClienteCobrancaRequest> requestEntity = new HttpEntity<>(request, headers);

            String url = multtDigitalCobrancaConfig.getBaseUrl() + "/clientes/v1";

            ResponseEntity<ClienteCobrancaResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    ClienteCobrancaResponse.class
            );

            ClienteCobrancaResponse responseBody = response.getBody();
            log.info("Cliente criado com sucesso no ambiente de integração de pagamentos.");
            log.info("Response criarCliente JSON: {}", ObjectMapperUtilsConfig.pojoParaJson(request));
            return responseBody;

        } catch (Exception e) {
            log.error("Erro ao criar cliente no ambiente de pagamentos. {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}