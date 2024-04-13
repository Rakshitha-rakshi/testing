package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		WebDriver driveredge=new EdgeDriver();
		WebDriver driverfirefox=new FirefoxDriver();
		driveredge.get("https://www.google.com");
		driveredge.close();
		driverfirefox.get("https://www.google.com");
		driverfirefox.close();
		driverfirefox.manage().window().fullscreen();
	}

}
