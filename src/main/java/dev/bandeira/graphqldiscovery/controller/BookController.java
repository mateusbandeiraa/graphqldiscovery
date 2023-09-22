package dev.bandeira.graphqldiscovery.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import dev.bandeira.graphqldiscovery.model.Author;
import dev.bandeira.graphqldiscovery.model.Book;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.findById(id);
    }
    
    @QueryMapping(value = "allBooks")
    public List<Book> findAll(){
    	return Book.findAll();
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}