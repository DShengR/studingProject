package com.dsr.testspring.anno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class MultiService {
    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx(){
        bookService.checkout("zhangsan",1);
        bookService.updatePrice(1,1000);
    }
}
