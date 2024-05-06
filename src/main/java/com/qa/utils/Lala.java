package com.qa.utils;

import com.qa.utils.ResourceLoader;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Lala {
    private static final Logger log = LoggerFactory.getLogger(Lala.class);

    public static void main(String[] args) throws Exception {
        InputStream resource = ResourceLoader.getResource("/a/dumny.txt");
        String string = IOUtils.toString(resource, StandardCharsets.UTF_8);
        log.info(string);

    }
}