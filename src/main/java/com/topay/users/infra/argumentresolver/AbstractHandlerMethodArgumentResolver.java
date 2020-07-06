package com.topay.users.infra.argumentresolver;

import org.springframework.core.GenericTypeResolver;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Class comments go here...
 *
 * @author Allan Magnum Mello de Mendonça
 * @version 1.0 22/06/2019
 */
public abstract class AbstractHandlerMethodArgumentResolver<T> implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(final MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(resolveParameterTyped());
    }

    @Override
    public T resolveArgument(final MethodParameter methodParameter, final ModelAndViewContainer modelAndViewContainer,
                             final NativeWebRequest nativeWebRequest,
                             final WebDataBinderFactory webDataBinderFactory) {
        return resolveArgument(nativeWebRequest);
    }

    /**
     * @param nativeWebRequest
     * @return
     * @throws Exception
     */
    public abstract T resolveArgument(final NativeWebRequest nativeWebRequest);

    private Class<?> resolveParameterTyped() {
        return GenericTypeResolver.resolveTypeArgument(getClass(), AbstractHandlerMethodArgumentResolver.class);
    }

}
