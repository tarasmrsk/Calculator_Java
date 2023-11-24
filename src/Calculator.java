import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String expression = input.nextLine();           // Ввод выражения
        Main result = new Main();
        String answer = result.calc(expression);        // Метод calc для объекта result
        System.out.println("Вывод выражения:\n" + answer);
    }
    static class Main{
        public static String calc(String input) throws Exception { // в метод передается imput
            String [] data = input.split(" ");
            if(data.length == 1){
                throw new Exception("Строка не является математической операцией");
            }
            if (data.length != 3) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда" +
                        " и один оператор (+, -, /, *)");
            }
            if (data[1].equals("+") || data[1].equals("-") || data[1].equals("*") || data[1].equals("/")){
            } else {
                throw new Exception("Неверный знак оператора");
            }

            int a, b;
            int result =0;

            if(Converter.isRoman(data[0])==Converter.isRoman(data[2])){ //проверка на одинаковые числа, не забыть кинуть искл
                boolean isRoman = Converter.isRoman(data[0]); // Проверяем есть ли числа в римском массиве
                if(isRoman){
                    a = Converter.convertRomanToArab(data[0]);
                    b = Converter.convertRomanToArab(data[2]);
                } else { // если арабские, то переводим строку в число
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[2]);
                }
                if ((a < 1) || (a > 10) || (b < 1) || (b > 10)){ // в римской системе выполняем проверку диапазона вводимых значений
                    throw new Exception("ВВедите число от 1 до 10 включительно");
                }
                switch (data[1]) { // по индексу знака выполняем действие
                    case "+" -> result = a + b;// и присваиваем данное значение result
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                    default -> {
                        throw new Exception("Неверный знак оператора");

//                        return exception;
                    }
                }
                if(isRoman){ // вводились ли римские числа, то конвертируем обратно
                    if(result < 1){
                        throw new Exception("В римской системе нет отрицательных чисел");
                    }else {
                        return String.valueOf(Converter.convertArabToRoman(result));
                    }
                } else { // если нет, то выводим результат
                    return String.valueOf(result);
                }
            } else{
                throw new Exception("Используются одновременно разные системы счисления");
            }
        }
    }
}
