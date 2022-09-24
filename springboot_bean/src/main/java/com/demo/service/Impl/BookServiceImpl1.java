package com.demo.service.Impl;

import com.demo.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl1 implements BookService {
    @Override
    public void check() {
        System.out.println("BookService   1   ......");
    }
}
