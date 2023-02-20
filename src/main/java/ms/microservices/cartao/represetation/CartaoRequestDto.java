package ms.microservices.cartao.represetation;

import lombok.Data;
import ms.microservices.cartao.domain.BandeiraCartaoEnum;
import ms.microservices.cartao.domain.Cartao;

import java.math.BigDecimal;

@Data
public class CartaoRequestDto {

    private String nome;
    private BandeiraCartaoEnum bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
