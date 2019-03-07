package com.nicholas.phonebook.translator;

import com.nicholas.phonebook.entity.AbstractEntity;
import com.nicholas.phonebook.model.AbstractType;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<T extends AbstractType, E extends AbstractEntity> {
    E convertType(T type);

    T convertEntity(E entity);


    default List<T> convertEntities(final Collection<E> entities) {
        return entities.stream()
                .map(e -> convertEntity(e))
                .collect(Collectors.toList());
    }

    default List<E> convertDtos(final Collection<T> types) {
        return types.stream()
                .map(t -> convertType(t))
                .collect(Collectors.toList());
    }
}
