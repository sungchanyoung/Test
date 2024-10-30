package org.example.springboottest.dto.request1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboottest.entity.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostBookRequestDto<D> {
    private String book_tile;
    private String book_author;
    private Category category;
}
