package com.cythera.ProjetoWL;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cythera.ProjetoWL.domain.Categoria;
import com.cythera.ProjetoWL.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjetoWlApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null,"INFORMÁTICA");
		Categoria cat2 = new Categoria(null,"ESCRITÓRIO");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		
 
		
	}

}


