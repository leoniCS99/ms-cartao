package ms.microservices.cartao.infra.repository.miqueue;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import ms.microservices.cartao.domain.Cartao;
import ms.microservices.cartao.domain.Cliente;
import ms.microservices.cartao.domain.DadosSolicitacaoEmissaoCartao;
import ms.microservices.cartao.infra.repository.CartaoRepository;
import ms.microservices.cartao.infra.repository.ClienteRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) {
       try {
           var mapper = new ObjectMapper();
           DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
           Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();
           Cliente clienteCartao = new Cliente();
           clienteCartao.setCartao(cartao);
           clienteCartao.setCpf(cartao.getCpf());
           clienteCartao.setLimite(cartao.getLimiteBasico());

           clienteRepository.save(clienteCartao);

       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
