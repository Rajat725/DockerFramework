package com.qa.utils;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class TestResourceLoader {

    private static final Logger log = LoggerFactory.getLogger(TestResourceLoader.class);

    @SneakyThrows
    public static InputStream getResource(String path){
        log.info("reading resource from location: {}", path);
        //InputStream stream =  ResourceLoader.class.getClassLoader().getResourceAsStream(path);
        final InputStream stream = TestResourceLoader.class.getClassLoader().getResourceAsStream(path);
        if (Objects.nonNull(stream)) {
            log.info("Class Path");
            return stream;
        }
        log.info("Project Path");
        return Files.newInputStream(Path.of(path));
    }

}
