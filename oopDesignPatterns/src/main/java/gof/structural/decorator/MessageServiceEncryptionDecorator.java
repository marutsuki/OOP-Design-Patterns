package gof.structural.decorator;

import lombok.extern.log4j.Log4j2;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Log4j2
public class MessageServiceEncryptionDecorator extends MessageServiceDecorator {

    private PublicKey pubKey;

    public MessageServiceEncryptionDecorator(MessageService wrappee, String pubKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        super(wrappee);

        byte[] decodedKey = Base64.getDecoder().decode(pubKey);

        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decodedKey);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        this.pubKey = kf.generatePublic(publicKeySpec);
    }

    /**
     * This decorator encrypts the message before passing it to the next handler.
     * @param message The message to encrypt
     */
    @Override
    public void send(String message) {
        try {
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] encrypted = encryptCipher.doFinal(message.getBytes());
            getWrappee().send(Base64.getEncoder().encodeToString(encrypted));
        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException |
                 InvalidKeyException e) {
            log.error("Failed to encrypt message {}", message);
            getWrappee().send(message);
        }
    }
}
