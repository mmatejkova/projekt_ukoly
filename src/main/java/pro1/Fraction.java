package pro1;

import java.util.regex.Pattern;

public class Fraction extends Number {
    private long n;  // čitatel
    private long d;  // jmenovatel

    public Fraction(long n, long d) {
        long gcd = Utils.gcd(d, n);
        this.n = n / gcd;
        this.d = d / gcd;
    }

    public Fraction add(Fraction other) {
        return new Fraction(
                n * other.d + other.n * d,
                d * other.d);
    }

    public static Fraction parse(String s) {
        s = s.replace(" ", "");
        String[] split = s.split(Pattern.quote("+"));
        Fraction sum = new Fraction(0, 1);
        for (String part : split) {
            Fraction partFraction;
            if (part.contains("%")) {
                partFraction = new Fraction(
                        Long.parseLong(part.replace("%", "")),
                        100);
            } else {
                String[] split2 = part.split("/");
                partFraction = new Fraction(
                        Long.parseLong(split2[0]),
                        Long.parseLong(split2[1]));
            }
            sum = sum.add(partFraction);
        }
        return sum;
    }

    public String toString() {
        return n + "/" + d;
    }

    @Override
    public int intValue() {
        return (int) (n / d);
    }

    @Override
    public long longValue() {
        return n / d;
    }

    @Override
    public float floatValue() {
        return (float) n / (float) d;
    }

    @Override
    public double doubleValue() {
        return (double) n / (double) d;
    }
}
