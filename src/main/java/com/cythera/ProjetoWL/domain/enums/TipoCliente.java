package com.cythera.ProjetoWL.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1,"PESSOA FÍSICA"),
	PESSOAJURICA(2, "PESSOA JURÍDICA");
	
	private int cod;
	private String desc;
	
	
	private TipoCliente(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}


	public int getCod() {
		return cod;
	}


	public String getDesc() {
		return desc;
	}

    public static TipoCliente toEunm(Integer cod) {
    	
    	  if (cod == null) {
    		  
    		  return null;
    		  
    	  }
    	
    	  for (TipoCliente x : TipoCliente.values()) {
    		  
    		   if (cod.equals(x.getCod())) {
    			   
    			  return x; 
    		   }
    		  
    	  } 
    	
    	throw new IllegalArgumentException("ID INVÁLIDO" + cod);
    }
	
		
		


}
