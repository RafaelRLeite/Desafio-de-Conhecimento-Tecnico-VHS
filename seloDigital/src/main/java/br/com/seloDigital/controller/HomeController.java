package br.com.seloDigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.seloDigital.model.Pedido;
import br.com.seloDigital.model.StatusPedido;
import br.com.seloDigital.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	PedidoRepository pedidoRepository;
	

	@GetMapping()
	public String home(Model model) {
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

//	@GetMapping("/{status}")
//	public String porStatus(@PathVariable("status") String status, Model model) {
//		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.valueOf(status.toUpperCase()));
//		model.addAttribute("pedidos", pedidos);
//		model.addAttribute("status", status);
//		return "home";
//	}

//	@GetMapping("/aprovado")
//	public ModelAndView aprovado(Model model) {
//
//		ModelAndView mv = new ModelAndView("home");
//		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.APROVADO);
//
//		mv.addObject("pedidos", pedidos);
//		return mv;
//	}
//
//	@GetMapping("/entregue")
//	public ModelAndView entregue(Model model) {
//
//		ModelAndView mv = new ModelAndView("home");
//		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.ENTREGUE);
//
//		mv.addObject("pedidos", pedidos);
//		return mv;
//	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}