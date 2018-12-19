package com.jmontero.showcase.autoconfigure.config;

import com.jmontero.showcase.autoconfigure.dummy.NoOpWrapperInterface;
import com.jmontero.showcase.autoconfigure.dummy.WrapperInterface;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "dummy.enabled",havingValue = "false")
public class DummyDisabledConfigure {


    @Bean
    public WrapperInterface noopwrapperInterface() {

        return new NoOpWrapperInterface();
    }

}
