package com.blackwell.main.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Article {
    private long id;
    private String title;
    private String text;
    private String author;
    private String authorsEmail;
    private int positiveFeedback;
    private int negativeFeedback;
}