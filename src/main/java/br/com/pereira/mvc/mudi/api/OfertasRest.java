package br.com.pereira.mvc.mudi.api;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pereira.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.pereira.mvc.mudi.model.Oferta;
import br.com.pereira.mvc.mudi.repositories.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		var pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());

		if (!pedidoBuscado.isPresent()) {
			return null;
		}

		var pedido = pedidoBuscado.get();

		Oferta newOferta = requisicao.toOferta();
		newOferta.setPedido(pedido);
		pedido.getOfertas().add(newOferta);
		pedidoRepository.save(pedido);

		return newOferta;
	}
}
