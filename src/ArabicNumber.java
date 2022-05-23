public class ArabicNumber implements Numbers {

        private String number;
        private int value;

        public ArabicNumber(int value) {
            this.value = value;
            this.number = String.valueOf(value);
        }

        public ArabicNumber() {

        }

        @Override
        public void setNumber(int value) {
            this.number = String.valueOf(value);
        }

        @Override
        public String getNumber() {
            return number;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public void setValue(int value) {
            this.value = value;
        }
    }

