import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchCodeExample {
    @BeforeAll
    static void setBrowserSize() {
        Configuration.browserSize = "1920x1080";
    }
@Test
    void codeExampleShouldDisplayedTest() {
    //Открыть страницу Selenide в Github
    open("https://github.com/selenide/selenide/");
    //Перейти в раздел Wiki проекта
    $("a[href='/selenide/selenide/wiki']").click();
    //Найти страницу SoftAssertions и открыть ее
    $("#wiki-pages-filter").setValue("SoftAssertions");
    $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
    //Убедиться, что на странице есть пример кода для JUnit5
    $$("h4.heading-element").findBy(text("Using JUnit5 extend test class"))
            .closest(".markdown-heading")
            .sibling(0)
            .$("pre")
            .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                    "class Tests {\n" +
                    "  @Test\n" +
                    "  void test() {\n" +
                    "    Configuration.assertionMode = SOFT;\n" +
                    "    open(\"page.html\");\n" +
                    "\n" +
                    "    $(\"#first\").should(visible).click();\n" +
                    "    $(\"#second\").should(visible).click();\n" +
                    "  }\n" +
                    "}"));
}
}
