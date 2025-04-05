package com.cvbuilder.back.utils.serializer;

import static com.cvbuilder.back.utils.serializer.Common.YEAR_MONTH_FORMATTER;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;

public class LocalDateYearMonthDeserializer extends JsonDeserializer<LocalDate> {

  @Override
  public LocalDate deserialize(JsonParser parser, DeserializationContext context)
      throws IOException {
    YearMonth yearMonth = YearMonth.parse(parser.getText(), YEAR_MONTH_FORMATTER);
    return yearMonth.atDay(1); // Added first day of the month
  }
}
