package ru.shtyrev.searchservice.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Component
@ReadingConverter
public class LocalDateTimeReadConverter implements Converter<Long, LocalDateTime> {

    @Override
    public LocalDateTime convert(Long longDateTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(longDateTime), ZoneId.of("Z"));
    }
}
