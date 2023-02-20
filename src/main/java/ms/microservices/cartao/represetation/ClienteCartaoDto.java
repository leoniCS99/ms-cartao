package ms.microservices.cartao.represetation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.microservices.cartao.domain.Cliente;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCartaoDto {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static ClienteCartaoDto fromModel(Cliente model){
        return new ClienteCartaoDto(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }
}
