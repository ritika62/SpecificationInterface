package com.springboot.SpecificationInterface.Controller;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPojo {
    private String bookName;
    private String author;
    private Long priceGreaterThan;
    private String andParameter1;
    private String andParameter2;
    private String orParameter1;


}

