package test;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;

public class BaseUnitTest {

    protected final StringBuffer outputs = new StringBuffer();

    @BeforeEach
    public void setUpStreams() {
        outputs.setLength(0);
    }

    protected void logging(Object s) {
        outputs.append(s);
    }

    protected void assertLoggingTrue() {
        Approvals.verify(outputs.toString());
    }
}
