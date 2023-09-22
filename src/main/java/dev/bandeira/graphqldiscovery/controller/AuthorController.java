package dev.bandeira.graphqldiscovery.controller;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import dev.bandeira.graphqldiscovery.model.Author;

@Controller
public class AuthorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);


	@QueryMapping("allAuthors")
	public List<Author> findAll(){
		return Author.findAll();
	}
	
	@SchemaMapping
	public CompletableFuture<String> expensiveField(Author author) {
		return CompletableFuture.supplyAsync(() -> {
			LOGGER.info("Will wait 3 seconds for {}", author);
			try {
				Thread.sleep(3_000);
			} catch (InterruptedException e) {
				throw new UndeclaredThrowableException(e);
			}
			return author.id() + "_3";
		});
	}
}
