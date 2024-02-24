package PassGen.test;
import PassGen.src.Generator;
import PassGen.src.Password;
import PassGen.src.AlphabetZ;

import edu.princeton.cs.algs4.Alphabet;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
public class GeneratorTest {
    private final Password password= new Password("Secret");
    private final AlphabetZ firstAlphabet = new AlphabetZ(true,false,false,false);
    private final AlphabetZ secondAlphabet = new AlphabetZ(false,true,true,true);
    private final Generator generator = new Generator(true,false,false,false);

    @Test
    public void testPasswordGen() {
        int length = 5;
        String testPass = generator.generatePass(length).toString();
        assertThat(testPass.length()).isEqualTo(length);
    }

    @Test
    void testPass() {
        assertThat(password.toString()).isEqualTo("Secret");
    }

    @Test
    void testFirstAlphabet() {
        assertThat(firstAlphabet.getAlphabet()).isEqualTo(AlphabetZ.UPPERCASE_LETTERS);
    }

    @Test
    void testSecondAlphabet() {
        assertThat(secondAlphabet.getAlphabet()).isEqualTo(AlphabetZ.LOWERCASE_LETTERS + AlphabetZ.NUMBERS + AlphabetZ.SYMBOLS);
    }
}
