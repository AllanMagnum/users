package com.topay.users.infra.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * This class is the base serializer for all serializations
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 02/04/2020
 */
public abstract class AbstractSerializer<T> extends JsonSerializer<T> {

    @Override
    public void serialize(final T t, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        final JsonWriter jsonWriter = new JsonWriter(jsonGenerator);
        serialize(t, jsonWriter);
    }

    /**
     * The concrete implementation of this method must be able to serialize an object
     *
     * @param value      implementation that will be serialized
     * @param jsonWriter helper implementation to write the return json
     * @throws IOException can be thrown if an exception occurs
     */
    public abstract void serialize(final T value, final JsonWriter jsonWriter) throws IOException;

}
