package com.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll()  {
        return new R(true, bookService.list( ));
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException{
        if(book.getName().equals("123")) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag? "添加成功:)" : "添加失败...");
    }


    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, bookService.getById(id));
    }

    @GetMapping("{current}/{size}")
    public R getPage(@PathVariable int current, @PathVariable int size, Book book){

        IPage page = bookService.getPage(current, size, book);
        if(current > page.getPages()){
            page = bookService.getPage((int)page.getPages(), size, book);
        }
        return new R(true, page);
    }
}
