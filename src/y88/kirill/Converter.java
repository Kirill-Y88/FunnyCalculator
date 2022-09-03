package y88.kirill;


/**
 * Класс реализует конвертацию полученного римского числа в арабский и обратно
 * */
class Converter {

    private int [] romanNumeral;

    public String convertToArabic(String num){
        char[] chars = num.toCharArray();
        romanNumeral = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case ('I'):
                    romanNumeral[i] = 1;
                    break;
                case ('V'):
                    romanNumeral[i] = 5;
                    break;
                case('X'):
                    romanNumeral[i] = 10;
                    break;
                default:
                    throw new RuntimeException("Неверный символ римского числа");
            }
        }
        return String.valueOf(conversionToArabic(0));
    }


    private int conversionToArabic(int i){
        if(i == romanNumeral.length - 1){
            return romanNumeral[i];
        }else {
            if(romanNumeral[i] < romanNumeral[i+1]){
                return conversionToArabic(i+1) - romanNumeral[i];
            }else{
                return conversionToArabic(i+1) + romanNumeral[i];
            }
        }
    }

    public String convertToRoman(String number){
        String num = "";
        switch (number){
            case ("1"): num = "I";
                break;
            case ("2"): num = "II";
                break;
            case ("3"): num = "III";
                break;
            case ("4"): num = "IV";
                break;
            case ("5"): num = "V";
                break;
            case ("6"): num = "VI";
                break;
            case ("7"): num = "VII";
                break;
            case ("8"): num = "VIII";
                break;
            case ("9"): num = "IX";
                break;
            case ("10"): num = "X";
                break;
        }
        return num;
    }


}
