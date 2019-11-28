package com.blackwell.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ARTICLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String text;
    private String author;
    private String authorsEmail;
    private int positiveFeedback;
    private int negativeFeedback;

    @OneToMany(cascade = CascadeType.ALL)
    @CollectionTable(name = "ARTICLE_TAG",
            joinColumns = @JoinColumn(name = "idTag"))
    protected List<Tag> contentTags = new LinkedList<>();




}