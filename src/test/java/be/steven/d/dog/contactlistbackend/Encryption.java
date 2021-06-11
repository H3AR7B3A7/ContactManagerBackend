package be.steven.d.dog.contactlistbackend;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
    @Test
    void test(){
        String encoded = new BCryptPasswordEncoder().encode("pass");
        System.out.println(encoded);
    }
}
