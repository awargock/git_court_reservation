package com.example.SpringORM;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WebController.class)
//@SpringBootTest
public class SpringOrmApplicationTests {

	@Test
    public void testHomeController() {
        WebController webController = new WebController();
        String result = webController.homepage();
        assertEquals(result, "Hello world!");
    }

}

