package htl.huebl.consumerproducerpassword;

import java.util.ArrayList;

public class PasswordConsumer implements Runnable {

    private ArrayList<Password> passwords = new ArrayList<>();

    public PasswordConsumer(ArrayList<Password> passwords) {
        this.passwords = passwords;

    }

    private Password password = new Password();

    @Override
    public void run() {
        while (true) {
            synchronized (password) {
                if (!passwords.isEmpty()) {
                    password = passwords.get(0);
                    passwords.remove(0);
                }

            }

        }
    }

}
