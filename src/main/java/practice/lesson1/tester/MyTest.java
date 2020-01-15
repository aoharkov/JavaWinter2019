package practice.lesson1.tester;

import practice.lesson1.tester.annotations.After;
import practice.lesson1.tester.annotations.AfterAll;
import practice.lesson1.tester.annotations.Before;
import practice.lesson1.tester.annotations.BeforeAll;
import practice.lesson1.tester.annotations.Test;

public class MyTest {
    @BeforeAll
    public void beforeAll1() {
        System.out.println("================\nbeforeAll 1\n================");
    }
    @Before
    public void before1() {
        System.out.println("before 1");
    }

    @After
    public void after1() {
        System.out.println("after 1\n----------------");
    }

    @AfterAll
    public void afterAll1() {
        System.out.println("afterAll 1\n================");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    private void noTest() {
        System.out.println("not a test");
    }
}
