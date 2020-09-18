package com.example.agen;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AgenController {
	

		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();

		@GetMapping("/sample")
		public Sample greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
			return new Sample(counter.incrementAndGet(), String.format(template, name));
		}
}
