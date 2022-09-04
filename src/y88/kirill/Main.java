package y88.kirill;

public class Main {

    public static void main(String[] args) {


    }

    public static String calc(String input){

        Converter converter = new Converter();
        String [] arg = input.split("(?!^)\\b");

        if(arg.length < 3){
            throw new RuntimeException("Строка не является математической операцией");
        }else if(arg.length > 3){
            throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }else if(isArabic(arg[0])&&isArabic(arg[2])){
            return calculate(arg);
        }else if(!isArabic(arg[0])&&!isArabic(arg[2])){
            arg[0] = converter.convertToArabic(arg[0]);
            arg[2] = converter.convertToArabic(arg[2]);
            String arabicResult = calculate(arg);
            if(Integer.parseInt(arabicResult) <= 0){
                throw new RuntimeException("в римской системе нет отрицательных чисел и нуля");
            }
            return converter.convertToRoman(arabicResult);
        }else {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        }
    }

    private static boolean isArabic(String arg){
       try {
           Integer.parseInt(arg);
           return true;
       }catch (NumberFormatException e){
           return false;
       }
    }

    private static String calculate(String [] mathExpression){
        int result = 0;
        switch (mathExpression[1]){
            case ("-"): result = Integer.parseInt(mathExpression[0]) - Integer.parseInt(mathExpression[2]);
                break;
            case ("+"): result = Integer.parseInt(mathExpression[0]) + Integer.parseInt(mathExpression[2]);
                break;
            case ("*"): result = Integer.parseInt(mathExpression[0]) * Integer.parseInt(mathExpression[2]);
                break;
            case ("/"): result = Integer.parseInt(mathExpression[0]) / Integer.parseInt(mathExpression[2]);
                break;
        }
        return String.valueOf(result);
    }

}
