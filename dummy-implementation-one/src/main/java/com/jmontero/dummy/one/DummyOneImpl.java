package com.jmontero.dummy.one;

import com.jmontero.dummy.spi.DummyInterface;

public class DummyOneImpl implements DummyInterface {
    @Override
    public String dummyFunctionality() {
        return "one";
    }
}
