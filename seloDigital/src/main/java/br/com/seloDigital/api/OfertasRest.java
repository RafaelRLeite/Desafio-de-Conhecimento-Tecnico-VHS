package br.com.seloDigital.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seloDigital.model.Oferta;
import br.com.seloDigital.model.dto.RequisicaoNovaOfertaDTO;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@PostMapping
	public Oferta criaOferta(RequisicaoNovaOfertaDTO requisicao) {
		return null;
	}

}
