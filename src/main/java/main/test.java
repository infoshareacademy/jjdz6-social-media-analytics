package main;


import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Paris");
        stringList.add("Poland");
        stringList.add("Sweden");
        stringList.add("Italy");


        for (String s :stringList) {
            System.out.println(s);
        }

    }

}