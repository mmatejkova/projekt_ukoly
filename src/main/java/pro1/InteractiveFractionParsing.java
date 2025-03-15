package pro1;

import java.util.Scanner;

public class InteractiveFractionParsing
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Zadejte zlomek: ");
            String input = scanner.nextLine();

            try
            {
                Fraction fraction = Fraction.parse(input);
                System.out.println("Zadal jste zlomek " + fraction);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Zadal jste neplatný řetězec " + input);
            }
        }
    }
}
