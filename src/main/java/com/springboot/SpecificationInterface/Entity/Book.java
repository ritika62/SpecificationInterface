package com.springboot.SpecificationInterface.Entity;

import jakarta.persistence.*;
import lombok.*;

   @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name="bookable")
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long bid;
        private String bookName;
        private String author;
        private Long price;
        private String category;
    }


