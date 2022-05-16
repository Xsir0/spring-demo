package com.example.demo.source;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class LoadSource {

    public Object uri() throws IOException {
        try {
            URI uri = new URI("classpath:application.properties");
            uri.getPath();
            return new String(uri.getPath().getBytes(StandardCharsets.UTF_8), Charset.defaultCharset());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Object classPathResource() throws IOException {
            ClassPathResource classPathResource = new ClassPathResource("application.properties");
            try(InputStream inputStream = classPathResource.getInputStream()){
                byte[] b = new byte[inputStream.available()];
                inputStream.read(b);
                return new String(b, Charset.defaultCharset());
            }
    }

}
