package testmain;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)  {

    display(listScopes());


    }

    private static final List<String> scopes = new ArrayList<>();

    public static List<String>listScopes() {
        scopes.add("openid");
        scopes.add("email");
        scopes.add("profile");
        return scopes;
    }

    public static void display(List<String> some) {
        for (String s : some
             ) {
            System.out.println(s);
        }

    }
}


