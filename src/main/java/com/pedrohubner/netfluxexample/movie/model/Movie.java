package com.pedrohubner.netfluxexample.movie.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @NonNull
    private String id;
    private String title;
}
