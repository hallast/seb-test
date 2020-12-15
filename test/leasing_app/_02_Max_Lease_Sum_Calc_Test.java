package leasing_app;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class _02_Max_Lease_Sum_Calc_Test {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    //ToDo: Make expected 'Lease Sum' value dynamic according to calculations logic
    @Test
    public void _01_Max_Lease_Calc_Test1() {
        open("http://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator");
        $(byText("I agree")).click();
        $("#netoIncome").setValue("1800");
        $("#monthlyFinancialObligations").setValue("300");
        $("#numOfDependants").setValue("1");
        $("#leaseSum").shouldBe(visible).shouldHave(text("31 830"));
        $(".-CS-apply-button").click();
        $(".-CS-aplication-button").click();
        switchTo().window(1);
        $("#headermain").shouldBe(visible).shouldHave(text("Sõidukiliising")); // Its a bug. Language parameter is missing from request and user is guided to Estonian language application page
        switchTo().window(0);
        $("#netoIncome").setValue("100");
        $(".-CS-negative-result").shouldBe(visible).shouldHave(text("We cannot provide financing with the entered data. Add a surety, if possible."));
    }
}
