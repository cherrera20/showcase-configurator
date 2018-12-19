package com.jmontero.showcase.autoconfigure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DummyDisabledConfigure.class, DummyEnabledConfigure.class})
public class DummyAutoConfigure {


}
