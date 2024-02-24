package PassGen.test;

import PassGen.src.AlphabetZ;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class AlphabetTest {

    @Test
    public void basicTest() {
        Boolean[] conditionSet = new Boolean[]{true, true, true, true};
        AlphabetZ a = new AlphabetZ(true, true, true, true);
        String result = a.getAlphabet();
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-_=+\\/~?";
        assertThat(result).isEqualTo(expected);
    }
}
