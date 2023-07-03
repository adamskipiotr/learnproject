package com.pada.learnproject.graphqlexample;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

//    TODO implement
//    @QueryMapping
//    public Page<Book> books(int page, int size) {
//        PageRequest pageRequest = PageRequest.of(page,size);
//        return bookRepository.findAll(page);
//    }


    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }

    @SchemaMapping(typeName = "Query", field = "author")
    public Author getAuthorById(@Argument String id) {
        return Author.getById(id);
    }

    @MutationMapping
    public void createBook(@Argument BookInput bookInput){
        System.out.println(bookInput.getName());
    }
}

