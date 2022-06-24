package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public  class ListarUmCliente extends Listagem  {
	private List<Cliente> clientes;
	private Entrada entrada = new Entrada();

	public ListarUmCliente(List<Cliente> clientes ) {
		this.clientes = clientes;
		
	}


	@Override
	public void listar() {
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		boolean retorno=true;
		int index=0;
		for (Cliente cliente : clientes) {
			if(cliente.nome.equals(nome)) {
				
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
				
			
			
				retorno=false;
				break;
			}
			index+=1;
		}

		if (retorno) {
			
			System.out.println("Não existe cliente com este nome");
		}else {
			System.out.println("Deseja deletar esse cliente ?(del/sair)");
			String decisao=entrada.receberTexto();
			
			switch (decisao) {
			case "del":
				System.out.println("Deletado com sucesso");
				clientes.remove(index);
				break;
				
			case "atu":
				System.out.println("atu");
				break;

			case "sair":
				break;
				
			case "0":
				break;
				
			case "não":
				break;
				
			default:
				System.out.println("Operação não entendida");

				break;
			}
			
		}
		
	}
	
	
	public Object retornaCliente(String nome) {
		for (Cliente cliente : clientes) {
			if(cliente.nome.equals(nome)) {
				return cliente;
				
			}
		}
		return null;
	}
	
	public void listaProdutosCliente() {
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		Cliente clienteProcurado = null;
		
		for (Cliente cliente : clientes) {
			if(cliente.nome.equals(nome)) {
				clienteProcurado=cliente;
				break;
			}
			
			
		}
		
		System.out.println("Nome: " + clienteProcurado.nome);
		System.out.println("CPF: " + clienteProcurado.getCpf().getValor());
		System.out.println("Produtos Comprados por este cliente");
		Listagem listagemP = new ListarTodosProdutos(clienteProcurado.getProdutosConsumidos());
		listagemP.listar();
		
	}
	

	
	
}
