package com.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FreeCodeCamp {

    public String generateSyllabus(WebDriver driver, String courseName){

        WebElement courseElement = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(courseName)));
        courseElement.findElements(By.xpath("*")).get(0).click();

        captureTopics(courseElement.findElements(By.tagName("li")));

        return "Syllabus Generated Successfully";
    }

    public void captureTopics( List<WebElement> contentElement){
        for(int i = 0 ; i < contentElement.size(); i++){
            System.out.println(i+1 + " " + contentElement.get(i).getText().split("\n")[0]);
            System.out.println("------------------------------------------------");
            contentElement.get(i).findElements(By.xpath("*")).get(0).click();
            captureSubTopic(contentElement.get(i).findElements(By.tagName("li")));
        }
    }

    public void captureSubTopic(List<WebElement> topicElement){
        for(int j = 1 ; j < topicElement.size(); j++){
            System.out.println(j + " " + topicElement.get(j).getText().split("\n")[2]);
        }
    }
}
