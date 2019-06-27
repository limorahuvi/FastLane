package uiTests;

import DBTest.utilitiesDBtest;
import models.entities.Calendar;
import models.initializeDB;
import controllers.HomeController;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class selenuimCheckResponseTimeNew {

    /**
     * check the response time for calculate passengers count visualization(<2 minutes)
     * @throws IOException
     */
    @Test
    public void E2E_5_1() throws IOException {//check response time for passengers count vis
        System.setProperty("webdriver.gecko.driver", "test\\uiTests\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:9000");
        long start = System.currentTimeMillis();
        driver.get("http://localhost:9000/PassengersCount");//PassengersCount vis
        driver.findElement(By.id("coor1")).sendKeys("34.79317589614905,31.277794468518493");
        driver.findElement(By.id("coor2")).sendKeys("34.791974266494094,31.259967260261703");
        driver.findElement(By.id("startDate")).sendKeys("2018-09-29");
        driver.findElement(By.id("endDate")).sendKeys("2018-10-29");
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByValue("Saturday");
        Select start_hour = new Select(driver.findElement(By.id("startHour")));
        start_hour.selectByValue("00");
        Select end_hour = new Select(driver.findElement(By.id("endHour")));
        end_hour.selectByValue("00");
        driver.findElement(By.id("minPassengersForPublicLane")).sendKeys("20");
        driver.findElement(By.xpath("//input[@value='Calculate' and @type='submit']")).click();
        long finish = System.currentTimeMillis();
        long totalTime = ((finish - start) / 1000) / 60;//minutes
        assertTrue(totalTime < 2);
    }

    /**
     * check the response time for calculate real time visualization(<2 minutes)
     * @throws IOException
     */
    @Test
    public void E2E_5_2() throws IOException {//check response time for real time vis
        System.setProperty("webdriver.gecko.driver", "test\\uiTests\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:9000");
        long start=System.currentTimeMillis();
        driver.get("http://localhost:9000/DevSched");//DevSched vis
        driver.findElement(By.id("coor1")).sendKeys("34.81636627528721,31.27027517208913");
        driver.findElement(By.id("coor2")).sendKeys("34.7771416506549,31.24855754703961");
        driver.findElement(By.id("startDate")).sendKeys("2018-09-29");
        driver.findElement(By.id("endDate")).sendKeys("2018-10-29");
        Select day1=new Select(driver.findElement(By.id("day")));
        day1.selectByValue("Saturday");
        Select start_hour1=new Select(driver.findElement(By.id("startHour")));
        start_hour1.selectByValue("00");
        Select end_hour1=new Select(driver.findElement(By.id("endHour")));
        end_hour1.selectByValue("00");
        driver.findElement(By.xpath("//input[@value='Calculate' and @type='submit']")).click();
        long finish=System.currentTimeMillis();
        long totalTime=((finish-start)/1000)/60;//minutes
        assertTrue(totalTime < 2);
    }
}
