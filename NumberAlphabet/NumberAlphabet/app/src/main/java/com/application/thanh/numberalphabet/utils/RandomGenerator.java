package com.application.thanh.numberalphabet.utils;

import android.util.Log;
import android.widget.TextView;

import org.xml.sax.Parser;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Thanh on 1/14/2016.
 */
public class RandomGenerator {
//    Random number character ?
    public static int nextIntInRange(int min, int max, Random rng) {
        if (min > max) {
            throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
        }
        int diff = max - min;
        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + rng.nextInt(diff + 1));
        }
        int i;
        do {
            i = rng.nextInt();
        } while (i < min || i > max);
        return i;
    }
//    Random Answer
    public  static ArrayList<Integer> randomNumberList(int min, int max){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 7) {
            int random = RandomGenerator.nextIntInRange(min, max, randomGenerator);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return  numbers;
    }
    // Location question
    public static ArrayList<Integer> randomNumberLocal(int min, int max, int numberQuestion){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < numberQuestion) {
            int random = RandomGenerator.nextIntInRange(min, max, randomGenerator);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
            }
            return  numbers;
        }
    public static ArrayList<Integer> randomNumberAnswer( int min, int max, ArrayList<Integer> arrayList){
            ArrayList<Integer> object = new ArrayList<>();
            ArrayList<Integer> numbers = new ArrayList<>();
            int size = 6 - arrayList.size();
            Random randomGenerator = new Random();
            while (numbers.size() < size) {
                int random = RandomGenerator.nextIntInRange(min, max, randomGenerator);
                if (!arrayList.contains(random) && !numbers.contains(random)) {
                    numbers.add(random);
                }
            }
            for(int i=0; i<arrayList.size(); i++ ){
                numbers.add(arrayList.get(i));
            }
            while (object.size() < 6) {
                int idx = new Random().nextInt(numbers.size());
                int random = (numbers.get(idx));
                if (!object.contains(random)) {
                    object.add(random);
                }
            }
        return  object;
    }
    public static ArrayList<Integer> randomNumberAuto(int min, int max){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = min; i<= max; i++){
            numbers.add(i);
        }
        return  numbers;
    }
    public  static ArrayList<Integer> randomNumberListBubble(int min, int max){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 5) {
            int random = RandomGenerator.nextIntInRange(min, max, randomGenerator);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return  numbers;
    }
}
