package br.com.aceleraprogramador.gerenciamento_pedidos.integracao.multtdigital.cobranca.service;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class MulttDigitalCobrancaConfig {

    @Value("${api.multt.base-url}")
    private String baseUrl;

    @Value("${api.multt.auth-token}")
    private String token;
}