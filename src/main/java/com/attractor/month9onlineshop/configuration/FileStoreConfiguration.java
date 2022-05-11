package com.attractor.month9onlineshop.configuration;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;

@Data
@Configuration
@ConfigurationProperties(prefix = "file-store")
public class FileStoreConfiguration {
    private String path;
}
