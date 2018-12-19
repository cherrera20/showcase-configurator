package com.jmontero.showcase.autoconfigure.config;

import com.jmontero.dummy.one.DummyOneImpl;
import com.jmontero.dummy.spi.DummyInterface;
import com.jmontero.dummy.two.DummyTwoImpl;
import com.jmontero.showcase.autoconfigure.dummy.WrapperImpl;
import com.jmontero.showcase.autoconfigure.dummy.WrapperInterface;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "dummy.enabled")
@EnableConfigurationProperties(DummyProperties.class)
public class DummyEnabledConfigure {

    @Bean
    @ConditionalOnMissingBean(DummyInterface.class)
    @ConditionalOnClass(DummyOneImpl.class)
    public DummyInterface dummyOne() {
        return new DummyOneImpl();
    }

    @Bean
    @ConditionalOnMissingBean(DummyInterface.class)
    @ConditionalOnClass(DummyTwoImpl.class)
    public DummyInterface dummyTwo() {
        return new DummyOneImpl();
    }

    @Bean
    public WrapperInterface wrapperInterface(DummyInterface dummyInterface, DummyProperties dummyProperties) {

        return new WrapperImpl(dummyInterface, dummyProperties);
    }

}
