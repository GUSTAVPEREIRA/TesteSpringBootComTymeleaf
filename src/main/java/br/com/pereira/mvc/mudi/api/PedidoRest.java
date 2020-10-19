package br.com.pereira.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pereira.mvc.mudi.enums.StatusPedido;
import br.com.pereira.mvc.mudi.model.Pedido;
import br.com.pereira.mvc.mudi.repositories.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
@EnableCaching
public class PedidoRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest pagination = PageRequest.of(0, 20, sort);

		return pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO, pagination);		
	}
}