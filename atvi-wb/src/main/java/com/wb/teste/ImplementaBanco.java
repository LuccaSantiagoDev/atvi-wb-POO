package com.wb.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;
import com.wb.negocio.CadastroCliente;

public class ImplementaBanco {
	
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private String[] nomes= {"Jennifer Dunn",
			"Sara Howard",
			"Michael Martinez",
			"Nancy Hernandez",
			"Leslie Walker",
			"Courtney Johnson",
			"Nicole Hall",
			"Ashley Dean",
			"Tiffany Downs",
			"Eddie Nguyen",
			"David Boyd",
			"Keith Torres",
			"Donald Wood",
			"Justin Bowen",
			"Darren Pruitt",
			"Angelica Wallace",
			"Austin Hernandez",
			"Gary Pearson",
			"Spencer Buck",
			"Justin Espinoza",
			"Natasha Hill",
			"Danielle Weaver",
			"Stephanie Rodriguez",
			"Kara Butler",
			"Justin Madden",
			"Dr. Denise Munoz PhD",
			"Cynthia Oneal",
			"Sherri Johnson",
			"Stacey Clarke",
			"Laura Pena"} ;
	
	private String[] nomesP= {"Purse",
			"Magnifying glass",
			"Pair of socks",
			"Pair of binoculars",
			"Rubber duck",
			"Sofa",
			"Stick",
			"Knife",
			"Rug",
			"Cars",
			"Window",
			"Football",
			"Sand paper",
			"Pair of rubber gloves",
			"Ball of yarn",
			"Baseball hat",
			"Purse",
			"Blowdryer",
			"Pair of knitting needles",
			"Tire swing"};

	
	public ImplementaBanco(List<Cliente> clientes ,List<Produto> produtos) {
	
		this.clientes = clientes;
		this.produtos = produtos;
	}



	public void preencher() {
		
		boolean genero=true;
		String g;
		for (int i = 0; i < nomes.length; i++) {
			
			
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
		
			if(genero) {
				g="F";
				genero=!genero;
			}else {
				g="M";
				genero=!genero;
			}
			Cliente cliente = new Cliente(nomes[i], nomes[i],cpf ,listaRG,listaTL,g)  ;
			clientes.add(cliente);
			
		}
		
		Random gerador = new Random();
		for (int i = 0; i < nomesP.length; i++) {
			Produto produto1 = new Produto(nomesP[i],gerador.nextInt(200));
			produtos.add(produto1);
		}
		
		
		for (Cliente cliente : clientes) {
			for (int i = 0; i < gerador.nextInt(7)+1; i++) {
				
				cliente.ProdutoComprado(produtos.get(gerador.nextInt(19)));
			}
		}
		
		
	}
	
	
	
	
}
