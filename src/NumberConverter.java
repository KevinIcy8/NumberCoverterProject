
public class NumberConverter {
    int[] digits;
    String[] digits2;
    int number;
    String fullNumber;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.number = number;
        this.base = base;
    }

    public NumberConverter(String number, int base){
        String numberAsString = number;
        digits2 = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            String d = single;
            digits2[i] = d;
        }
        this.fullNumber = number;
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public static boolean validBase(String choice){
        if(choice.equals("2") || choice.equals("8") || choice.equals("10") || choice.equals("16")){
            return true;
        }
        return false;
    }


    public static boolean validBase2(String choice){
        String numbers = "0123456789";
        for(int i = 0; i < choice.length(); i++){
            String eachNumber = choice.substring(i,i+1);
            int count = 0;
            if(!(numbers.contains(eachNumber))){
                count++;
            }
            if(count>0){
                return false;
            }
            else{
                return true;
            }

        }
        return true;
    }

    public static boolean validNumber(String number, int base){
        for(int i = 0; i < number.length(); i++){
            String eachNumber = number.substring(i,i+1);
            int count = 0;
            if(Integer.parseInt(eachNumber) >= base){
                count++;
            }
            if(count > 0){
                return false;
            }
        }
        return true;
    }

    public static boolean validNumberHex(String number){
        String hexVariable = "0123456789ABCDEFabcdef";
        for(int i = 0; i < number.length(); i++){
            String eachNumber = number.substring(i,i+1);
            if(!hexVariable.contains(eachNumber)){
                return false;
            }
        }
        return true;
    }

    public int[] getDigits() {
        return digits;
    }

    public String displayNormalNumber(int[] conversion){
        String o = "";
        for (int i = 0; i < conversion.length; i++) {
            o = o + conversion[i];
        }
        return o;
    }

    public String displayNormalNumber2(String[] conversion){
        String o = "";
        for (int i = 0; i < conversion.length; i++) {
            o = o + conversion[i];
        }
        return o;
    }

    public int[] convertToDecimal() {
        /*if(base > 10){
            int initialPower = digits2.length - 1;
            int sum = 0;
            for(int i = 0; i < digits2.length; i++){
                sum = sum + (digits2[i] * (int)Math.pow(base, initialPower));
                initialPower--;
            }
        }

         */
        int initialPower = digits.length - 1;
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            sum = sum + (digits[i] * (int)Math.pow(base, initialPower));
            initialPower--;
        }
        String sumString = String.valueOf(sum);
        int [] decimal = new int[sumString.length()];
        for(int i = 0; i < decimal.length; i++){
            decimal[i] = Integer.parseInt(sumString.substring(i,i+1));
        }
        return decimal;
    }

    public String convertToDecimalGreater10(){
        String letters = "ABCDEF";
        String[] digit = new String[digits2.length];
        for(int i = 0; i < digits2.length; i++){
            if(letters.contains(digits2[i])){
                if(digits2[i].equals("A")){
                    digit[i] = "10";
                }
                if(digits2[i].equals("B")){
                    digit[i] = "11";
                }
                if(digits2[i].equals("C")){
                    digit[i] = "12";
                }
                if(digits2[i].equals("D")){
                    digit[i] = "13";
                }
                if(digits2[i].equals("E")){
                    digit[i] = "14";
                }
                if(digits2[i].equals("F")){
                    digit[i] = "15";
                }
            }
            else {
                digit[i] = digits2[i];
            }
        }
        int initialPower = digit.length - 1;
        int sum = 0;
        for(int i = 0; i < digit.length; i++){
            sum = sum + (Integer.parseInt(digit[i]) * (int)Math.pow(base, initialPower));
            initialPower--;
        }
        return String.valueOf(sum);
    }

    public int[] convertToBinary(String decimal) {
        int binaryIncrement = 1;
        int count = 0;
        int intNumber = Integer.parseInt(decimal);
        while(binaryIncrement <= intNumber){
                count++;
                binaryIncrement = binaryIncrement * 2;
        }
        int[]binary = new int[count];
        binary[0] = 1;
        int remainder = intNumber - (int) Math.pow(2,binary.length-1);
        for(int i = 1; i < binary.length; i++){
            if(remainder >= (int) Math.pow(2,binary.length-1-i)){
                binary[i] = 1;
                remainder = remainder - (int) Math.pow(2,binary.length-1-i);
            }
        }
        return binary;
    }

    public int[] convertToOctal(String decimal) {
        int quotient = Integer.parseInt(decimal);
        int[] octal;
        int count = 0;
        while(quotient != 0){
            quotient = quotient/8;
            count++;
        }
        octal = new int[count];
        quotient = Integer.parseInt(decimal);
        for(int i = octal.length-1; i >= 0; i--){
            int input = quotient%8;
            quotient = quotient/8;
            octal[i] = input;
        }

        return octal;
    }

    public String[] convertToHex(String decimal){
        int quotient = Integer.parseInt(decimal);
        String[] hex;
        int count = 0;
        while(quotient != 0){
            quotient = quotient/16;
            count++;
        }
        hex = new String[count];
        quotient = Integer.parseInt(decimal);
        for(int i = hex.length -1; i >= 0; i--){
            String input = String.valueOf(quotient % 16);
            quotient = quotient/16;
            if(Integer.parseInt(input) >= 10){
                if(input.equals("10")){
                    input = "A";
                }
                if(input.equals("11")){
                    input = "B";
                }
                if(input.equals("12")){
                    input = "C";
                }
                if(input.equals("13")){
                    input = "D";
                }
                if(input.equals("14")){
                    input = "E";
                }
                if(input.equals("15")){
                    input = "F";
                }
            }
            hex[i] = input;
        }
        return hex;
    }

    public String[] convertToAny(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        int quotient = number;
        String[] any;
        int count = 0;
        while(quotient != 0){
            quotient = quotient/base;
            count++;
        }
        any = new String[count];
        quotient = number;
        for(int i = any.length -1; i >= 0; i--) {
            String input = String.valueOf(quotient % base);
            quotient = quotient / base;
            if(Integer.parseInt(input) >= 10){
                input = letters.substring(Integer.parseInt(input)-10,Integer.parseInt(input)-10+1);
            }
            any[i] = input;
        }
        return any;
    }

}

