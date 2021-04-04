package org.example.validation;

import org.example.exceptions.MaxFileSizeException;
import org.example.web.XMLtoJSONServletCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class Validator {
    private final static String MAX_FILE_SIZE_EXCEPTION =
            "File size more then allow size!";
    private static final Logger log = LoggerFactory.getLogger(Validator.class);

    public static void validateFileSize(int maxFileSize, InputStream stream) throws IOException, MaxFileSizeException {
        log.info("file size validation");
        if (stream.available()>maxFileSize) {
            throw new MaxFileSizeException(MAX_FILE_SIZE_EXCEPTION);
        }
    }
}
