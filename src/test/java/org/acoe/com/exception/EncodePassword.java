package org.acoe.com.exception;

import java.util.Base64;

public class EncodePassword {

    public static void main(String[] args) {
        String data = Base64.getEncoder().encodeToString("testingminibytes".getBytes());
        System.out.println(data);

        String decoded = new String(Base64.getDecoder().decode("dGVzdGluZ21pbmlieXRlcw==".getBytes()));
        System.out.println(decoded);
    }
}
