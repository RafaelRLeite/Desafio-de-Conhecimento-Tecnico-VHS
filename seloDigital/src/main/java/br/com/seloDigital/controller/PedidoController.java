package br.com.seloDigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.seloDigital.model.Pedido;
import br.com.seloDigital.model.User;
import br.com.seloDigital.model.dto.RequisicaoNovoPedidoDTO;
import br.com.seloDigital.repository.PedidoRepository;
import br.com.seloDigital.repository.UserRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	UserRepository userRepository;

	// @GetMapping("formulario")
	@RequestMapping(method = RequestMethod.GET, value = "formulario")
	public String formulario(RequisicaoNovoPedidoDTO requisicaoNovoPedidoDTO) {
		return "pedido/formulario";
	}

	// @PostMapping("novo")
	@RequestMapping(method = RequestMethod.POST, value = "novo")
	public String novo(@Valid RequisicaoNovoPedidoDTO requisicaoNovoPedidoDTO, BindingResult result) {

		if (result.hasErrors()) {
			return "pedido/formulario";
		}

		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(userName);
		
		Pedido pedido = requisicaoNovoPedidoDTO.toPedido();
		pedido.setUser(user);
		pedidoRepository.save(pedido);

		return "redirect:/usuario/pedido";
	}

}
