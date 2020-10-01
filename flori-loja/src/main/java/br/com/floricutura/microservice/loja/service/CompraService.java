package br.com.floricutura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.floricutura.microservice.loja.client.FornecedorCliente;
import br.com.floricutura.microservice.loja.controller.dto.CompraDto;
import br.com.floricutura.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.floricutura.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.floricutura.microservice.loja.model.Compra;

@Service
public class CompraService {

	@Autowired
	private FornecedorCliente forncedorClient;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	public Compra realizaCompra(CompraDto compra) {
		
		
		final String estado = compra.getEndereco().getEstado();
		
		LOG.info("Buscando informações do fornecedor de {} ", estado);
		InfoFornecedorDto info = forncedorClient.getInfPorEstado(estado);
		
		LOG.info("realizando um pedido");
		InfoPedidoDto pedido = FornecedorCliente.realizaPedido(compra.getItens());
		
		System.out.println(info.getEndereco());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
	}

}
