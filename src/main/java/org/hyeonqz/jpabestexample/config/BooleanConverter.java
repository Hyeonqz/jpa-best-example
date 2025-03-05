package org.hyeonqz.jpabestexample.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    // Boolean -> String 으로 변환한다.
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute == null ? "NO" : "YES";
    }

    // String -> Boolean 으로 변환한다.
    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return !"No".equals(dbData);
    }

}
