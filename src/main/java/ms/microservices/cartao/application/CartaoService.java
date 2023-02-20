package ms.microservices.cartao.application;

import lombok.RequiredArgsConstructor;
import ms.microservices.cartao.domain.Cartao;
import ms.microservices.cartao.infra.repository.CartaoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repository;

    @Transactional
    public Cartao save(Cartao cartao){
        return repository.save(cartao);
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long renda){
         BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
