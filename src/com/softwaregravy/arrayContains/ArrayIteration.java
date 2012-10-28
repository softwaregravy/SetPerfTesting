package com.softwaregravy.arrayContains;

public class ArrayIteration implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        for (String element : array) {
            if (target.equals(element))
                return true;
        }
        return false;
    }

}
