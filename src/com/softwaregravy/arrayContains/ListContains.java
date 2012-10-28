package com.softwaregravy.arrayContains;

import java.util.Arrays;

public class ListContains implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        return Arrays.asList(array).contains(target);
    }

}
