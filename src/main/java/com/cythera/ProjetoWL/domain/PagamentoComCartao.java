package com.cythera.ProjetoWL.domain;

import javax.persistence.Entity;

import com.cythera.ProjetoWL.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer NumParcelas;
	
	
	public PagamentoComCartao() {
		
		
	}


	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer NumParcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		
		this.NumParcelas = NumParcelas;
	}


	public Integer getNumParcelas() {
		return NumParcelas;
	}


	public void setNumParcelas(Integer numParcelas) {
		NumParcelas = numParcelas;
	}
	
	
	
	

}
