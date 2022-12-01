package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int current, int size, Book book);

    IPage<Book> getPage(int current, int size);


}
