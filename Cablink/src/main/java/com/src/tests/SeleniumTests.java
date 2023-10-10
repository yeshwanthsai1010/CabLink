package com.src.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTests {

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/Cablink/");
		driver.findElement(By.id("start")).click();
		driver.findElement(By.id("passenger")).click();
		driver.findElement(By.id("registercl")).click();
		driver.findElement(By.id("name")).sendKeys("Yeshwanth Sai");
		driver.findElement(By.id("uname")).sendKeys("Yesh262003");
		driver.findElement(By.id("upwd")).sendKeys("nanisai2003");
		driver.findElement(By.id("umob")).sendKeys("9299292");
		driver.findElement(By.id("uemail")).sendKeys("nanisai2003@gmail.com");
		driver.findElement(By.id("uaddress")).sendKeys("Home");
		driver.findElement(By.id("Male")).click();
		driver.findElement(By.id("reset")).click();
		driver.findElement(By.id("name")).sendKeys("Yeshwanth Sai");
		driver.findElement(By.id("uname")).sendKeys("Yesh262003");
		driver.findElement(By.id("upwd")).sendKeys("nanisai2003");
		driver.findElement(By.id("umob")).sendKeys("9299292");
		driver.findElement(By.id("uemail")).sendKeys("nanisai2003@gmail.com");
		driver.findElement(By.id("uaddress")).sendKeys("Home");
		driver.findElement(By.id("Male")).click();
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("serv")).click();
		driver.findElement(By.id("delete")).click();
	}
}
