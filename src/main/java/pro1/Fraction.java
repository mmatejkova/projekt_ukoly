package pro1;

public class Fraction
{
    //deklarace proměnných ve zlomku
    private int numerator;  //čitatel
    private int denominator;  //jmenovatel

    //konstruktor pro Fraction
    private Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();  //zjednoduší zlomek při vytvoření, pomocí gcd
    }

    //zpracování zadaného řetězce
    public static Fraction parse(String input) throws IllegalArgumentException //přijímá řetězec
    {
        String[] parts = input.split("\\+"); //rozdělí řetězec na části = parts (k sčítání zlomků)
        if (parts.length > 1)
        {
            //spočítá součet zlomků
            Fraction fraction1 = parseFraction(parts[0].trim());
            Fraction fraction2 = parseFraction(parts[1].trim());
            return addFractions(fraction1, fraction2);
        }
        else
        {
            //pokud napíšu jeden zlomek
            return parseFraction(input);
        }
    }

    //zpracování samotného zlomku
    private static Fraction parseFraction(String input)
    {
        String[] parts = input.split("/");
        if (parts.length == 2)
        {
            try
            {
                int numerator = Integer.parseInt(parts[0].trim());
                int denominator = Integer.parseInt(parts[1].trim());
                if (denominator == 0) {
                    throw new IllegalArgumentException("Dělitel nemůže být nula.");
                }
                return new Fraction(numerator, denominator);
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException("Neplatný formát zlomku.");
            }
        }
        else
        {
            throw new IllegalArgumentException("Neplatný formát zlomku.");
        }
    }

    //součet 2 zlomků
    private static Fraction addFractions(Fraction f1, Fraction f2)
    {
        // vzorec pro součet zlomků: (a/b) + (c/d) = (a * d + b * c) / (b * d)
        int numerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int denominator = f1.denominator * f2.denominator;
        return new Fraction(numerator, denominator);
    }

    //zjednodušení zlomku pomocí GCD (aby to nepsalo např. 9/18 ale 1/2)
    private void simplify()
    {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }

    //metoda pro výpočet GCD
    private static int gcd(int a, int b)
    {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //napíše výsledek jako String
    @Override
    public String toString()
    {
        return numerator + "/" + denominator;
    }
}
