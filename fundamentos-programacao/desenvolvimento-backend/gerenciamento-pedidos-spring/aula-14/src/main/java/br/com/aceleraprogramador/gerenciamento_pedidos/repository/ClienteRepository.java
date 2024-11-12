package br.com.aceleraprogramador.gerenciamento_pedidos.repository;
import br.com.aceleraprogramador.gerenciamento_pedidos.dto.response.ClienteResponse;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
    List<Cliente> findByNomeContaining(@Param("nome") String nome);

    @Query(value = "SELECT * FROM cliente WHERE email = :email", nativeQuery = true)
    List<Cliente> findByEmailNative(@Param("email") String email);

    @Query(name = "Cliente.findClienteResponseByProfissaoNative", nativeQuery = true)
    List<ClienteResponse> findClienteResponseByProfissaoNative(@Param("profissao") String profissao);

    @Query("SELECT c FROM Cliente c WHERE " +
            "(:nome IS NULL OR c.nome LIKE %:nome%) AND " +
            "(:email IS NULL OR c.email = :email) AND " +
            "(:profissao IS NULL OR c.profissao = :profissao)")
    List<Cliente> findByNomeEmailProfissao(
            @Param("nome") String nome,
            @Param("email") String email,
            @Param("profissao") String profissao
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET nome = :nome, email = :email, telefone = :telefone, endereco = :endereco, profissao = :profissao WHERE id = :id", nativeQuery = true)
    void updateClienteById(
            @Param("id") Long id,
            @Param("nome") String nome,
            @Param("email") String email,
            @Param("telefone") String telefone,
            @Param("endereco") String endereco,
            @Param("profissao") String profissao
    );
}
