package leasing_app;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LeasingTest {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);


    @Test
    public void _01_leasing_application_navigation_test() {
        open("http://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator");
        $(byText("I agree")).click();
        $(".big").shouldBe(visible).shouldHave(text("Car leasing"));
        $(byText("Submit an application on the website of SEB")).click();
        switchTo().window(1);
        $("#headermain").shouldBe(visible).shouldHave(text("Leasing, vehicle"));
    }

    @Test
    public void _02_leasing_application_page_1_test() {
        open("https://e.seb.ee/ip/ipank.p?act=CRMCONTACT&topic_code=t_lseauto&pt=unknown&lang=ENG");
        $("#headermain").shouldBe(visible).shouldHave(text("Leasing, vehicle"));
        $(byName("firstname")).setValue("test");
        $(byName("lastname")).setValue("test");
        $(byName("id_code")).setValue("38304202733");
        $(byName("-998_DELIMITER_crmContactTopic_T_LSEAUTO_000")).selectOption("Passanger car");
        $(byName("-997_DELIMITER_crmContactTopic_T_LSEAUTO_000")).selectOption("BMW");
        $(byName("-996_DELIMITER_crmContactTopic_T_LSEAUTO_000")).selectOption("X5");
        $(byName("-994_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("2016");
        $(byName("-991_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("120");
        $(byName("-983_DELIMITER_crmContactTopic_T_LSEAUTO_000")).selectOption("Financial lease");
        $(byName("-982_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("25000");
        $(byName("-981_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("20");
        $(byName("-977_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("48");
        $(byName("-970_DELIMITER_crmContactTopic_T_LSEAUTO_000")).selectOption("Tartu");
        $(byName("-969_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("test@test.ee");
        $(byName("-968_DELIMITER_crmContactTopic_T_LSEAUTO_000")).selectOption("No");
        $(byName("-1003_DELIMITER_crmContactTopic_T_LSEAUTO_000")).selectOption("Other seller - person");
        $(byName("-958_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("Test Seller");
        $(byName("-957_DELIMITER_crmContactTopic_T_LSEAUTO_000")).setValue("55555555");
        $(byText("Next")).click();
        $(byTagName("h2")).shouldBe(visible).shouldHave(text("Data of applicant"));
    }
}