import java.util.Arrays;
class Converter {
    static int [] arabs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static String [] romans = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX","X"};

    static String [] units = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
    static String [] tens = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    static String [] hundreds = new String[]{"","C"};


    public static boolean isRoman(String number){
        return Arrays.asList(romans).contains(number);
    }
    public static int convertRomanToArab(String s) {
        int result = 0;
        for (int i = arabs.length-1; i >= 0; i-- ) {
            while (s.indexOf(romans[i]) == 0 && romans[i].length() > 0) {
                result += arabs[i];
                s = s.substring(romans[i].length());
            }
        }
        return result;
    }
    public static String convertArabToRoman(int number){
        String roman = "";
        roman = hundreds[(number % 1000)/100]
                +tens[(number % 100)/10]
                +units[number % 10];
        return roman;
    }
}