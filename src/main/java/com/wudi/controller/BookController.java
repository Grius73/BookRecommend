package com.wudi.controller;

import com.github.pagehelper.PageInfo;
import com.wudi.mapper.BookMapper;
import com.wudi.model.Book;
import com.wudi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public String getBooksTypeList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                   Model model){
        PageInfo<Book> books=bookService.getAllBook(pageNum,pageSize);
        model.addAttribute("books",books);
        return "book/list";
    }

}
