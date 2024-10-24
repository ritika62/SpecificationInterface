package com.springboot.SpecificationInterface.Controller;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPojo {
    private String author;
    private String bookName;
    private Long priceGreaterThan;

    }


