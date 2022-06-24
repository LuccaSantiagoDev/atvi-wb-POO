package com.wb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nome;
	public String nomeSocial;
	private CPF cpf;
	private List<RG> rgs;
	private LocalDate dataCadastro;
	private List<Telefone> telefones;
	private List<Produto> produtosConsumidos;
	private List<Servico> servicosConsumidos;
	private String genero;
	public Cliente(String nome, String nomeSocial, CPF cpf,List<RG> rgs,List<Telefone> telefones,String genero) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.rgs = new ArrayList<>(rgs);
		this.dataCadastro = LocalDate.now();
		this.telefones = new ArrayList<>(telefones);
		this.produtosConsumidos = new ArrayList<>();
		this.servicosConsumidos = new ArrayList<>();
		this.genero=genero;
	}
	public CPF getCpf() {
		return cpf;
	}
	public List<RG> getRgs() {
		return rgs;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public List<Produto> getProdutosConsumidos() {
		return produtosConsumidos;
	}
	
	public int getTotalProdutosConsumidos() {
		return produtosConsumidos.size();
	}
	public List<Servico> getServicosConsumidos() {
		return servicosConsumidos;
	}
	
	
	public void ProdutoComprado(Produto Produto) {
		this.produtosConsumidos.add(Produto);
	}
	public String getGenero() {
		return genero;
	}
}