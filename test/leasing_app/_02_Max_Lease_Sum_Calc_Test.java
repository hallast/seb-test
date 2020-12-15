package leasing_app;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class _02_Max_Lease_Sum_Calc_Test {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);


    @Test
    public void _01_max_lease_amount_calc_test1() {
        open("http://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator");
        $("#netoIncome").setValue("1800");
        $("#monthlyFinancialObligations").setValue("300");
        $("#numOfDependants").setValue("1");
        $("#leaseSum").shouldBe(visible).shouldHave(text("31 830"));
        $("#netoIncome").setValue("100");
        $(".-CS-negative-result").shouldBe(visible).shouldHave(text("We cannot provide financing with the entered data. Add a surety, if possible."));

    }
}
