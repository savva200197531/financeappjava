package ru.yandex.practicum;

import org.junit.jupiter.api.*;

public class TestDateTest {
    private static TestDate testDate;

    @BeforeAll
    public static void initAll() {
        System.out.println("before all");
    }

    @BeforeEach
    public void init() {
        testDate = new TestDate();
    }

    @Test
    public void testSum() {

        int term1 = 2;
        int term2 = 3;

        int sum = term1 + term2;

        Assertions.assertEquals(5, sum);
    }

    @Test
    public void testGetHi() {
        Assertions.assertEquals("Hi", testDate.getHi());
    }
//
//    @DisplayName("Add operation test")
//    @RepeatedTest(1)
//    void addNumber(TestInfo testInfo, RepetitionInfo repetitionInfo) {
//
//        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
//        Assertions.assertEquals(2, 2, "1 + 1 should equal 2");
//    }
//
//    @BeforeAll
//    public static void init(){
//        System.out.println("BeforeAll init() method called");
//    }
//
//    @BeforeEach
//    public void initEach(){
//        System.out.println("BeforeEach initEach() method called");
//    }
}