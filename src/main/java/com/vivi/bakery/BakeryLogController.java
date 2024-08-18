package com.vivi.bakery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/logs")
public class BakeryLogController {

    @GetMapping("/viviBakery")
    public String getLogFile() throws IOException {
        // Path to the log file
        String logFilePath = "/home/dotnet/Downloads/bakery/logs/viviBakery.log";
        return new String(Files.readAllBytes(Paths.get(logFilePath)));
    }
}