package com.jmontero.showcase.autoconfigure.dummy;

public class NoOpWrapperInterface implements WrapperInterface {
    @Override
    public void executeLogic(String word) {
        //NOOP

    }
}
