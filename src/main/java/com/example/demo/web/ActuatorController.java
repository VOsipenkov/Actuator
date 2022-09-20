package com.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequiredArgsConstructor
public class ActuatorController {
    private final Environment environment;

    @GetMapping(value = "/host")
    public String getHost() throws Exception {
        var port = environment.getProperty("local.server.port");
        var host = InetAddress.getLocalHost().getHostAddress();
        return "host: " + host + " port:" + port;
    }
}
