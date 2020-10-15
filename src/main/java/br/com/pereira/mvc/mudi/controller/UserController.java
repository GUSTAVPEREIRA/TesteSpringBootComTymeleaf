package br.com.pereira.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pereira.mvc.mudi.enums.StatusPedido;
import br.com.pereira.mvc.mudi.model.Pedido;
import br.com.pereira.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UserController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("pedido/{status}")
	public String aguardando(@PathVariable("status") String statusPedido, Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository
				.findByStatusPedidoAndUsuario(StatusPedido.valueOf(statusPedido.toUpperCase()), principal.getName());
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", statusPedido);

		return "usuario/home";
	}

	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findByUsuario(principal.getName());
		model.addAttribute("pedidos", pedidos);
		return "usuario/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
}
