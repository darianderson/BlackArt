package com.blackwell.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ARTICLE_TAG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTag implements Serializable {
    @Id
//    @ManyToOne
//    @JoinColumn(name = "id", nullable = false)
    private long id;

    @Id
//    @ManyToOne
//    @JoinColumn(name = "idTag", nullable = false)
    private long idTag;
}
