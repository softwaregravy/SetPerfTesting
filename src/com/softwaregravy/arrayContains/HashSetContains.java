package com.softwaregravy.arrayContains;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetContains implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        return new HashSet(Arrays.asList(array)).contains(target);
    }

}
