package ru.yandex.practicum.codingpractice;

public class CodingPractice extends CodingPracticeTest {
    private int points = 0;

    public CodingPractice() {
        System.out.println("Coding Practice");
    }

    public CodingPractice(String name) {
        System.out.println(name);
    }


    public CodingPractice(int points) {
        this.points = points;
    }

    public CodingPractice(String name, String description) {
        System.out.println(name);
        System.out.println(description);
    }

    private void method() {
        System.out.println("method");
    }

    public void codingPracticeSayHi() {
        codingPracticeTestSayHi();
        System.out.println(a);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    protected void setA(String a) {
        super.setA(a);
    }

    public int getPoints() {
        return points;
    }
}

class CodingPracticeTest {
    public String a = "a";
    void codingPracticeTestSayHi() {
        System.out.println("Hello World");
    }

    protected void setA(String a) {
//        if ()
        this.a = a;
    }
}
