import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class UITests {

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        // Configuration.browserSize = "1920x1080";
    }

    @Test
    void gitHubTest() {
        open("/");

        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".h1-mktg").shouldHave(Condition.exactText("Build like the best"));
    }


    @Test
    void drugAndDropToTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(1000);
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        sleep(1000);
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));
    }

    @Test
    void drugAndDropActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(1000);
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));
        sleep(1000);
    }

}

