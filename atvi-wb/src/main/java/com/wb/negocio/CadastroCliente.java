package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Início do cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		System.out.println("Por favor informe o número do cpf:");
		String valor = entrada.receberTexto();
		System.out.println("Por favor informe o Genero do cliente(M/F)");
		String genero=entrada.receberTexto();
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String data = entrada.receberTexto();
		
		System.out.println("Quantos RGs o cliente possui?");
		int[] index= new int[entrada.receberNumeroInteiro()];
		
		List<RG> rgs=new ArrayList<>();
		
		entrada=new Entrada();
		for ( int i = 0; i <index.length; i++) {
			
			System.out.println("Por favor informe o número do rg:");
			String valorRG = entrada.receberTexto();
			System.out.println("Por favor informe a data de emissão do RG, no padrão dd/mm/yyyy:");
			String dataRG = entrada.receberTexto();
			LocalDate dataEmissaoRG = LocalDate.parse(dataRG, formato);
			
			
			rgs.add(new RG(dataEmissaoRG,valorRG));
		}
		
		List<Telefone> telefones=new ArrayList<>();;
		
		System.out.println("Quantos Telefones o cliente possui?");
		index= new int[entrada.receberNumeroInteiro()];
		entrada=new Entrada();
		for ( int i = 0; i <index.length; i++) {
			
			
			System.out.println("Por favor informe o número do DDD:");
			String ddd = entrada.receberTexto();
			System.out.println("Por favor informe o número do Telefone:");
			String ntel = entrada.receberTexto();
			
			Telefone telefone=new Telefone(ddd,ntel);
			
			
			telefones.add(telefone);
		}
		
		
		
		
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		CPF cpf = new CPF(dataEmissao, valor);
		Cliente cliente = new Cliente(nome, nomeSocial, cpf,rgs,telefones,genero);
		this.clientes.add(cliente);
	}
	
	public void salvarDireto(Cliente cliente) {
		this.clientes.add(cliente);
		}
}