package com.stoi.fightcluckservice;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
public class FightcluckserviceApplication {
    private static final Logger log = LoggerFactory.getLogger(FightcluckserviceApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(FightcluckserviceApplication.class, args);

        SpringApplication app = new SpringApplication(FightcluckserviceApplication.class);
        Environment env = app.run(args).getEnvironment();

        startupLog(env);
    }

    private static void startupLog(Environment env) {
        String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store")).map(key -> "https").orElse("http");
        String serverPort = env.getProperty("server.port");
        String contextPath = Optional
                .ofNullable(env.getProperty("server.servlet.context-path"))
                .filter(StringUtils::isNotBlank)
                .orElse("/");
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        String dsUrl = env.getProperty("spring.datasource.url");
        String dsUsername = env.getProperty("spring.datasource.username");
        String eurekaDefaultZone = env.getProperty("eureka.client.service-url.defaultZone");


        log.info(
                "\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running!:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Swagger: \t{}://localhost:{}{}swagger-ui/index.html\n\t" +
                        "DS Url: \t{}\n\t" +
                        "DS Username: \t{}\n\t" +
                        "Eureka: \t{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                protocol,
                serverPort,
                contextPath,
                dsUrl,
                dsUsername,
                eurekaDefaultZone,
                env.getActiveProfiles()
        );
    }
}
