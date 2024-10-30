package org.example.springboottest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.dto.request1.PostBookRequestDto;
import org.example.springboottest.dto.response1.GetBookListResponseDto;
import org.example.springboottest.dto.response1.GetBookResponseDto;
import org.example.springboottest.dto.response1.PostBookResponseDto;
import org.example.springboottest.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test/books")
@RequiredArgsConstructor
public class BookController {
    private  final BookService bookService;

    @PostMapping
    public ResponseEntity<PostBookResponseDto> createBook (@RequestBody PostBookRequestDto  dto){
        PostBookResponseDto createBook = bookService.createBook(dto);
        return ResponseEntity.ok(createBook);// 성공시 책도 반환

    }
    @GetMapping//URL에 대한 GET 요청이 오면 해당 메서드가 호출되는 거지
    public ResponseEntity<List<GetBookListResponseDto>> getAllBooks(){
        List<GetBookListResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBookResponseDto> getById(@PathVariable Long id){
        GetBookResponseDto  book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

}
