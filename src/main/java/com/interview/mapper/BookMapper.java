package com.interview.mapper;

import com.interview.model.BookDto;
import com.interview.persistence.entity.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * This class is responsible for mapping between BookDto and Book entities.
 */
@Mapper(uses = SentenceMapper.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring")
public abstract class BookMapper {


    /**
     * Converts a BookDto object to a Book entity.
     *
     * @param dto The BookDto object to be converted
     * @return The converted Book entity
     */
    public abstract Book dtoToEntity(BookDto dto);


}
