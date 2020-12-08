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
    @Transactional(timeout = 3,readOnly = false,propagation =Propagation.REQUIRED )
    public void checkout(String username,int id) {
        bookDao.updateStock(id);
        //Thread.sleep(3000);
        int price = bookDao.getPrice(id);
        System.out.println(price);
        bookDao.updateBalance(username,price);
    }
    @Transactional(propagation = Propagation.NESTED)
    public void updatePrice(int id,int price){
        try{
            int i=1/0;
            bookDao.updatePrice(id,price);

        }catch (Exception e){

        }

    }
}
