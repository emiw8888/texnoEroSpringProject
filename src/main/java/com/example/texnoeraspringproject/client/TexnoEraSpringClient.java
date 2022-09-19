package com.example.texnoeraspringproject.client;

import com.example.texnoeraspringproject.model.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "texnoera-university-project",
        url = "${url}"
//        configuration = TexnoEraSpringClientErrorDecoder.class
)
public interface TexnoEraSpringClient {
    @GetMapping("/v1/books")
    List<BookDto> getBooks();
}
