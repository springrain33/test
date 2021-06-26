package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver.Navigation;

public class WebDriverApi {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = openBrowser("chrome");
        driver.get("https://www.baidu.com");
//        System.out.println(driver.getCurrentUrl());//https://www.baidu.com/
//        System.out.println(driver.getTitle());//百度一下，你就知道
//        System.out.println(driver.getPageSource());//当前页面的源代码
        //quit关闭当前的驱动和所有窗口
//        driver.findElement(By.xpath("//a[text()='地图']")).click();
//        Thread.sleep(2000);
//        driver.quit();
        //driver.close();会关掉百度首页的窗口，留下了百度地图

        //导肮操作
        Navigation navigate = driver.navigate();
        navigate.to("https://www.jd.com");
        Thread.sleep(2000);
        //刷新页面操作
        navigate.refresh();
        Thread.sleep(2000);
        //回退操作
        navigate.back();
        Thread.sleep(2000);
        //前进操作
        navigate.forward();

        //window窗口操作
       Window window =  driver.manage().window();
       window.maximize();
       window.fullscreen();
        Point point = window.getPosition();
        System.out.println("x轴的位置"+point.getX());
        System.out.println("y轴的位置"+point.getY());//浏览器左上角的位置

        Dimension dimension = window.getSize();
        System.out.println("窗口宽度"+dimension.getWidth());
        System.out.println("窗口高度"+dimension.getHeight());



    }

    public static WebDriver openBrowser(String browserName){
        //equalsIgnoreCase不区分大小写
        if("chrome".equals(browserName)){
            //执行chrome的代码
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            ChromeDriver chromeDriver = new ChromeDriver();
            return chromeDriver;
        }else if ("firefox".equals(browserName)){
            //执行firefox的代码
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            return firefoxDriver;
        }else{
            System.out.println("浏览器不支持，请确认你的浏览器名是否正确");
            return null;
        }
    }
}
