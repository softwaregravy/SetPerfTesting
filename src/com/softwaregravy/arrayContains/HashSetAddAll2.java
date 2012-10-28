package com.softwaregravy.arrayContains;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetAddAll2 implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        HashSet<String> set = new HashSet<String>(array.length);
        set.addAll(Arrays.asList(array));
        return set.contains(target);
    }

}
