package com.wb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Empresa;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.Compra;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;
import com.wb.negocio.ListarUmCliente;
import com.wb.teste.ImplementaBanco;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		
		String dataCPF="10/10/2000";
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissaoCPF = LocalDate.parse(dataCPF, formato);
		CPF cpf = new CPF(dataEmissaoCPF ,"65168456465");
		
		String dataRG="11/10/2000";
		LocalDate dataEmissaoRG = LocalDate.parse(dataCPF, formato);
		RG rg= new RG(dataEmissaoRG ,"65168456465");
		List<RG> listaRG=new ArrayList<>();
		listaRG.add(rg);
		
		Telefone telefone =new Telefone("012","234324324");
		List<Telefone> listaTL=new ArrayList<>();
		listaTL.add(telefone);
	
		
		Cliente cliente = new Cliente("jorge", "geraldo",cpf ,listaRG,listaTL,"M")  ;
		CadastroCliente cadastro1 = new CadastroCliente(empresa.getClientes());
		cadastro1.salvarDireto(cliente);
		
		Produto produto1 = new Produto("sabão",100);
		CadastroProduto cadastrointernoP = new CadastroProduto(empresa.getProdutos());
		cadastrointernoP.salvarDireto(produto1);
		
		
		Compra comprainter=new Compra(empresa.getProdutos(),empresa.getClientes());
		comprainter.Comprando("jorge", "sabão");
		
		ImplementaBanco a =new ImplementaBanco(empresa.getClientes(),empresa.getProdutos());
		a.preencher();
	
		//ListarUmCliente listageminternaC = new ListarUmCliente(empresa.getClientes());
		//Cliente cliente1=(Cliente) listageminternaC.retornaCliente("jorge");
		//System.out.println(cliente1.nomeSocial);
		
		while (execucao) {
			System.out.println("Que tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Listar todos os clientes");
			System.out.println("3 - Listar um cliente");
			System.out.println("4 - Adicionar Compra a um cliente");
			System.out.println("5 - Cadastrar Produto");
			System.out.println("6 - Listar todos os produtos");
			System.out.println("7 - Listar todos os clientes por genero");
			System.out.println("8 - Listar todos os produtos comprados por um cliente");
			System.out.println("9 - Listar 10 clientes que menos compraram");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();
			
			
			
			
			

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
			case 1:
				Cadastro cadastro = new CadastroCliente(empresa.getClientes());
				cadastro.cadastrar();
				break;
			case 2:
				ListarTodosClientes listagem = new ListarTodosClientes(empresa.getClientes());
				listagem.listar();
				break;
		
			case 3:
				
				ListarUmCliente listagemC = new ListarUmCliente(empresa.getClientes());
				listagemC.listar();
				break;
				
			case 4:
				
				
				break;
				
			
			case 5:
				Cadastro cadastroP = new CadastroProduto(empresa.getProdutos());
				cadastroP.cadastrar();
				break;
			case 6:
				Listagem listagemP = new ListarTodosProdutos(empresa.getProdutos());
				listagemP.listar();
				break;
				
			case 7:
				listagem = new ListarTodosClientes(empresa.getClientes());
				listagem.listarGenero();
				break;
				
			case 8:
				listagemC = new ListarUmCliente(empresa.getClientes());
				listagemC.listaProdutosCliente();
				break;
				
			case 9:
				
				listagem = new ListarTodosClientes(empresa.getClientes());
				listagem.listar10(true);
				break;
				
			default:
				System.out.println("Operação não entendida");
				
					
			}
			
			
			
		}
	}
}