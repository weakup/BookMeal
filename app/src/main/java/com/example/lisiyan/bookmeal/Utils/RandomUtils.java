package com.example.lisiyan.bookmeal.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lisiyan on 2017/12/14.
 */

public class RandomUtils {

    static String food ="蒸羊羔、蒸熊掌、蒸鹿尾儿、烧花鸭、烧雏鸡、烧子鹅、卤猪、卤鸭、酱鸡、腊肉、松花小肚儿、晾肉、香肠儿、什锦苏盘、熏鸡白肚儿、清蒸八宝猪";

    public static String []foods = food.split("、");

    public static int randomNumber(int min,int max){

        Random random = new Random();

        int s = random.nextInt(max)%(max - min + 1) + min;

        return s;
    }

}
