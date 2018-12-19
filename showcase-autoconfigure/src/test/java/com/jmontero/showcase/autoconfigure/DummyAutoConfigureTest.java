package com.jmontero.showcase.autoconfigure;

import com.jmontero.dummy.one.DummyOneImpl;
import com.jmontero.showcase.autoconfigure.config.DummyAutoConfigure;
import com.jmontero.showcase.autoconfigure.dummy.NoOpWrapperInterface;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class DummyAutoConfigureTest {



    @Test
    public void checkDummyOneConfiguration()  {

        new ApplicationContextRunner().withPropertyValues("dummy.enabled=true")
                .withConfiguration(AutoConfigurations.of(DummyAutoConfigure.class)).run(context -> {
            assertThat(context).hasBean("dummyOne");
            assertThat(context).doesNotHaveBean("dummyTwo");
        });
    }

    @Test
    public void checkDummyTwoConfiguration()  {

        new ApplicationContextRunner().withPropertyValues("dummy.enabled=true")
                .withConfiguration(AutoConfigurations.of(DummyAutoConfigure.class)).withClassLoader(new FilteredClassLoader(DummyOneImpl.class))
                .run(context -> {
            assertThat(context).doesNotHaveBean("dummyOne");
            assertThat(context).hasBean("dummyTwo");
        });
    }


    @Test
    public void checkNoopCreation()  {

        new ApplicationContextRunner().withPropertyValues("dummy.enabled=false")
                .withConfiguration(AutoConfigurations.of(DummyAutoConfigure.class)).withClassLoader(new FilteredClassLoader(DummyOneImpl.class))
                .run(context -> {
                    assertThat(context).hasBean("noopwrapperInterface");
                    assertThat(context).doesNotHaveBean("dummyOne");
                    assertThat(context).doesNotHaveBean("dummyTwo");
                });
    }




}
