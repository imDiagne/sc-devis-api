package com.devis.service.date;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.spi.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;



/**
 * Custom class to deserialize the LocalDateTime to the View
 *
 */
public class CustomLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	// protected static final org.slf4j.Logger LOGGER = LoggerFactory.class.getClassLoader().

	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommercialServiceApiConstants.PATTERN_DATE_TIME);
		// gen.writeString(formatter.format(value));
	}
	
}

