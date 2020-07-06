package com.topay.users.infra.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 03/05/2020
 */
@Component
public class DefaultApplicationContextHolder implements ApplicationContextAware {

    private static volatile ApplicationContext applicationContext;

    /**
     * @param beanName
     * @param clazz
     * @param <T>
     *
     * @return
     */
    public static <T> T getBean(final String beanName, final Class<T> clazz) {
        return (T) applicationContext.getBean(beanName);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        DefaultApplicationContextHolder.applicationContext = applicationContext;
    }

}
