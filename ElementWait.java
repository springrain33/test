package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class ElementWait {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException{
        driver = openBrowser("chrome");
        //设置隐式等待
        //效果：在通过findElement方法找元素的时候，会在规定时间范围内一直不断循环找元素，知道找到元素或者超时为止。
        //全局性设置
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //测试派的登录流程
//        driver.get("https://testingpai.com");
        //1.点击登录
//        driver.findElement(By.id("navLogin")).click();
//        Thread.sleep(2000);
        //2.输入用户名
//        driver.findElement(By.id("nameOrEmail")).sendKeys("lemontester");
        //3.输入密码
//        driver.findElement(By.id("loginPassword")).sendKeys("123456");
        //4.点击登录按钮
//        driver.findElement(By.id("loginBtn")).click();
        //前程贷登录流程
//        driver.get("http://8.129.91.152:8765/");
//        driver.findElement(By.xpath("//a[text()=‘登录’]")).click();
//        driver.findElement(By.name("phone")).sendKeys("13323234545");
//        driver.findElement(By.name("password")).sendKeys("123456");
//        driver.findElement(By.xpath("//button[text()='登录']")).click();
        driver.get("https://www.baidu.com");
        //点击设置
        driver.findElement(By.id("s-usersetting-top"));
        WebDriverWait webDriverWait = new WebDriverWait(driver,8);
        //until--直到某个条件满足为止
        //visibilityofElementLocated-->等待元素可见
        //elementToBeClickable-->等待元素可被点击
        //presenceOfElementLocated-->等待元素存在
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='高级搜索']")));
        webElement.click();

        //项目中用的比较多的等待的方式
        //1.隐式等待+Thread.sleep
        //2.显示等待+Thread.sleep

        //隐式等待 VS 显式等待
        //1.作用域范围：隐式：全局性 显式：针对当前某个元素
        //2.超时异常区别：隐式：NoSuchElementException 显式：TimeOutException
        //3.等待的条件的区别：隐式：只能等待元素存在 显式：很多丰富的条件，等待元素存在，等待元素可见，等待元素可被点击等等。
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
