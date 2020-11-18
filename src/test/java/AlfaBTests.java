import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBTests {


    @Test
    void fiveArchiveDepositsTest() {

        open("https://alfabank.ru/");
        $("body").shouldHave(text("Обратная связь"));
        $(byText("Вклады")).click();
        //$("href=\"/make-money/\"").click();
        $("body").shouldHave(text("Открыть накопительный счёт"));
        $$("button").findBy(text("Депозиты")).click();
        $("body").shouldHave(text("Вклады"));
        $$("button").findBy(text("Архивные счета и депозиты")).click();
        $("body").shouldHave(text("Архивные счета и депозиты"));
        $$("button").findBy(text("Депозиты")).click();
        $("body").shouldHave(text("Победа+"));
        $("body").shouldHave(text("Потенциал+"));
        $("body").shouldHave(text("Большой куш"));
        $("body").shouldHave(text("Премьер+"));
        $("body").shouldHave(text("Львиная доля"));


        //System.out.println();
    }
}
