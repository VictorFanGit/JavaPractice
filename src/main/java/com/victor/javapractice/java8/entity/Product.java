package com.victor.javapractice.java8.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Product {

    private Long id;

    private String name;

    public static List<Product> getData() {
        List<Product> list = Lists.newArrayList();
        list.add(new Product(1L, "a"));
        list.add(new Product(2L, "b"));
        list.add(new Product(3L, "c"));
        return list;
    }

}
