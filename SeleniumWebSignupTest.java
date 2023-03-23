import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //import Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        //locate where the edgedriver is
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver");
        //1.open your Edge browser
        driver = new EdgeDriver();
        //2.Input your selenium Demo Page URL(https://selenium-blog.herokuapp.com);
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1 verify the user input the right url and he is on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("correct webpage");
        else
            //Fail
        System.out.println("wrong webpage");

        Thread.sleep(5000);
        //3.Maximise the browser
        driver.manage().window().maximize();
        //4.click on signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
        @Test (priority = 0)
        public void positiveSignup() throws InterruptedException{
        //Test7. Verify user can signup with valid username and details
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Sarah59");
        Thread.sleep(5000);
        //6.Input email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("Sarahhh59@mailinator.com");
        Thread.sleep(5000);
        //7.Locate the password field and input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Sarah");
        Thread.sleep(5000);
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

        @Test (priority = 1)
        public void meaghanItem() throws InterruptedException {
        //9.Click on the meaghan item on the listpage
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            //Test2. Verify that user is directed to the Meaghan User page when click the Meaghan item
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/user/1";
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.contains(expectedPageUrl))
                //pass
                System.out.println("Correct webpage");
            else
                //Fail
                System.out.println("Wrong webpage");
            Thread.sleep(5000);

        }
        @Test  (priority = 2)
       public void verifyitem() throws InterruptedException {
            //10.search for an item(Using python with selenium) and confirm is present
            //Test9
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/a[1]")).click();
            String expectedPageUrl = "Alhablog";
            String actualPageUrl = driver.getCurrentUrl();
            if (actualPageUrl.contains(expectedPageUrl))
                //pass
                System.out.println("page contains Item");
            else
                //Fail
                System.out.println("page does not contains item");
            Thread.sleep(5000);


        }
        @Test (priority = 3)
        public void logoutSuccessfully(){
        //11.Click on Logout
        driver.close();
    }

    @AfterTest
    public void closeBrowser() {
        //12.Quit the browser
        driver.quit();
    }


}


