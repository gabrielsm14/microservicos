package br.com.floricutura.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.floricutura.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.floricutura.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.floricutura.microservice.loja.controller.dto.ItemDaCompraDto;

@FeignClient("fornecedor")
public interface FornecedorCliente {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDto getInfPorEstado(@PathVariable String estado);

	@RequestMapping(method = RequestMethod.POST,  value = "/pedido")
	static
	InfoPedidoDto realizaPedido(List<ItemDaCompraDto> itens) {
		// TODO Auto-generated method stub
		return null;
	}


}
