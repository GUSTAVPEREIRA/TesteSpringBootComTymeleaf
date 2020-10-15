package br.com.pereira.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.pereira.mvc.mudi.enums.StatusPedido;
import br.com.pereira.mvc.mudi.model.Pedido;
import br.com.pereira.mvc.mudi.repositories.PedidoRepository;

@Controller
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/home")
	public String home(Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.ENTREGUE);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}	
}