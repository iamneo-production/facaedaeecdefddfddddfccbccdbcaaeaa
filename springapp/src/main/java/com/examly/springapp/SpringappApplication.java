package com.examly.springapp;
import com.examly.springapp.MainClass;

public class SpringappApplication {
    public static void main(String[] args) {
        MainClass test = new MainClass();
        test.setup();
        test.testDragAndDrop();
        test.teardown();
    }
}
