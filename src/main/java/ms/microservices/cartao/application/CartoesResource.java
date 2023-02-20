package ms.microservices.cartao.application;

import lombok.RequiredArgsConstructor;
import ms.microservices.cartao.domain.Cartao;
import ms.microservices.cartao.domain.Cliente;
import ms.microservices.cartao.represetation.CartaoRequestDto;
import ms.microservices.cartao.represetation.ClienteCartaoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("cartoes")
public class CartoesResource {

    private final CartaoService cartaoService;

    private final ClienteService clienteService;

    @GetMapping
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity cadastro(@RequestBody CartaoRequestDto requestDto ){
        Cartao cartao = requestDto.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> cartoesRendaAteh(@RequestParam ("renda") Long renda){
        List<Cartao> cartoesRenda = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(cartoesRenda);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClienteCartaoDto>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<Cliente> clientes = clienteService.listCartoesByCpf(cpf);
        List<ClienteCartaoDto> resultList = clientes.stream().map(ClienteCartaoDto::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
