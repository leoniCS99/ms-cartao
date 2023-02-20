package ms.microservices.cartao.infra.repository;

import ms.microservices.cartao.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByCpf (String cpf);
}
