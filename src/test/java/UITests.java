import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class UITests {

    @BeforeAll
    static void beforeAll() {
                    WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false);
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to Windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--disable-in-process-stack-traces");
            options.addArguments("--disable-logging");
            options.addArguments("--log-level=3");
            options.addArguments("--remote-allow-origins=*");

            browser = new ChromeDriver(options);

        /*
        WebDriverManager.chromedriver().setup();
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";*/
        // Configuration.browserSize = "1920x1080";
    }

    @Test
    void gitHubTest(){
        open("/");
        sleep(2000);
     //   $(byText("HeaderMenu-link")).shouldHave(exactText("Solutions"));
       /*$("#column-b").dragAndDropTo("#column-a");

        $("#column-b").hover();
        actions().clickAndHold().moveByOffset(-200, 0).release().perform();
        $("#column-a").shouldHave(exactText("B"));*/
    }

    @Test
    void drugAndDrop1Test(){

    }

    @Test
    void drugAndDrop2Test(){

    }

    static WebDriver browser;




    @Test
    @DisplayName("The google.com web site should have the correct title")
    void testProjectWebSiteShouldHaveCorrectTitle() {
        browser.get("https://google.com/");
        Assertions.assertEquals("Google", browser.getTitle());
    }
}

