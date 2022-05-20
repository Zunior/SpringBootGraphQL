package com.Swagg.demo.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		return Optional.ofNullable(localDateTime).map(Timestamp::valueOf).orElse(null);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
		return timestamp == null ? null : LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));
	}

}
