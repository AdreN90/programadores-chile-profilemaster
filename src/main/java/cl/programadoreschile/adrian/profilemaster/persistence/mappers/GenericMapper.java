package cl.programadoreschile.adrian.profilemaster.persistence.mappers;

import cl.programadoreschile.adrian.profilemaster.error.APIException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GenericMapper {

    public static <T> T transformObject(Object obj, Class<T> clazz) {
        return objectMapperProcessor(objectMapper -> {
            try {
                return objectMapper.readValue(toJsonString(obj), clazz);
            } catch (IOException e) {
                throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });
    }

    public static <T> T fromJsonString(String json, TypeReference<T> typeReference) {
        return transformObject(json, typeReference);
    }

    public static <T> T fromJsonString(String json, Class<T> clazz) {
        return transformObject(json, clazz);
    }

    public static Map<String, Object> transformToHasMap(Object json) {
        return transformObject(json, new TypeReference<Map<String, Object>>() {
        });
    }

    public static JsonNode transformToJsonNode(Object json) {
        return transformObject(json, JsonNode.class);
    }

    public static <T> List<T> transformToListOfType(Object obj, Class<T> tClass) {
        return objectMapperProcessor(objectMapper -> {
            try {
                JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, tClass);
                return objectMapper.readValue(toJsonString(obj), type);
            } catch (Exception e) {
                throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });
    }

    public static <T> T transformObject(Object obj, TypeReference<T> typeReference) {
        return objectMapperProcessor(objectMapper -> {
            try {
                return objectMapper.readValue(toJsonString(obj), typeReference);
            } catch (IOException e) {
                throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });
    }

    public static <T> T transformObject(String json, Class<T> clazz) {
        return objectMapperProcessor(objectMapper -> {
            try {
                return objectMapper.readValue(json, clazz);
            } catch (IOException e) {
                throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });
    }

    private static <R> R objectMapperProcessor(Function<ObjectMapper, R> code) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return code.apply(objectMapper);
    }

    public static String toJsonString(Object stringObjectMap) {
        return objectMapperProcessor(objectMapper -> {
            try {
                return objectMapper.writeValueAsString(stringObjectMap);
            } catch (IOException e) {
                throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });
    }

    public static String toJsonString(Map<String, Object> stringObjectMap) {
        return objectMapperProcessor(objectMapper -> {
            try {
                return objectMapper.writeValueAsString(stringObjectMap);
            } catch (JsonProcessingException e) {
                throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        });
    }

}
