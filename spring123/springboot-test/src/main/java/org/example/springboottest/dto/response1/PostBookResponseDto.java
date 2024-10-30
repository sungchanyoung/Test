package org.example.springboottest.dto.response1;

import lombok.*;
import org.example.springboottest.dto.request1.PostBookRequestDto;
import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;

@Getter
@Setter
@NoArgsConstructor
public class PostBookResponseDto{
    private  Long id;
    private String book_tile;
    private String book_author;
    private Category category;

    public PostBookResponseDto(Book book) {
        this.id= book.getId();
        this.book_tile = book.getBook_title();
        this.book_author = book.getBook_author();
        this.category =book.getCategory();
    }
}
