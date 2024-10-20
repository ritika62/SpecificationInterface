package com.springboot.SpecificationInterface.Entity;

import jakarta.persistence.*;
import lombok.*;

    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name="BookTable")
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long bid;
        private String bookName;
        private String author;
        private Long price;
        private String category;
    }


