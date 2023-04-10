package br.com.seloDigital.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seloDigital.model.Pedido;
import br.com.seloDigital.model.StatusPedido;
import br.com.seloDigital.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping("aguardado")
	public List<Pedido> getPedidosAguardandoOfertas(){
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		return pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO, paginacao);
		
	}

}
