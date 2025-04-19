package com.cvbuilder.back.utils;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtils {

  public static void convertInPdf(String htmlContent, ByteArrayOutputStream outputStream)
      throws IOException {
    PdfRendererBuilder builder = new PdfRendererBuilder();
    builder.useFastMode();
    builder.withHtmlContent(htmlContent, null);
    builder.toStream(outputStream);
    builder.run();
  }

  public static String convertToBase64(ByteArrayOutputStream outputStream) {
    byte[] pdfBytes = outputStream.toByteArray();
    return Base64.getEncoder().encodeToString(pdfBytes);
  }

  public static boolean isBase64(String str) {
    return str != null && str.matches("^[A-Za-z0-9+/]*={0,2}$") && str.length() % 4 == 0;
  }
}
