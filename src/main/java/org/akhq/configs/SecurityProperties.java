package org.akhq.configs;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;
import lombok.Data;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties("akhq.security")
@Data
public class SecurityProperties {
    private List<BasicAuth> basicAuth = new ArrayList<>();
    private String defaultGroup;

    @MapFormat(transformation = MapFormat.MapTransformation.FLAT)
    private Map<String, Group> groups = new HashMap<>();

    @PostConstruct
    public void init() {
        groups.entrySet().forEach(entry -> entry.getValue().setName(entry.getKey()));
    }
}
