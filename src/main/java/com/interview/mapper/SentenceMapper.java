package com.interview.mapper;

import com.interview.model.SentenceDto;
import com.interview.persistence.entity.Sentence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * This class maps between Sentence and SentenceDto objects.
 */
@Mapper(componentModel = "spring")
public abstract class SentenceMapper {

    /**
     * Converts a Sentence entity to a SentenceDto object.
     *
     * @param sentence The Sentence entity to be converted.
     * @return The converted SentenceDto object.
     */
    public abstract SentenceDto entityToDto(Sentence sentence);

    /**
     * Converts a SentenceDto object to a Sentence entity, ignoring the 'book' field.
     *
     * @param dto The SentenceDto object to be converted.
     * @return The converted Sentence entity.
     */
    @Mapping(target = "book", ignore = true)
    public abstract Sentence dtoToEntity(SentenceDto dto);

}
