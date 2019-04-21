package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @author Ant
 * @ClassName: AppZipkinServer
 * @Description: AppZipkinServer
 * @datetime 2019/2/21 9:07
 * @Version 1.0
 */
@SpringBootApplication
@EnableZipkinServer
public class AppZipkinServer {
    public static void main(String[] args) {
        SpringApplication.run(AppZipkinServer.class);
    }
}
