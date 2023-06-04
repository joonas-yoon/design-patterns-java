package test;

import java.nio.charset.StandardCharsets;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;

public class BaseUnitTest {

    protected final StringBuffer outputs = new StringBuffer();

    @BeforeEach
    public void setUpStreams() {
        outputs.setLength(0);
    }

    protected void logging(Object s) {
        logging(s, true);
    }

    protected void logging(Object s, boolean newline) {
        String inputString = s.toString();
        if (newline) {
            inputString += "\n";
        }
        String encodedString = new String(inputString.getBytes(), StandardCharsets.UTF_8);
        System.out.print(encodedString);
        outputs.append(encodedString);
    }

    protected void assertLoggingTrue() {
        String outputString = outputs.toString();
        String encodedString = new String(outputString.getBytes(), StandardCharsets.UTF_8);
        Approvals.verify(encodedString);
    }
}
