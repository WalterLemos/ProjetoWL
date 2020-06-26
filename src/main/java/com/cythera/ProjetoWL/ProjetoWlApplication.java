package com.cythera.ProjetoWL;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cythera.ProjetoWL.domain.Categoria;
import com.cythera.ProjetoWL.domain.Cidade;
import com.cythera.ProjetoWL.domain.Cliente;
import com.cythera.ProjetoWL.domain.Endereco;
import com.cythera.ProjetoWL.domain.Estado;
import com.cythera.ProjetoWL.domain.Produto;
import com.cythera.ProjetoWL.domain.enums.TipoCliente;
import com.cythera.ProjetoWL.domain.enums.TipoEndereco;
import com.cythera.ProjetoWL.repositories.CategoriaRepository;
import com.cythera.ProjetoWL.repositories.CidadeRepository;
import com.cythera.ProjetoWL.repositories.ClienteRepository;
import com.cythera.ProjetoWL.repositories.EnderecoRepository;
import com.cythera.ProjetoWL.repositories.EstadoRepository;
import com.cythera.ProjetoWL.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoWlApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	


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
	    
	    Estado est1 = new Estado(null, "Minas Gerais");
	    Estado est2 = new Estado(null, "São Paulo" );
	    
	    Cidade c1 = new Cidade(null, "Uberlâdia",est1);
	    Cidade c2 = new Cidade(null,"São Paulo", est2);
	    Cidade c3 = new Cidade(null,"Campinas", est2);
	    
	    Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "74185296344", TipoCliente.PESSOAFISICA);
	    
	    Endereco end1 = new Endereco(null, "Rua Flores", 300, "Apto 303", "Jardim", "38220834", cli1, c1,TipoEndereco.RESIDENCIAL);
	    Endereco end2 = new Endereco(null, "Avenida Matos", 105, "Sala 800", "centro", "38777012", cli1, c2,TipoEndereco.COMERCIAL);
	    
	    
	    cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
	    cat2.getProdutos().addAll(Arrays.asList( p2));
	    
	    p1.getCategorias().addAll(Arrays.asList(cat1));
	    p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	    p3.getCategorias().addAll(Arrays.asList(cat1));
	    
	    est1.getCidades().addAll(Arrays.asList(c1));
	    est2.getCidades().addAll(Arrays.asList(c2,c3));
	    
	    cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
	    cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
	    
	    
		/* Repository*/
	    
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		
		
 
		
	}

}


