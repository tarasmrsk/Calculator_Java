import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String expression = input.nextLine();           // Ввод выражения
        Main result = new Main();
        String answer = result.calc(expression);        // Метод calc для объекта result
        System.out.println("Вывод выражения:\n" + answer);
    }
    static class Main{
        public static String calc(String input){ // в метод передается imput
            String [] actions = {"+","-","*","/"}; // по этим знакам будем делить строку
            String [] regexActions = {"\\+","-","\\*","/"};
            int a, b;
            int result =0;
            String exception = "throws Exception";
            int actionIndex=-1;

            for (int i = 0; i < actions.length; i++) {//проверка на знак
                if(input.contains(actions[i])){// смотрим какой индекс у знака
                    actionIndex = i;// присваиваем значение переменной
                    break;
                }
            }
            if(actionIndex==-1){
                return exception;
            }

            String [] data = input.split(regexActions[actionIndex]); // делим строка по индексу знака на массив 2 чисел

            if(Converter.isRoman(data[0])==Converter.isRoman(data[1])){ //проверка на одинаковые числа, не забыть кинуть искл
                boolean isRoman = Converter.isRoman(data[0]); // Проверяем есть ли числа в римском массиве
                if(isRoman){
                    a = Converter.convertRomanToArab(data[0]);
                    b = Converter.convertRomanToArab(data[1]);
                } else { // если арабские, то переводим строку в число
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                if ((a < 1) || (a > 10) || (b < 1) || (b > 10)){ // в римской системе выполняем проверку диапазона вводимых значений
                    return exception;
                }
                switch (actions[actionIndex]) { // по индексу знака выполняем действие
                    case "+" -> result = a + b;// и присваиваем данное значение result
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                    default -> {
                        return exception;
                    }
                }
                if(isRoman){ // вводились ли римские числа, то конвертируем обратно
                    if(result < 1){
                        return exception;
                    }else {
                        return String.valueOf(Converter.convertArabToRoman(result));
                    }
                } else { // если нет, то выводим результат
                    return String.valueOf(result);
                }
            } else{
                return exception; // исключение на разные числа
            }
        }
    }
}