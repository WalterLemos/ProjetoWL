package com.cythera.ProjetoWL;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cythera.ProjetoWL.domain.Categoria;
import com.cythera.ProjetoWL.domain.Produto;
import com.cythera.ProjetoWL.repositories.CategoriaRepository;
import com.cythera.ProjetoWL.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoWlApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;


	public static void main(String[] args) {
		SpringApplication.run(ProjetoWlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null,"INFORMÁTICA");
		Categoria cat2 = new Categoria(null,"ESCRITÓRIO");
		
		Produto p1 = new Produto(null,"COMPUDATOR",2000.00);
	    Produto p2 = new Produto(null,"IMPRESSORA",800.00);
	    Produto p3 = new Produto(null,"MOUSE",80.00);
	    
	    cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
	    cat2.getProdutos().addAll(Arrays.asList( p2));
	    
	    p1.getCategorias().addAll(Arrays.asList(cat1));
	    p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	    p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
 
		
	}

}


