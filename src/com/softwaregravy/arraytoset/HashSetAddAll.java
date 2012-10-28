package com.softwaregravy.arraytoset;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetAddAll implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        HashSet<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(array));
        return set.contains(target);
    }

}
