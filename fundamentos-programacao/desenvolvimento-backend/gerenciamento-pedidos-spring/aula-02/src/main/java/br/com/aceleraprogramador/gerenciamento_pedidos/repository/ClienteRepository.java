package br.com.aceleraprogramador.gerenciamento_pedidos.repository;
import br.com.aceleraprogramador.gerenciamento_pedidos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
