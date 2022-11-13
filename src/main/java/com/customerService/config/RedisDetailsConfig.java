package com.customerService.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(value = "redis")
public class RedisDetailsConfig {
    private String host;
    private Long port;
    private Long ttl;

    public RedisDetailsConfig(String host, Long port, Long ttl) {
        this.host = host;
        this.port = port;
        this.ttl = ttl;
    }

    public String getHost() {
        return host;
    }

    public Long getPort() {
        return port;
    }

    public Long getTtl() {
        return ttl;
    }
}
