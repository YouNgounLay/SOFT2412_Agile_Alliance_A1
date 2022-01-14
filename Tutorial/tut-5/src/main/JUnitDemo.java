package main;

import java.util.Arrays;
import java.util.List;

public class JUnitDemo {

    public int add (int a, int b) {
        return a + b;
    }

    public int subtract (int a, int b) {
        return a - b;
    }

    public int multiply (int a, int b) {
        return a * b;
    }

    public int division (int a, int b) {
        return a/b;
    }

    public int square (int a) {
        return a * a;
    }

    public boolean isOddNumber (int a) {
        if (a%2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String setText (String a) {
        return a;
    }

    public List<String> setList (String a, String b, String c) {
        List<String> arraylist = Arrays.asList(a, b, c);
        return arraylist;
    }
}