package com.jmontero.dummy.two;

import com.jmontero.dummy.spi.DummyInterface;

public class DummyTwoImpl implements DummyInterface {
    @Override
    public String dummyFunctionality() {
        return "two";
    }
}
