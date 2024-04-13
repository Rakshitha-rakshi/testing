package com.skcet.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		WebDriver driverchrome=new ChromeDriver();
		driverchrome.get("https://www.shoppersstop.com");
		driverchrome.findElement(By.className("user-icon")).click();
		SpringApplication.run(DemoApplication.class, args);
	}
}
