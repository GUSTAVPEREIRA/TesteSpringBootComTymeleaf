package br.com.pereira.mvc.mudi.repositories;

import java.util.List;
import br.com.pereira.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Repository;
import br.com.pereira.mvc.mudi.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatusPedido(StatusPedido statusPedido);	
}