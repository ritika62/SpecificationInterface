package com.springboot.SpecificationInterface.Controller;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestPojo {
    private String author;
    private String bookName;
    private Long priceGreaterThan;

}

