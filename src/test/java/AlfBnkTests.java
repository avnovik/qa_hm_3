import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class AlfBnkTests {
    String link = "https://alfabank.ru/";
    @Test
    void fiveArchiveDepositsTest() {
//На страничке "Вклады" (https://alfabank.ru/make-money/) перейти на подстраничку "Депозиты" (https://alfabank.ru/make-money/deposits/)
//- Перейти по линку на "Архивные депозиты" (https://alfabank.ru/make-money/archive/)
//- Убедиться, что представлено ровно пять архивных депозитов
        open(link);
        $("body").shouldHave(text("Обратная связь"));
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Открыть накопительный счёт"));
        $$("button").findBy(text("Депозиты")).click();
        $("body").shouldHave(text("Вклады"));
        $$("button").findBy(text("Архивные счета и депозиты")).click();
        $("body").shouldHave(text("Архивные счета и депозиты"));
        $$("button").findBy(text("Депозиты")).click();
        //поименная проверка
        $("body").shouldHave(text("Победа+"));
        $("body").shouldHave(text("Потенциал+"));
        $("body").shouldHave(text("Большой куш"));
        $("body").shouldHave(text("Премьер+"));
        $("body").shouldHave(text("Львиная доля"));
        //колличественная проверка
        $$("div[data-widget-name='CatalogCard']").shouldHave(size(5));
    }

//Запрограммируйте тест переход на страницу Вклады->Страхование вкладов,
//используя для поиска sibling(), preceding(), parent(), closest()
// sibling - поиск последователей
// preceding() - поиск предшественников
// parent() - поиск родителей
// closest() - поиск ближайших
    @Test
    void jumpBySiblingTest() {
        open(link);
        $("body").shouldHave(text("Обратная связь"));
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Открыть накопительный счёт"));
        $("[data-test-id=\"tabs-list-tabTitle-0\"]").sibling(0).click();
        $("[data-widget-uid=\"c755ade9e2\"]").shouldBe(visible);
    }

    @Test
    void jumpByPrecedingTest() {
        open(link);
        $("body").shouldHave(text("Обратная связь"));
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Открыть накопительный счёт"));
        $("[data-test-id=\"tabs-list-tabTitle-2\"]").preceding(0).click();
        $("[data-widget-uid=\"c755ade9e2\"]").shouldBe(visible);
    }

    @Test
    void jumpByParentPrecedingTest() {
        open(link);
        $("body").shouldHave(text("Обратная связь"));
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Открыть накопительный счёт"));
        $("[data-widget-name=\"Grid\"]")
                .parent()
                .parent()
                .parent()
                .scrollIntoView(true)
                .$("[data-test-id=\"tabs-list-tabTitle-2\"]")
                .preceding(0)
                .click();
        $("[data-widget-uid=\"c755ade9e2\"]").shouldBe(visible);
    }

    @Test
    void jumpByClosestSiblingTest() {
        open(link);
        $("body").shouldHave(text("Обратная связь"));
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Открыть накопительный счёт"));
        $("[data-widget-uid=\"4f7475127d\"]")
                .closest(".b19SOu0")
                .scrollIntoView(true)
                .$("button")
                .sibling(0)
                .click();
        $("[data-widget-uid=\"c755ade9e2\"]").shouldBe(visible);
    }
}
