import java.util.List;
import java.util.ArrayList;

public class RegexDirector {
    private RegexBuilder builder;

    public void setBuilder(RegexBuilder builder) {
        this.builder = builder;
    }

    public Regex construct() {
        builder.buildLiteral("Hello");
        builder.buildWhitespace();
        builder.buildWordCharacter();
        builder.buildAnyCharacter();
        return builder.getResult();
    }

    public static void main(String[] args) {
        RegexDirector director = new RegexDirector();
        RegexBuilder builder = new ConcreteRegexBuilder();

        director.setBuilder(builder);
        Regex regex = director.construct();

        System.out.println(regex);
    }
}