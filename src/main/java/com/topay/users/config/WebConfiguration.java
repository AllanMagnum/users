package com.topay.users.config;

import com.topay.users.infra.argumentresolver.AbstractHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    private final List<AbstractHandlerMethodArgumentResolver> resolvers = new ArrayList<>();

    /**
     * Constructor for {@link WebConfiguration}
     *
     * @param resolvers list of handler method argument resolvers
     */
    public WebConfiguration(final List<AbstractHandlerMethodArgumentResolver> resolvers) {
        this.resolvers.addAll(resolvers);
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.addAll(this.resolvers);
    }

}
