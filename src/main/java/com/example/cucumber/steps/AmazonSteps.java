package com.example.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AmazonSteps {
    public static WebDriver driver; //= new ChromeDriver();
   public AmazonSteps(){
       System.setProperty("webdriver.chrome.driver","C:/Users/10/Programs/Webdriver/chromedriver.exe");
       driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   }

    @Given("amazon login page is open")
    public void amazon_login_page_is_open() throws Exception {

       driver.get("https://www.amazon.in");
       driver.manage().window().maximize();
       String actual=driver.getTitle();
       if(actual.contains("Online")){
           System.out.println("In amazon login page");
           System.out.println("aactual title = "+actual);
           Assert.assertTrue(true);}

       else{
           Assert.fail();
           }
       }



    @Given("enter username {string} and password {string}")
    public void enter_username_and_password(String username, String password) throws Exception{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),\"Gift\")]")).click();
        driver.findElement(By.xpath("//a[@class=\"hmenu-item\" and contains(text(),\"All Gift\")]")).click();
        System.out.println("enter username:- "+ username +" and password :- "+ password);
    }
    @Then("click on login")
    public void click_on_login() {
        System.out.println("logged in"); 
        driver.quit();
    }


}
