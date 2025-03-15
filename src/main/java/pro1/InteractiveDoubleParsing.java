package pro1;

import java.util.Scanner;

public class InteractiveDoubleParsing
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Zadejte číslo: ");
            String input = scanner.nextLine();

            try
            {
                double number = Double.parseDouble(input);
                System.out.println("Zadal jste číslo " + number);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Zadal jste neplatný řetězec " + input);
            }
        }
    }
}
