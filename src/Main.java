
import java.io.IOException;

    public class Main {

        public static void main(String[] args) throws MyCalculatorException, IOException {

            String inputString = Utils.inputFromConsole();
            String[] numbers = Utils.splittingStringIntoNumbers(inputString);
            Numbers numberX = null;
            Numbers numberY = null;

            try{
                numberX = Utils.getNumbers(numbers[0]);
            } catch (MyCalculatorException e) {
                e.printStackTrace();
            }

            try{
                numberY = Utils.getNumbers(numbers[1]);
            } catch (MyCalculatorException e) {
                e.printStackTrace();
            }

            Operations operation = Utils.getOperation(inputString, numbers);

            if ((numberX != null && numberY != null) &&
                    numberX.getClass().getName().equals(numberY.getClass().getName())) {
                Calculator calculator = new Calculator(numberX, numberY, operation);
                calculator.setResult();
                Utils.outputInConsole(calculator.result.getNumber());
            } else {
                throw new MyCalculatorException("используются одновременно разные системы счисления");
            }
        }
    }

