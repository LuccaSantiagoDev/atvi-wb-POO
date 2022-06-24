package com.wb.negocio;

import java.util.List;

import com.wb.modelo.Produto;

public class ListarUmProduto extends Listagem {
	private List<Produto> produtos;
	
	public ListarUmProduto(List<Produto> produtos) {
		
		this.produtos = produtos;
	}

	@Override
	public void listar() {
		for (Produto produto : produtos) {
			System.out.println("Nome :"+ produto.getNome());
			System.out.println("Preço :"+ produto.getValor());
		}
		
		
		
		
		
	}
	
	public Object retornaProduto(String nome) {
		for (Produto produto : produtos) {
			if(produto.getNome().equals(nome)) {
				return produto;
			}
			
		}
		return null;
	}
	
	
	
		

}
