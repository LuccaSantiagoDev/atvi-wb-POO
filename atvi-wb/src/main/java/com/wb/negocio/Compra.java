package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;

public class Compra {
	private List<Produto> produtos;
	private List<Cliente> clientes;
	
	
	
	public Compra(List<Produto> produtos, List<Cliente> clientes) {
		this.produtos = produtos;
		this.clientes = clientes;
	}
	
	
	
	
	
	

	public void Comprafeita(Cliente cliente,Produto produto) {
		
		cliente.ProdutoComprado(produto);
	}

	public String Comprando(String nomeCliente,String nomeProduto) {
		
		
		ListarUmCliente listagem = new ListarUmCliente(clientes);
		ListarUmProduto listagemp = new ListarUmProduto(produtos);
		Comprafeita((Cliente)listagem.retornaCliente(nomeCliente),(Produto)listagemp.retornaProduto(nomeProduto));
		
		return nomeProduto;
		
	}
	
	
}
