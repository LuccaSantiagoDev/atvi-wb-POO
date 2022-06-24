package com.wb.negocio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("CPF: " + cliente.getCpf().getValor());
			
			if(cliente.getGenero().equals("F")) {
				System.out.println("Genero : Feminino");
			}else {
				System.out.println("Genero : Masculino");
			}
			
			
			System.out.println("Telefones:");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println("("+telefone.getDdd()+") "+telefone.getNumero());
				
			}
			System.out.println("Rgs:");
			for (RG rg : cliente.getRgs()) {
				System.out.println(rg.getValor());
				
			}

			System.out.println("--------------------------------------");
		}
	}
	
	public void listarGenero() {
		
		List<Cliente> clientesG =new ArrayList<>(clientes);
		clientesG.sort(Comparator.comparing(Cliente::getGenero));
		
		System.out.println("Lista de todos os clientes:");
		for (Cliente cliente : clientesG) {
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("CPF: " + cliente.getCpf().getValor());
			
			if(cliente.getGenero().equals("F")) {
				System.out.println("Genero : Feminino");
			}else {
				System.out.println("Genero : Masculino");
			}
			
			
			System.out.println("Telefones:");
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println("("+telefone.getDdd()+") "+telefone.getNumero());
				
			}
			System.out.println("Rgs:");
			for (RG rg : cliente.getRgs()) {
				System.out.println(rg.getValor());
				
			}

			System.out.println("--------------------------------------");
		}
	}
	
	
	public void listar10(boolean m) {
		List<Cliente> clientes10 =new ArrayList<>(clientes);
		clientes10.sort(Comparator.comparing(Cliente::getTotalProdutosConsumidos));
		

		if(m) {
			System.out.println("Lista de 10 clientes que menos compraram:");
			for (int i = 0; i < 10; i++) {
				
				
				System.out.println("Nome: " + clientes10.get(i).nome);
				System.out.println("Nome social: " +  clientes10.get(i).nomeSocial);
				System.out.println("CPF: " +  clientes10.get(i).getCpf().getValor());
					
					if( clientes10.get(i).getGenero().equals("F")) {
						System.out.println("Genero : Feminino");
					}else {
						System.out.println("Genero : Masculino");
					}
					
					
					System.out.println("Telefones:");
					for (Telefone telefone :  clientes10.get(i).getTelefones()) {
						System.out.println("("+telefone.getDdd()+") "+telefone.getNumero());
						
					}
					System.out.println("Rgs:");
					for (RG rg :  clientes10.get(i).getRgs()) {
						System.out.println(rg.getValor());
						
					}

					System.out.println("--------------------------------------");
				
				
				
			}
			
			
		}
		
	}
	
	
}
