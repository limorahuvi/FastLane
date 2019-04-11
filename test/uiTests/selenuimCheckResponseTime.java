package uiTests;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Date;

public class selenuimCheckResponseTime {//E2E-5
    public static void main(String[]args){

        System.setProperty("webdriver.gecko.driver","test\\uiTests\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.get("http://localhost:9000");
        long start=System.currentTimeMillis();
        driver.get("http://localhost:9000/PassengersCount");//PassengersCount vis
        driver.findElement(By.id("coor1")).sendKeys("34.79317589614905,31.277794468518493");
        driver.findElement(By.id("coor2")).sendKeys("34.791974266494094,31.259967260261703");
        driver.findElement(By.id("startDate")).sendKeys("2019-10-04");
        driver.findElement(By.id("endDate")).sendKeys("2019-10-05");
        Select day=new Select(driver.findElement(By.id("day")));
        day.selectByValue("Monday");
        Select start_hour=new Select(driver.findElement(By.id("startHour")));
        start_hour.selectByValue("09");
        Select end_hour=new Select(driver.findElement(By.id("endHour")));
        end_hour.selectByValue("19");
        driver.findElement(By.id("minPassengersForPublicLane")).sendKeys("20");
        driver.findElement(By.xpath("//input[@value='Calculate' and @type='submit']")).click();
        long finish=System.currentTimeMillis();
        long totalTime=(finish-start)/1000;
        System.out.println("time in seconds for PassengersCount vis :"+totalTime);


        start=System.currentTimeMillis();
        driver.get("http://localhost:9000/DevSched");//DevSched vis
        driver.findElement(By.id("coor1")).sendKeys("34.79317589614905,31.277794468518493");
        driver.findElement(By.id("coor2")).sendKeys("34.791974266494094,31.259967260261703");
        driver.findElement(By.id("startDate")).sendKeys("2019-10-04");
        driver.findElement(By.id("endDate")).sendKeys("2019-10-05");
        Select day1=new Select(driver.findElement(By.id("day")));
        day1.selectByValue("Monday");
        Select start_hour1=new Select(driver.findElement(By.id("startHour")));
        start_hour1.selectByValue("09");
        Select end_hour1=new Select(driver.findElement(By.id("endHour")));
        end_hour1.selectByValue("19");
        driver.findElement(By.xpath("//input[@value='Calculate' and @type='submit']")).click();
        finish=System.currentTimeMillis();
        totalTime=(finish-start)/1000;
        System.out.println("time in seconds for DevSched vis :"+totalTime);
    }
}