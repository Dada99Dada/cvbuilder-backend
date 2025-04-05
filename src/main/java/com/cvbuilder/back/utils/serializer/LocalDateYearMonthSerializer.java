package com.cvbuilder.back.utils.serializer;

import static com.cvbuilder.back.utils.serializer.Common.YEAR_MONTH_FORMATTER;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDate;

public class LocalDateYearMonthSerializer extends JsonSerializer<LocalDate> {

  @Override
  public void serialize(LocalDate date, JsonGenerator generator, SerializerProvider serializer)
      throws IOException {
    generator.writeString(date.format(YEAR_MONTH_FORMATTER));
  }
}
