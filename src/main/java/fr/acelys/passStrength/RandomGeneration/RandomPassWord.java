package fr.acelys.passStrength.RandomGeneration;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPassWord {

    public static int getMin(){
        return 32;
    }

    public static int getMax(){
        return 126;
    }

    public static int getRangeValues(){
        return getMax() - getMin();
    }

    static List<Character> individuals = new ArrayList<>(IntStream.rangeClosed(getMin(), getMax())
            .mapToObj(i -> (char) i)
            .collect(Collectors.toList()));

    public static String newString(int len){
        Collections.shuffle(individuals);
        Random random = new Random(Instant.now().toEpochMilli() + Instant.now().getNano());
        int in = random.nextInt(94 - len);
        return individuals.subList(in, in + len).stream().map(Object::toString).collect(Collectors.joining());
    }

    public static long getPosition(String s){
        // 1 2 3 4 5
        // 1 2 3 4 6
        // 1 2 3 4 7
        return 0L;
    }

}
