package com.blackwell.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TAG")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTag;

    private String nameTag;




}
