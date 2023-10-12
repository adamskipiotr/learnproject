package com.pada.learnproject.graphqlexample;

import lombok.Data;

@Data
public class BookInput {

    private String name;
    private int pageCount;
}