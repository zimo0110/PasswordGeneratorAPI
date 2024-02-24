package PassGen.src;


import org.eclipse.jetty.util.security.Password;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Generator {
    private AlphabetZ alphabet;
    public static Scanner keyboard;
    private Password pass;
    private String tempPassScore;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean upperCase, boolean lowerCase, boolean nums, boolean specialChars) {
        alphabet = new AlphabetZ(upperCase, lowerCase, nums, specialChars);
    }

    public void loop() {
        printGreeting();
        printMainMenu();

        String choice = "-1";

        while (!choice.equals("3")) {
            choice = keyboard.next();

            switch (choice) {
                case "1" -> {
                    generatePassHandler();
                    printMainMenu();
                }
                case "2" -> {
                    printPassStrength();
                    printMainMenu();
                }
                case "3" -> {
                    printQuit();
                }
                default -> {
                    System.out.println("Please select one of the available optons");
                    printMainMenu();
                }
            }
        }
    }

    public void generatePassHandler() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;

        boolean correctParams;

        System.out.println("Answer the following questions with 'y' or 'n' ");

        do {
            String inp;
            correctParams = false;

            do {
                System.out.println("Include Upper Case Letters (ABC...YZ) ?");
                inp = keyboard.next().toLowerCase();
                boolean inpPass = checkPassInp(inp);
            } while (!checkPassInp(inp));
            if (includeInp(inp)) IncludeUpper = true;

            do {
                System.out.println("Include Lower Case Letters (abc...yz) ?");
                inp = keyboard.next().toLowerCase();
                boolean inpPass = checkPassInp(inp);
            } while (!checkPassInp(inp));
            if (includeInp(inp)) IncludeLower = true;

            do {
                System.out.println("Include Numbers Letters (123...) ?");
                inp = keyboard.next().toLowerCase();
                boolean inpPass = checkPassInp(inp);
            } while (!checkPassInp(inp));
            if (includeInp(inp)) IncludeNum = true;

            do {
                System.out.println("Include Symbols Letters ($%&...) ?");
                inp = keyboard.next().toLowerCase();
                boolean inpPass = checkPassInp(inp);
            } while (!checkPassInp(inp));
            if (includeInp(inp)) IncludeSym = true;

            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                correctParams = true;
            }

        } while (correctParams);

        System.out.println("Now Enter the desired length of the password\n");
        int len = keyboard.nextInt();

        final Generator gen = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
        final Password pass = gen.generatePass(len);

        System.out.println("Your Generated Password:\n" + pass);
        passStrengthHandler(pass);
    }

    public Password generatePass(int length) {
        final StringBuilder password = new StringBuilder("");

        final int allIndex = alphabet.getAlphabet().length();

        int min = 0;
        int max = allIndex - 1;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int num = (int) (Math.random() * range) + 1;
            password.append(alphabet.getAlphabet().charAt(num));
        }

        return new Password(password.toString());
    }

    public boolean includeInp(String s) {
        return s.equals("y");
    }

    public boolean checkPassInp(String s) {
        if (!s.equals("y") && !s.equals("n")) {
            System.out.println("Please enter 'y' or 'n'");
            return false;
        }
        return true;
    }

    public void passStrengthHandler(Password pass) {
        //this.tempPassScore = checkPassStrength(pass.toString());
        PasswordStrengthMeter p = new PasswordStrengthMeter();
        this.tempPassScore = p.calc(pass.toString());
    }

    public String checkPassStrength(String s) {
        // Checking lower alphabet in string
        int n = s.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));
        for (char i : s.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }

        // Strength of password
        System.out.print("Strength of password:- ");
        if (hasDigit && hasLower && hasUpper && specialChar && (n >= 8))
            return "Strong";
        else if ((hasLower || hasUpper || specialChar) && (n >= 6))
            return " Moderate";
        else
            return "Weak";
    }

    public void printPassStrength() {
        System.out.println(this.tempPassScore);
    }

    public void printGreeting() {
        System.out.println("Welcome to ZBot Password Generator");
    }

    public void printQuit() {
        System.out.println("Thank you for using our services, Bye Bot");
    }

    public void printMainMenu() {
        System.out.println("Please Select One of The Options Below:");
        System.out.println("1. Generate Password");
        System.out.println("2. Check Password Strength");
        System.out.println("3. Quit");
        System.out.print("Choice: ");
    }
}
