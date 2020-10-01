package br.com.floricultura.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.floricultura.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
