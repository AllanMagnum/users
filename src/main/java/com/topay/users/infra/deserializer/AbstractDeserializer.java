package com.topay.users.infra.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * This class aims to serve as the basis for all classes that extends {@link AbstractDeserializer}
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 02/04/2020
 */
public abstract class AbstractDeserializer<T> extends JsonDeserializer<T> {

    @Override
    public T deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        final ObjectCodec codec = jsonParser.getCodec();
        final JsonNode jsonNode = codec.readTree(jsonParser);
        return deserialize(jsonNode);
    }

    /**
     * The concrete implementation of this method must be able to read a JsonNode and convert it into an object
     *
     * @param jsonNode object with the information to be read and deserialized
     * @return deserialized object
     * @throws IOException can be thrown during the deserialization process if an error occurs
     */
    public abstract T deserialize(final JsonNode jsonNode) throws IOException;

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected String getFieldTextValue(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.hasNonNullAndNonEmpty(jsonNode, fieldName) ? jsonNode.get(fieldName.toString()).textValue() : null;
    }

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected Double getFieldDoubleValue(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.hasNonNullAndNonEmpty(jsonNode, fieldName) ? Double.parseDouble(jsonNode.get(fieldName.toString()).asText()) : null;
    }

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected Long getFieldLongValue(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.hasNonNullAndNonEmpty(jsonNode, fieldName) ? Long.parseLong(jsonNode.get(fieldName.toString()).asText()) : null;
    }

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected Integer getFieldIntegerValue(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.hasNonNullAndNonEmpty(jsonNode, fieldName) ? Integer.parseInt(jsonNode.get(fieldName.toString()).asText()) : null;
    }

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected JsonNode getFieldJsonNodeValue(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.hasNonNull(jsonNode, fieldName) ? jsonNode.get(fieldName.toString()) : null;
    }

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected boolean hasNonNullAndNonEmpty(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.hasNonNull(jsonNode, fieldName) && jsonNode.get(fieldName.toString()).asText().length() > 0;
    }

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected boolean hasNonNull(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.has(jsonNode, fieldName) && jsonNode.hasNonNull(fieldName.toString());
    }

    /**
     * This implementation returns whether the searched field exists or not
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return value found
     */
    protected boolean has(final JsonNode jsonNode, final Enum<?> fieldName) {
        return jsonNode.has(fieldName.toString());
    }

    /**
     * This implementation returns the value of the object being searched
     *
     * @param jsonNode  implementation with the objects to be searched
     * @param fieldName name of the object to be found
     * @return another json node
     */
    protected JsonNode get(final JsonNode jsonNode, final Enum<?> fieldName) {
        return this.has(jsonNode, fieldName) ? jsonNode.get(fieldName.toString()) : null;
    }

}
