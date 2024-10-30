package org.example.springboottest.dto.response1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;
@Data
@NoArgsConstructor

public class GetBookResponseDto {
    private  Long id;
    private String book_tile;
    private String book_author;
    private Category category;

    public GetBookResponseDto(Book book) {
        this.id= book.getId();
        this.book_tile = book.getBook_title();
        this.book_author = book.getBook_author();
        this.category =book.getCategory();
    }
}
