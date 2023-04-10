package br.com.seloDigital.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.seloDigital.model.Pedido;
import br.com.seloDigital.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("pedidosByStatus")
	List<Pedido> findByStatusPedido(StatusPedido status, Pageable paginacao);

	@Cacheable("pedidosByUser")
	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUser(@Param("username")String username);

	@Cacheable("pedidosByStatusAndUser")
	@Query("select p from Pedido p join p.user u where u.username = :username and p.statusPedido = :status")
	List<Pedido> findByStatusPedidoAndUser(@Param("status")StatusPedido status, @Param("username")String username);

}
 