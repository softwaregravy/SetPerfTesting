package com.softwaregravy.arrayContains;

import java.util.Arrays;

public class ArrayBinarySearch implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        return Arrays.binarySearch(array, target) >= 0;
    }

}
