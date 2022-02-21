package com.gedielf.bookstoremanager.controller;

import com.gedielf.bookstoremanager.dto.MessageResponseDTO;
import com.gedielf.bookstoremanager.entity.Book;
import com.gedielf.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired //Fazer injerçao de dependecia da class bookrepository para dentro dessa class
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping //este metodo vai ser responsavel para ser passado junto ao corpo do livro
    public MessageResponseDTO create(@RequestBody Book book){
        Book savedBook= bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID" + savedBook.getId())
                .build();
    }
}
