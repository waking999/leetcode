package history;

public class AddDigit {
    public int addDigits(int num) {
        return num - ((num - 1) / 9) * 9;
    }


}
