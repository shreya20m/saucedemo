package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new"); // IMPORTANT
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*"); // FIX crash
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        System.out.println("Login Successful");

        driver.quit();
    }
}
