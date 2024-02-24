package PassGen.src;

public class Password {
    private String val;
    private int length;

    public Password(String s) {
        val = s;
        length = s.length();
    }

    @Override
    public String toString() {
        return val;
    }
}
