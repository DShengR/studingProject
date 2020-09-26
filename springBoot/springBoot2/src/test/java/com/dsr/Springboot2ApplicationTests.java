package com.dsr;

import com.dsr.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot2ApplicationTests {

	@Autowired
	private Person person;
	@Test
	void contextLoads() {
		System.out.println(person);
	}

}
