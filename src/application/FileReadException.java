package application;

import java.io.IOException;

@SuppressWarnings("serial")
public class FileReadException extends IOException {
    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
