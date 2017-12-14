package com.example.lisiyan.bookmeal.Utils;

import java.util.Random;

/**
 * Created by lisiyan on 2017/12/14.
 */

public class RandomUtils {

    public static int randomNumber(int min,int max){

        Random random = new Random();

        int s = random.nextInt(max)%(max - min + 1) + min;

        return s;
    }
}
