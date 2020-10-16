package br.com.pereira.mvc.mudi.repositories;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pereira.mvc.mudi.enums.StatusPedido;
import br.com.pereira.mvc.mudi.model.Pedido;



@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("pedidos")
	List<Pedido> findByStatusPedido(StatusPedido statusPedido, Pageable sort);

	@Query("SELECT p FROM Pedido AS p JOIN p.user u WHERE u.username = :username")
	List<Pedido> findByUsuario(@Param("username") String username);

	@Query("SELECT p FROM Pedido AS p JOIN p.user u WHERE u.username = :username AND p.statusPedido = :statusPedido")
	List<Pedido> findByStatusPedidoAndUsuario(@Param("statusPedido") StatusPedido statusPedido,
			@Param("username") String usernmae);
}