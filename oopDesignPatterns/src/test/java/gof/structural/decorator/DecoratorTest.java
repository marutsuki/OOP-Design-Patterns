package gof.structural.decorator;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DecoratorTest {

    private String pubKey =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRMHu+DYSFNJsiigi1CuWNg4vn" +
            "BzSwsqELjVmoMwhOKzgvV34saQ0oO1W+7Oez1kfKnG1F7t62S2zAJ3KIoF/KEwSE" +
            "nsqOGrhqIvRWDbAKGvFDWN0cWoIN649kPKXvb2Z3ZMTu4u79MSr/3qmONAJtWjBe" +
            "P3NNDIZIDjCv9Bt69wIDAQAB";
    @Mock
    MessageReceiver mr = Mockito.mock(MessageReceiver.class);

    @Test
    public void messageServiceWithSanitization() {

        MessageService ms = new MessageServiceBase(mr);

        ms = new MessageServiceJavaScriptSanitizerDecorator(ms);

        ms.send("<p>This part is safe</p><script>alert(\"It is over\")</script>");

        Mockito.verify(mr, Mockito.times(1)).receive("<p>This part is safe</p>");
    }

    @Test
    public void messageServiceWithLoggerEncryption() throws NoSuchAlgorithmException, InvalidKeySpecException {
        MessageService ms = new MessageServiceBase(mr);
        ms = new MessageServiceEncryptionDecorator(ms, pubKey);

        ms = new MessageServiceLoggerDecorator(ms);

        ms.send("Hello world");
    }

    @Test
    public void messageServiceWithNotificationSignature() {
        MessageService ms = new MessageServiceBase(mr);

        ms = new MessageServiceSignatureDecorator(ms, "Lucien\n<b>Some random place<b>\n0444 444 444");
        ms = new MessageServiceNotifyDecorator(ms, "+61-3-99999999");

        ms.send("Hello world");
        Mockito.verify(mr, Mockito.times(1)).receive("Hello world\r\n\r\n" +
                "Lucien\n<b>Some random place<b>\n0444 444 444");

    }
}
