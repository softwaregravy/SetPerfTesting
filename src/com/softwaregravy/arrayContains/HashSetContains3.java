package com.softwaregravy.arrayContains;

import java.util.HashSet;
import java.util.Set;

public class HashSetContains3 implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        Set<String> set = new HashSet<String>(array.length);
        for(String element : array) 
            set.add(element);
        return set.contains(target);
    }

}
