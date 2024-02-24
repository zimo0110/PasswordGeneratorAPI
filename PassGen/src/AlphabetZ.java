package PassGen.src;

public class AlphabetZ {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    private StringBuilder stringBuilder;

    /**We will take in all booleans needed to specify what password we need
     * Initialise an instance of StringBuilder
     * Add needed params based on the input booleans
     * */
    public AlphabetZ (boolean upperCase, boolean lowerCase, boolean nums, boolean specialChars) {
        stringBuilder = new StringBuilder();

        if (upperCase) stringBuilder.append(UPPERCASE_LETTERS);
        if (lowerCase) stringBuilder.append(LOWERCASE_LETTERS);
        if (nums) stringBuilder.append(NUMBERS);
        if (specialChars) stringBuilder.append(SYMBOLS);
    }

    public String getAlphabet() {
        return stringBuilder.toString();
    }


}
