package com.capitole.harryarbol;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HarryArbolApplicationTests {
    @InjectMocks
    @Spy
    private HarryArbolApplication app;

	@Test
	void contextLoads() {
		HarryArbolApplication.main(new String[] {});
        assertTrue(true);
	}

}
