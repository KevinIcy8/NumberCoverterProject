import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter \"A\" for normal base conversion or Enter \"B\" for decimal --> base 1-64 conversion: ");
        String option = s.nextLine();
        option = option.toUpperCase();
        if(option.equals("B")){
            System.out.print("Enter a decimal number: ");
            String num = s.nextLine();
            System.out.print("What base would you like to convert it to(1-64): ");
            String b = s.nextLine();
            NumberConverter ac = new NumberConverter(Integer.parseInt(num),Integer.parseInt(b));
            String converted = ac.displayNormalNumber2(ac.convertToAny());
            System.out.print("Decimal --> Base " + b + ": " + converted);
        }
        else{
        System.out.print("Enter the base of your number (2, 8, 10, or 16(Hexadecimal)): ");

        String choice = s.nextLine();
        while(!NumberConverter.validBase(choice)){
            System.out.print("You entered an invalid base number! Please enter an integer for you base: ");
            choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        if(base != 16) {
            while (!(NumberConverter.validNumber(number, base))) {
                System.out.print("You entered an invalid number! Please enter a valid number corresponding to the base: ");
                number = s.nextLine();
            }
        }
        else{
            while (!(NumberConverter.validNumberHex(number))) {
                System.out.print("You entered an invalid number! Please enter a valid number corresponding to the base: ");
                number = s.nextLine();
            }
        }

        int n = 0;
        String l = "";
        if(base != 16){
            n = Integer.parseInt(number);
        }
        else{
            l = number;
        }

        s.close();
        NumberConverter nc = new NumberConverter(10, 8);
        NumberConverter lc = new NumberConverter("2A", 10);
        if(base!= 16) {
            nc = new NumberConverter(n, base);
        }
        else{
            lc = new NumberConverter(l, base);
        }
        if(base == 10){
            System.out.println("\nBinary Number: " + nc.displayNormalNumber(nc.convertToBinary(String.valueOf(n))));
            System.out.println("Octal Number: " + nc.displayNormalNumber(nc.convertToOctal(String.valueOf(n))));
            System.out.println("Hexadecimal Number: " + nc.displayNormalNumber2(nc.convertToHex(String.valueOf(n))));
        }
        else if(base == 2){
            System.out.println("\nDecimal Number: " + nc.displayNormalNumber(nc.convertToDecimal()));
            String decimal = nc.displayNormalNumber(nc.convertToDecimal());
            System.out.println("Octal Number: " + nc.displayNormalNumber(nc.convertToOctal(decimal)));
            System.out.println("Hexadecimal Number: " + nc.displayNormalNumber2(nc.convertToHex(decimal)));
        }
        else if(base == 8){
            String decimal = nc.displayNormalNumber(nc.convertToDecimal());
            System.out.println("\nBinary Number: " + nc.displayNormalNumber(nc.convertToBinary(decimal)));
            System.out.println("Decimal Number: " + nc.displayNormalNumber(nc.convertToDecimal()));
            System.out.println("Hexadecimal Number: " + nc.displayNormalNumber2(nc.convertToHex(decimal)));
        }
        else if(base == 16){
            String decimal = lc.convertToDecimalGreater10();
            System.out.println("\nDecimal Number: " + decimal);
            System.out.println("Binary Number: " + nc.displayNormalNumber(nc.convertToBinary(decimal)));
            System.out.println("Octal Number: " + nc.displayNormalNumber(nc.convertToOctal(decimal)));
        }
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        }
    }
}

