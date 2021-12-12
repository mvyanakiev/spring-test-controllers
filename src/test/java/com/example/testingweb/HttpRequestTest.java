package com.example.testingweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
        (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // avoiding conflicts with local ports
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate; // provided by Spring for tests

    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/", String.class))
                .contains("Hello World");
    }
}
