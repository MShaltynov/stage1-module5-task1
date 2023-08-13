package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean result = true;
            for (String s : x) {
                char[] chars = s.toCharArray();
                if (!Character.isUpperCase(chars[0])) {
                    result = false;
                }
            }
            return result;
        };
    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> result = new ArrayList<>();
            for (Integer i : integers) {
                if (i % 2 == 0) {
                    result.add(i);
                }
            }
            integers.addAll(result);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String s : values) {
                char[] chars = s.toCharArray();
                String[] words = s.split(" ");
                if (Character.isUpperCase(chars[0]) && chars[chars.length - 1] == '.' && words.length > 3) {
                    result.add(s);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return (List<String> strings) -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : strings) {
                map.put(s, s.length());
            }
            return map;
        };


    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (List<Integer> integers, List<Integer> integers2) -> {
            List<Integer> result = new ArrayList<>(integers);
            result.addAll(integers2);
            return result;
        };
    }
}
