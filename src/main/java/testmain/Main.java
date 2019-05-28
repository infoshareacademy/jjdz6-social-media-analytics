package testmain;


import pl.com.socialmediaanalytics.twitter.service.TrendLocationService;
import pl.com.socialmediaanalytics.twitter.service.TwitterTrendService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        TrendLocationService t = new TrendLocationService();
//        List<String>stringList = t.listNAME();
//        List<Integer>integerList = t.listWEOID();
//        Map<String,Integer>stringIntegerMap = new HashMap<>();
//
//        for (int i = 0; i <stringList.size(); i++) {
//            stringIntegerMap.put(stringList.get(i),integerList.get(i));
//        }
//        if (stringIntegerMap.keySet().contains("Fresno")){
//            System.out.println(stringIntegerMap.get("Fresno"));
//        }
       TwitterTrendService ts = new TwitterTrendService();
        System.out.println(ts.WEOID());


    }

    }

