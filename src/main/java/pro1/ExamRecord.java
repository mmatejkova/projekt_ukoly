package pro1;

public class ExamRecord {
    private String name;  // jméno studenta
    private Fraction score;  // skóre studenta (zlomek)

    public ExamRecord(String name, Fraction score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Fraction getScore() {
        return score;
    }
}
