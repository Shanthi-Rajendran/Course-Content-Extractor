package com.api;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.get("https://www.freecodecamp.org/learn");
        FreeCodeCamp course = new FreeCodeCamp();
        Scanner sc = new Scanner(System.in);
        String courseName = sc.nextLine();
        try {
            System.out.println(course.generateSyllabus(driver, courseName));
        }
        catch (TimeoutException ex){
            System.out.println("We are unable to find the course "+ courseName + " in FreecodeCamp \nKindly provide the exact heading of the course");
        }
        driver.close();
    }
}
