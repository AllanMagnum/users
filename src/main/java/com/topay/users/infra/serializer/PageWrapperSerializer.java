package com.topay.users.infra.serializer;

import com.topay.users.infra.util.DefaultApplicationContextHolder;
import com.topay.users.infra.wrapper.PageWrapper;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.topay.users.infra.serializer.SerializationLabels.*;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 03/05/2020
 */
public class PageWrapperSerializer<E extends Page> extends AbstractSerializer<PageWrapper<E>> {

    private final Map<Class<?>, AbstractSerializer> serializers = DefaultApplicationContextHolder.getBean("serializers", Map.class);

    @Override
    public void serialize(final PageWrapper<E> wrapper, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        serializeContent(wrapper, jsonWriter);
        jsonWriter.writeNumberField(ACTUAL_PAGE, wrapper.getActualPage());
        jsonWriter.writeNumberField(TOTAL_PAGES, wrapper.getTotalOfPages());
        jsonWriter.writeNumberField(PAGE_SIZE, wrapper.getPageSize());
        jsonWriter.writeEndObject();
    }

    private void serializeContent(final PageWrapper<E> wrapper, final JsonWriter jsonWriter) throws IOException {
        final List content = wrapper.getContent();
        jsonWriter.writeArrayFieldStart(PAGE);
        for (final Object element : content) {
            final Class<?> clazz = element.getClass();
            final AbstractSerializer serializer = serializers.get(clazz);
            serializer.serialize(element, jsonWriter);
        }
        jsonWriter.writeEndArray();
    }

}
