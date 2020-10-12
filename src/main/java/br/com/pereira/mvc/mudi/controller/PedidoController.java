package br.com.pereira.mvc.mudi.controller;

import javax.validation.Valid;
import br.com.pereira.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import br.com.pereira.mvc.mudi.dto.RequisicaoNovoPedido;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.pereira.mvc.mudi.repositories.PedidoRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);

		if (result.hasErrors()) {
			return "pedido/formulario";
		}

		return "redirect:/";
	}
}