class Publication {

    private final String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        return getType() + getDetails() + title;
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return ": ";
    }

}

class Newspaper extends Publication {

    private final String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    // write your code here
    @Override
    public String getType() {
        return "Newspaper ";
    }

    @Override
    public String getDetails() {
        return String.format("(source - %s): ", source);
    }
}

class Article extends Publication {

    private final String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    // write your code here
    @Override
    public String getType() {
        return "Article ";
    }

    @Override
    public String getDetails() {
        return String.format("(author - %s): ", author);
    }
}

class Announcement extends Publication {

    private final int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    // write your code here
    @Override
    public String getType() {
        return "Announcement ";
    }

    @Override
    public String getDetails() {
        return String.format("(days to expire - %d): ", daysToExpire);
    }
}
// -------------
class BaseNumberGenerator {

    protected int base;

    public BaseNumberGenerator(int base) {
        this.base = base;
    }

    public int generate() {
        return base + 11;
    }
}

class NumberGenerator extends BaseNumberGenerator {

    public NumberGenerator(int base) {
        super(base);
    }

    @Override
    public int generate() {
        return super.generate() + getNumber();
    }

    protected int getNumber() {
        return this.base - 7;
    }
}

class MagicNumberGenerator extends NumberGenerator {

    public MagicNumberGenerator(int base) {
        super(base);
    }

    @Override
    protected int getNumber() {
        return this.base + 7;
    }
}

class Main {
    public static void main(String[] args) {
        Long val = Long.valueOf("4321");
    }
}