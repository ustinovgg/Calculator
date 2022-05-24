

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

    public class Utils {



        public static String inputFromConsole() throws MyCalculatorException, IOException {
            String string;
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                string = reader.readLine();
            }
            if (string.isEmpty()) throw new MyCalculatorException("строка не является математической операцией");
            return string;
        }

        public static void outputInConsole(String s) {
            System.out.println(s);
        }

        public static String[] splittingStringIntoNumbers(String inputString) throws MyCalculatorException {
            String[] splitInputString = inputString.toUpperCase(Locale.ROOT).split("[-+/*]");
            if (splitInputString.length != 2) throw new MyCalculatorException("Incorrect string - " + inputString);
            return splitInputString;
        }

        public static Operations getOperation(String inputString, String[] numbers){
            String s = numbers[0];
            String operation = inputString.substring(s.length(), s.length() + 1);
            return switch (operation) {
                case "+" -> Operations.ADDITION;
                case "-" -> Operations.SUBTRACTION;
                case "*" -> Operations.MULTIPLICATION;
                case "/" -> Operations.DIVISION;

                default -> throw new IllegalStateException("Unexpected value: " + operation);
            };
        }

        public static Numbers getNumbers(String number) throws MyCalculatorException {

            try {
                int a = Integer.parseInt(number.trim());
                if (a > 10) throw new MyCalculatorException("The entered number is greater than 10 - " + a);
                return new ArabicNumber(a);
            } catch (NumberFormatException e) {
                int a = Converters.convertRomeToArabic(number.trim());
                return new RomeNumber(a);
            }
        }
    }

