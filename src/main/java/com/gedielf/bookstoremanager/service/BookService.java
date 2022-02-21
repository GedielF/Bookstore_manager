package com.gedielf.bookstoremanager.service;

import com.gedielf.bookstoremanager.dto.MessageResponseDTO;
import com.gedielf.bookstoremanager.entity.Book;
import com.gedielf.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//classe responsavel para criaçao de livros
@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @PostMapping //este metodo vai ser responsavel para ser passado junto ao corpo do livro
    public MessageResponseDTO create( Book book){
        Book savedBook= bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID" + savedBook.getId())
                .build();
    }
}
