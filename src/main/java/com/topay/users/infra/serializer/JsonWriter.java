package com.topay.users.infra.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * This class is a helper class, for wrap jsonGenerator and simplifying the way it is done
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 02/04/2020
 */
public class JsonWriter {

    private final JsonGenerator jsonGenerator;

    /**
     * Constructor gets the original attribute responsible for writing json data and an attribute to set the property to write null values ​​as empty
     * values
     *
     * @param jsonGenerator implementation of jackson with rule to write json
     */
    public JsonWriter(final JsonGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    /**
     * This method will open a json object to serialize information
     *
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeStartObject() throws IOException {
        jsonGenerator.writeStartObject();
    }

    /**
     * This method will serialize a {@link BigDecimal} field in the json
     *
     * @param fieldName enum value with field label, the enum's toString () method will be invoked within the method
     * @param value     content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeNumberField(final Enum<?> fieldName, final BigDecimal value) throws IOException {
        jsonGenerator.writeNumberField(fieldName.toString(), value);
    }

    /**
     * This method will serialize a {@link Long} field in the json
     *
     * @param fieldName enum value with field label, the enum's toString () method will be invoked within the method
     * @param value     content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeNumberField(final Enum<?> fieldName, final Long value) throws IOException {
        jsonGenerator.writeNumberField(fieldName.toString(), value);
    }

    /**
     * This method will serialize a {@link Integer} field in the json
     *
     * @param fieldName enum value with field label, the enum's toString () method will be invoked within the method
     * @param value     content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeNumberField(final Enum<?> fieldName, final Integer value) throws IOException {
        jsonGenerator.writeNumberField(fieldName.toString(), value);
    }

    /**
     * This method will serialize a {@link String} field in the json
     *
     * @param fieldName enum value with field label, the enum's toString () method will be invoked within the method
     * @param value     content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeStringField(final Enum<?> fieldName, final String value) throws IOException {
        if (!ObjectUtils.isEmpty(value)) {
            jsonGenerator.writeStringField(fieldName.toString(), value);
        }
    }

    /**
     * This method will serialize a {@link Enum} as {@link String} field in the json
     *
     * @param fieldName enum value with field label, the enum's toString () method will be invoked within the method
     * @param value     content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeStringField(final Enum<?> fieldName, final Enum<?> value) throws IOException {
        jsonGenerator.writeStringField(fieldName.toString(), value.toString());
    }

    /**
     * This method will open array object by putting a name in the field
     *
     * @param fieldName
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeArrayFieldStart(final Enum<?> fieldName) throws IOException {
        jsonGenerator.writeArrayFieldStart(fieldName.toString());
    }

    /**
     * This method will serialize a value {@link Long} in the json
     *
     * @param value content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeNumber(final Long value) throws IOException {
        jsonGenerator.writeNumber(value);
    }

    /**
     * This method will open a json array object to serialize information
     *
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeStartArray() throws IOException {
        jsonGenerator.writeStartArray();
    }

    /**
     * This method will close array object to serialize information
     *
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeEndArray() throws IOException {
        jsonGenerator.writeEndArray();
    }

    /**
     * This method will close the current object
     *
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeEndObject() throws IOException {
        jsonGenerator.writeEndObject();
    }

    /**
     * This method will serialize any object in the json
     *
     * @param fieldName
     * @param value     content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeObjectField(final Enum<?> fieldName, final Object value) throws IOException {
        jsonGenerator.writeObjectField(fieldName.toString(), value);
    }

    /**
     * This method will serialize any object in the json
     *
     * @param value content that will be serialized
     * @throws IOException default exception that will be thrown if an error occurs during the serialization process
     */
    public void writeObjectField(final Object value) throws IOException {
        jsonGenerator.writeObject(value);
    }

}
