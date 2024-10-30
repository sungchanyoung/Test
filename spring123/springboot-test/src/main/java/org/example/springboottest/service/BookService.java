package org.example.springboottest.service;


import lombok.RequiredArgsConstructor;
import org.example.springboottest.dto.request1.PostBookRequestDto;


import org.example.springboottest.dto.response1.GetBookListResponseDto;
import org.example.springboottest.dto.response1.GetBookResponseDto;
import org.example.springboottest.dto.response1.PostBookResponseDto;
import org.example.springboottest.entity.Book;
import org.example.springboottest.repository.BookRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookService {

    private  final BookRepository bookRepository;
    public PostBookResponseDto createBook(PostBookRequestDto dto) {
        PostBookResponseDto data =  null;
        try {
            Book book = new Book(
                    null, dto.getBook_tile(), dto.getBook_author(), dto.getCategory()  );
            bookRepository.save(book);
            data =  new PostBookResponseDto(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  data;
    }

    public List<GetBookListResponseDto> getAllBooks() {
       List<GetBookListResponseDto> data =  null;
        try {
            List<Book> books = bookRepository.findAll();
            data  = books.stream()
                    .map(GetBookListResponseDto::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  data;
    }

    public GetBookResponseDto getBookById(Long id) {
        GetBookResponseDto data = null;
        Optional<Book> bookOptional = bookRepository.findById(id);
        try {
            if(bookOptional.isPresent()){
                data =new GetBookResponseDto(bookOptional.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  data;
    }
}
