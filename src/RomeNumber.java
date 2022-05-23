

public class RomeNumber implements Numbers {
        private String number;
        private int value;

        public RomeNumber(int value) {
            this.value = value;
            this.number = Converters.convertArabicToRomeNumber(value);
        }

        public RomeNumber() {

        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public void setValue(int value) {
            this.value = value;
        }



        @Override
        public void setNumber(int value) {
            this.number = Converters.convertArabicToRomeNumber(value);
        }

        @Override
        public String getNumber() {
            return number;
        }

    }

