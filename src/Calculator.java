
    public class Calculator implements ArithmeticOperations{
        private final Numbers x;
        private final Numbers y;
        private final Operations operation;
        public Numbers result;

        public Calculator(Numbers x, Numbers y, Operations operation) {
            this.x = x;
            this.y = y;
            this.operation = operation;
        }

        public void setResult() throws MyCalculatorException {
            if (x instanceof RomeNumber) {
                result = new RomeNumber();
            } else result = new ArabicNumber();
            result.setValue(computation());
            result.setNumber(result.getValue());
        }

        private int computation() throws MyCalculatorException {
            return switch (this.operation) {
                case ADDITION -> addition();
                case DIVISION -> division();
                case SUBTRACTION -> subtraction();
                case MULTIPLICATION -> multiplication();
            };
        }

        @Override
        public int addition() {
            return x.getValue() + y.getValue();
        }

        @Override
        public int subtraction() throws MyCalculatorException {
            int result = x.getValue() - y.getValue();
            if (result < 0 && (x instanceof RomeNumber && y instanceof RomeNumber)){

               throw new MyCalculatorException("Римская цифра не может быть отрицательной");
            }
            return x.getValue() - y.getValue();
        }

        @Override
        public int multiplication() {
            return x.getValue() * y.getValue();
        }

        @Override
        public int division() {
            return x.getValue() / y.getValue();
        }
    }

