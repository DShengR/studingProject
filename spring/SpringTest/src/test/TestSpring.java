package test;

import com.dsr.testspring.anno.Controller.PersonController;
import com.dsr.testspring.anno.dao.PersonDao;
import com.dsr.testspring.anno.service.PersonService;
import com.dsr.testspring.bean.Person;
import com.dsr.testspring.dao.impl.PersonDaoImpl;
import com.dsr.testspring.factory.MyBeanPostProcesser;
import com.dsr.testspring.factory.PersonFactoryBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class TestSpring {
    ApplicationContext context;
    @Before
    public void beforeSpring(){
        context=new ClassPathXmlApplicationContext(new String[]{"ioc.xml","IOC-anno.xml","aop.xml"});
    }
    @Test
    public void test01(){

        Person person = (Person) context.getBean("person");
        Person person1 = context.getBean("person", Person.class);
        System.out.println(person);

        Person bean2 = context.getBean("person2",Person.class);
        System.out.println(bean2);
     //   Person person5 = context.getBean("person5", Person.class);
       // System.out.println(person5);


        Person son = context.getBean("son", Person.class);
        System.out.println("son:"+son);
        //Person parent = context.getBean("parent", Person.class);
        //System.out.println("parent:"+parent);

        System.out.println("------static factory-------------");
        Person personStatic=context.getBean("personStatic",Person.class);
        System.out.println("static factory:"+personStatic);

        System.out.println("------instance factory-------------");
        Person personInst=context.getBean("personInst",Person.class);
        System.out.println("instance personInst:"+personInst);

        System.out.println("------factory-bean-------------");
        Person personFactoryBean=context.getBean("personFactoryBean",Person.class);
        System.out.println("factory-bean:"+personFactoryBean);


        System.out.println("------bean-post-processer-------------");
        MyBeanPostProcesser personProcesser=context.getBean("beanPostProcesser", MyBeanPostProcesser.class);
        System.out.println("factory-bean:"+personProcesser);


        System.out.println("------autowire-processer-------------");
        Person autoWirePerson=context.getBean("autoWirePerson",Person.class);
        System.out.println("factory-bean:"+autoWirePerson);


        System.out.println("------spel-processer-------------");
        Person personSpel=context.getBean("personSpel",Person.class);
        System.out.println("factory-bean:"+personSpel);
    }
    @Test
    public void testAnno(){

        Object personController = context.getBean("personController1", PersonController.class);
        System.out.println(personController);
        Object personController2 = context.getBean("personController1", PersonController.class);
        System.out.println(personController2);
        System.out.println(personController2==personController);
    }
    @Test
    public void testAnno2(){
        Object personDao = context.getBean("personService", PersonService.class);
        System.out.println(personDao);
    }

    @Test
    public void testAutoWired(){
        PersonService s1 = context.getBean("personService", PersonService.class);
        PersonService s2 = context.getBean("personService", PersonService.class);
        System.out.println(s1==s2);
        PersonController controller = context.getBean("personController1", PersonController.class);
        System.out.println(controller);
        controller.control();
        System.out.println(s1==controller.personService2);
    }

}
