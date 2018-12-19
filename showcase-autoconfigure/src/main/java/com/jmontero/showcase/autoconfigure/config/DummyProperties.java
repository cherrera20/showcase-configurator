package com.jmontero.showcase.autoconfigure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dummy.props")
@Getter
@Setter
public class DummyProperties {

    private String separator;

    private Integer name;


}
