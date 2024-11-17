package br.com.aceleraprogramador.gerenciamento_pedidos.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateClienteRequest {

    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Email(message = "O email deve ser válido")
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXXX-XXXX.")
    private String telefone;

    private String endereco;
}
