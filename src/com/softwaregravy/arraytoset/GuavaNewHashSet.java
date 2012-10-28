package com.softwaregravy.arraytoset;

import com.google.common.collect.Sets;

public class GuavaNewHashSet implements ContainsChecker {

    @Override
    public boolean contain(String[] array, String target) {
        return Sets.newHashSet(array).contains(target);
    }

}
