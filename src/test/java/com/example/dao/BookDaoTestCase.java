package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据666");
        book.setName("测试数据888");
        book.setDescription("测试数据999");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(10);
        book.setType("测试数据666");
        book.setName("测试数据888");
        book.setDescription("测试数据999");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(11);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(2, 5);
        bookDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
    }
//
//    @Test
//    void testGetBy() {
//        QueryWrapper<Book> qw = new QueryWrapper<>();
//        qw.like("name","plus");
//        bookDao.selectList(qw);
//    }
    @Test
    void testGetBy() {
        String name = "java";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //需要判断是否为null
        lqw.like(name != null, Book::getName,"plus");
        bookDao.selectList(lqw);
    }


}