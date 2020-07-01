package com.cythera.ProjetoWL.domain.enums;

public enum TipoEndereco {
	
	RESIDENCIAL(1,"PESSOA FÍSICA"),
	COMERCIAL(2, "PESSOA JURÍDICA");
	
	private int cod;
	private String desc;
	
	
	private TipoEndereco(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}


	public int getCod() {
		return cod;
	}


	public String getDesc() {
		return desc;
	}


	public static TipoEndereco toEnum(Integer cod) {
		
		if (cod == null) {
			
			return null;
		}
		
		for (TipoEndereco x : TipoEndereco.values()) {
			
			if (cod.equals(x.getCod())) {
			
				return x;
			}
			
			
		
		}
		
		throw new IllegalArgumentException("Id inválido" + cod);
		
		
		
	}

}
