package com.examly.springapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainClass {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Assuming you have ChromeDriver installed and added to your system PATH
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testDragAndDrop() {
        // Navigate to the webpage
        driver.get("http://jqueryui.com/droppable/");

        // Switch to the iframe containing the draggable and droppable elements
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        // Locate the source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Get the initial color of the target element
        String initialColor = targetElement.getCssValue("color");

        // Get the initial text of the target element
        String initialText = targetElement.getText();

        // Perform drag and drop operation using Actions class
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        // Get the color of the target element after the drag and drop operation
        String updatedColor = targetElement.getCssValue("color");

        // Get the text of the target element after the drag and drop operation
        String updatedText = targetElement.getText();

        // Verify the color has changed and the text has updated
        Assert.assertNotEquals(initialColor, updatedColor, "Color of the target element is not changed.");
        Assert.assertNotEquals(initialText, updatedText, "Text of the target element is not changed.");

        // Additional assertion (You can modify this based on your specific case)
        Assert.assertEquals(updatedColor, "rgba(0, 0, 255, 1)", "Color is not as expected.");
        Assert.assertEquals(updatedText, "Dropped!", "Text is not as expected.");
    }
}
