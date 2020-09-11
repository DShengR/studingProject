package com.dsr.testspring.anno.service;

import com.dsr.testspring.anno.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     * 结账：传入哪个用户买了哪本书
     * @param username
     * @param id
     */
    //@Transactional(rollbackFor = {FileNotFoundException.class})
    //@Transactional(rollbackForClassName = {"java.io.FileNotFoundException"})
    //@Transactional(readOnly = true)
   // @Transactional( isolation=Isolation.SERIALIZABLE )
    @Transactional(propagation = Propagation.REQUIRED)
    public void checkout(String username,int id) throws FileNotFoundException {
        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        bookDao.updateBalance(username,price);
    }
}
