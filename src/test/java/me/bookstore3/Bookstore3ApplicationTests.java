package me.bookstore3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.bookstore3.services.HealthcheckService;

@SpringBootTest
class Bookstore3ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    HealthcheckService healthcheckService;

    @DisplayName("Test Healthcheck Message")
    @Test
    void testGet() {
        assertEquals("ok", healthcheckService.getMessage());
    }
}
