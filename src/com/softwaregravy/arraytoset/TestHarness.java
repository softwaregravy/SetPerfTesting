package com.softwaregravy.arraytoset;

import java.util.Random;

public class TestHarness {

    static Random r = new Random();
    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] array = new String[10000];
        for (int i = 0; i < array.length; ++i) {
            array[i] = Integer.toString(i);
        }
        runTest("Control", array, new Control());
        runTest("ArrayIteration", array, new ArrayIteration());
        runTest("GuavaNewHashSet", array, new GuavaNewHashSet());
        runTest("HashSetContains", array, new HashSetContains());
        runTest("HashSetContains2", array, new HashSetContains2());
        runTest("HashSetContains3", array, new HashSetContains3());
        runTest("HashSetAddAll", array, new HashSetAddAll());
        runTest("HashSetAddAll2", array, new HashSetAddAll2());
    }

    private static void runTest(String experiment, String[] array, ContainsChecker subject) {
        long start = System.nanoTime();
        for (int i = 0; i < 100000; ++i) {
            // Should give a 50% hit rate
            subject.contain(array, Integer.toString(r.nextInt(20000)));
        }
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println(experiment + ": runtime was " + Double.toString(duration / 1000000000.0));
    }

}
