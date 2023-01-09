
public class NumberConverter {
    int[] digits;
    int number;
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

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public static boolean validBase(String choice){
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

    public static boolean validNumber(String number, String base){
        for(int i = 0; i < number.length(); i++){
            String eachNumber = number.substring(i,i+1);
            int count = 0;
            if(Integer.parseInt(eachNumber) >= Integer.parseInt(base)){
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

    public int[] getDigits() {
        return digits;
    }

    public String displayNormalNumber(int[] conversion){
        String o = "";
        for (int i = 0; i < conversion.length; i++) {
            o = o + conversion[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] convertToDecimal() {
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

    public int[] convertToBinary() {
        int binaryIncrement = 1;
        int count = 0;
        int[]binary = new int[count];
        if(base == 10){
            while(binaryIncrement <= number){
                count++;
                binaryIncrement = binaryIncrement * 2;
            }
            binary = new int[count];
            binary[0] = 1;
            int remainder = number - (int) Math.pow(2,binary.length-1);
            for(int i = 1; i < binary.length; i++){
                if(remainder >= (int) Math.pow(2,binary.length-1-i)){
                    binary[i] = 1;
                    remainder = remainder - (int) Math.pow(2,binary.length-1-i);
                }
            }
        }
        if(base == 8){
            for(int i = 0; i < digits.length; i++){

            }
        }
        return binary;
    }

    public int[] convertToOctal() {
        int quotient = number;
        int octal[] = new int[quotient];
        int count = 0;
        if(base == 10){
            while(quotient != 0){
                quotient = quotient/8;
                count++;
            }
            octal = new int[count];
            quotient = number;
            for(int i = octal.length; i > 0; i--){
                int input = quotient%8;
                quotient = quotient/8;
                octal[i-1] = input;
            }
        }
        else if(base == 2){

        }
        return octal;
    }
}

