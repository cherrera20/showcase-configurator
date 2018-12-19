package com.jmontero.showcase.autoconfigure.dummy;

import com.jmontero.dummy.spi.DummyInterface;
import com.jmontero.showcase.autoconfigure.config.DummyProperties;

import javax.inject.Inject;

public class WrapperImpl implements WrapperInterface {


    private DummyInterface dummyInterface;

    private DummyProperties dummyProperties;

    @Inject
    public WrapperImpl(DummyInterface dinterface, DummyProperties dProps) {

        this.dummyInterface = dinterface;
        this.dummyProperties = dProps;
    }

    @Override
    public void executeLogic(String word) {

        System.out.println(this.dummyProperties.getName() + this.dummyProperties.getSeparator() + word
                + this.dummyProperties.getSeparator() + this.dummyInterface.dummyFunctionality());
    }
}
