package com.globalTek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = GlobalTekApplication.class)
public class GlobalTekApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalTekApplication.class, args);
	}

}
