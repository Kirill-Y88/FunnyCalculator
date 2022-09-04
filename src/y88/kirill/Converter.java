package y88.kirill;


/**
 * Класс реализует конвертацию полученного римского числа в арабский и обратно
 * */
class Converter {

    private int [] romanNumeral;
    private String [] romanNum = new String[]{"I","V","X","L","C"};


/**
 * Метод для конвертации из римкой в арабскую цифру
 * */
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

/**
 * Вспомогательный рекурсивный метод для конвертации из римкой в арабскую цифру
 * */
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


/**
  * Метод для конвертации из арабской в римскую цифру
  * */
    public String convertToRoman(String number){
        int digit = number.length()-1;
        int num;
        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < number.length(); i++ , digit--) {

           num = Integer.parseInt(String.valueOf(number.charAt(i)));

            if(1 <= num && num < 4){
                for (int j = 1; j <= num; j++) {
                    romanNumber.append(romanNum[0 + 2 * digit]);
                }
            }else if(4 <= num && num < 9){
                if(num==4){
                    romanNumber.append(romanNum[0 + 2 * digit]).append(romanNum[1 + 2 * digit]);
                }else {
                    romanNumber.append(romanNum[1 + 2 * digit]);
                    for (int j = 6; j <= num; j++) {
                        romanNumber.append(romanNum[0 + 2 * digit]);
                    }
                }
            }else if(num == 9) {
                romanNumber.append(romanNum[0 + 2 * digit]).append(romanNum[0 + 2 * (digit+1)]);
            }

        }
        return romanNumber.toString();
    }

}
