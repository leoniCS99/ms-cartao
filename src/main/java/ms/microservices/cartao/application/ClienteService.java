package ms.microservices.cartao.application;

import lombok.RequiredArgsConstructor;
import ms.microservices.cartao.domain.Cliente;
import ms.microservices.cartao.infra.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> listCartoesByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
