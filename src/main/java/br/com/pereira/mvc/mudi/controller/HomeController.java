package br.com.pereira.mvc.mudi.controller;

import java.util.List;
import org.springframework.ui.Model;

import br.com.pereira.mvc.mudi.enums.StatusPedido;
import br.com.pereira.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.pereira.mvc.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/")
	public String home(Model model) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	@GetMapping("{status}")
	public String aguardando(@PathVariable("status") String statusPedido, Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.valueOf(statusPedido.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", statusPedido);

		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/";
	}
}