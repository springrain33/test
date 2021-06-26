package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class HomeWork {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = openBrowser("chrome");
        //隐式等待
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //窗口最大化
        driver.manage().window().maximize();
        //前程贷后台登录页面
        driver.get("http://8.129.91.152:8765//Admin/Index/login.html");
        //后台登录
        driver.findElement(By.name("admin_name")).sendKeys("lemon7");
        driver.findElement(By.name("admin_pwd")).sendKeys("lemonbest");
        driver.findElement(By.name("code")).sendKeys("hapi");
        driver.findElement(By.xpath("//button[text()='登陆后台']")).click();
        //借款管理
        driver.findElement(By.xpath("//span[text()='借款管理']")).click();
        //加标
        driver.switchTo().frame("mainFrame");
        driver.findElement(By.xpath("//span[text()='加标']")).click();
        driver.findElement(By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]")).sendKeys("13323234444");
        //按下方向键
        driver.findElement(By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]")).sendKeys(Keys.ARROW_DOWN);
        //按Entry键
        driver.findElement(By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]")).sendKeys(Keys.ENTER);
        //录入其他必要信息
        driver.findElement(By.xpath("//td[text()='贷款标题:']/following-sibling::td/input")).sendKeys("借款买房");
        driver.findElement(By.xpath("//td[text()='年利率利息:']/following-sibling::td/input")).sendKeys("10");
        driver.findElement(By.xpath("//td[text()='借款期限:']/following-sibling::td/input")).sendKeys("12");
        driver.findElement(By.xpath("//td[text()='借款额度:']/following-sibling::td/input")).sendKeys("200000");
        driver.findElement(By.xpath("//td[text()='竞标期限:']/following-sibling::td/input")).sendKeys("5");
        driver.findElement(By.xpath("//span[text()='风控评测']")).click();
        driver.findElement(By.xpath("//td[text()='评估价值:']/following-sibling::td/input")).sendKeys("400000");
        driver.findElement(By.xpath("//span[text()='项目录入']")).click();
        driver.findElement(By.xpath("//td[text()='籍贯:']/following-sibling::td/input")).sendKeys("安徽");
        driver.findElement(By.xpath("//td[text()='职业:']/following-sibling::td/input")).sendKeys("测试工程师");
        driver.findElement(By.xpath("//td[text()='年龄:']/following-sibling::td/input")).sendKeys("30");
        driver.findElement(By.xpath("//span[text()='提交']")).click();
        //审核
        for(int i=0;i<3;i++){
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='借款买房']")).click();
            driver.findElement(By.xpath("//span[text()='审核']")).click();
            driver.findElement(By.xpath("//span[text()='审核通过']")).click();
        }

    }

    public static WebDriver openBrowser(String browserName){
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
