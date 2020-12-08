package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.dsr.testspring.anno.service.BookService;
import com.dsr.testspring.anno.service.MultiService;
import com.dsr.testspring.dao.BaseDao;
import com.dsr.testspring.dao.impl.PersonDaoImpl;
import com.dsr.testspring.proxy.MyProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAop {
    /*    @Test
        public void test01(){
            BaseDao personDao = (BaseDao)MyProxy.getProxy(new PersonDaoImpl());
            Map paraIns=new HashMap();
            paraIns.put("name", "dsr");
            personDao.insert("insertPerson",paraIns);
            personDao.delete("deletePerson",paraIns);
            personDao.update("updatePerson",paraIns);
            List insertPerson = personDao.query("getPerson", paraIns);
        }*/
    @Test
    public void test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");
        PersonDaoImpl personDao = context.getBean("personDaoImpl", PersonDaoImpl.class);
        Map paraIns=new HashMap();
/*        paraIns.put("name", "dsr");
        int insertPerson = personDao.insert("insertPerson", paraIns);

        System.out.println("-------------------------");
        paraIns.put("id", "1");
        List queryList = personDao.query("queryPerson", paraIns);*/

        System.out.println("-------------------------");
        paraIns.put("id", "1");
        Map paraDel=null;
        personDao.delete("queryPerson", paraIns);
        System.out.println(personDao.getClass());
    }

    @Test
    public void testXmlAop(){
        ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");

        PersonDaoImpl personDao = context.getBean("personDaoImpl", PersonDaoImpl.class);
        Map paraIns=new HashMap();
        paraIns.put("id", "1");
        personDao.delete("delete", paraIns);
    }
    @Test
    public void testTx(){
        ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        String sql="insert into dsr(id,name)\n" +
                "values('09','dsr')";
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from dsr ");
        for(Map map :maps){
            System.out.println(map);
        }
        DataSourceTransactionManager transactionManager = context.getBean("transactionManager", DataSourceTransactionManager.class);
    }
    @Test
    public void testTx2() throws FileNotFoundException, InterruptedException {
        ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.checkout("lisi", 1);
    }

    @Test
    public void testTx3() throws FileNotFoundException, InterruptedException {
        ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");
        BookService service=context.getBean("bookService",BookService.class);
        //service.checkout("lisi", 3);
        MultiService multiService = context.getBean("multiService", MultiService.class);
        multiService.mulTx();
    }
}

