
    public class Converters {

        public static String convertArabicToRomeNumber(int n) {

            StringBuilder builder = new StringBuilder();

            final RomeNumbersEnum[] values = RomeNumbersEnum.values();
            for (int i = values.length - 1; i >= 0; i--) {
                while (n >= values[i].i) {
                    builder.append(values[i]);
                    n -= values[i].i;
                }
            }
            return builder.toString();
        }

        public static int convertRomeToArabic(String number) throws MyCalculatorException {
            int result = 0;
            String roman = number.toUpperCase();
            for(int i = 0;i < roman.length() - 1;i++) {
                if (convertOne(roman.charAt(i)) < convertOne(roman.charAt(i+1))) {
                    result -= convertOne(roman.charAt(i));
                } else {
                    result += convertOne(roman.charAt(i));
                }
            }
            result += convertOne(roman.charAt(roman.length()-1));
            if (result > 10) throw new MyCalculatorException("The entered number is greater than 10 - " + number);
            return result;
        }

        private static int convertOne(char letter) throws MyCalculatorException {
            return switch (letter) {
                case 'M' -> 1000;
                case 'D' -> 500;
                case 'C' -> 100;
                case 'L' -> 50;
                case 'X' -> 10;
                case 'V' -> 5;
                case 'I' -> 1;
                default -> throw new MyCalculatorException("Number input error - " + letter);
            };
        }
    }

