package com.ensembl.exontranscript;

import com.ensembl.exontranscript.controllers.ExonTranscriptServiceController;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExonTranscriptApplicationTests {
	@Autowired
	ExonTranscriptServiceController controller;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(controller);
	}

}
