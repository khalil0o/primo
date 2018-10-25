package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Dao.ProduitRepository;
import com.example.demo.entities.Produit;

@SpringBootApplication
public class ProduitMicroservicesApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(ProduitMicroservicesApplication.class, args);
		
		ProduitRepository produitrepository=ctx.getBean(ProduitRepository.class);
		Stream.of("A","B","C").forEach(s->produitrepository.save(new Produit(s)));
		
		produitrepository.findAll().forEach(s->System.out.println(s.getDesignation()));
		
	
	}
}
