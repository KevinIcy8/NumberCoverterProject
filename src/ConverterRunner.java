import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while(!NumberConverter.validBase(choice)){
            System.out.print("You entered an invalid base number! Please enter an integer for you base: ");
            choice = s.nextLine();
            NumberConverter.validBase(choice);
        }
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        while(!(NumberConverter.validNumber(number,choice))){
            System.out.println("You entered an invalid number");
        }
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        if(base == 10){
            System.out.println("\nBinary Number: " + nc.displayNormalNumber(nc.convertToBinary()));
            System.out.println("Octal Number: " + nc.displayNormalNumber(nc.convertToOctal()));
        }
        else if(base == 2){
            System.out.println("\nDecimal Number: " + nc.displayNormalNumber(nc.convertToDecimal()));
            System.out.println("Octal Number: " + nc.displayNormalNumber(nc.convertToOctal()));
        }
        else if(base == 8){
            System.out.println("\nBinary Number: " + nc.displayNormalNumber(nc.convertToBinary()));
            System.out.println("Decimal Number: " + nc.displayNormalNumber(nc.convertToDecimal()));
        }
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
    }
}

