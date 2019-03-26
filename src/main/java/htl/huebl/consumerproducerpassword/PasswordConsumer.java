package htl.huebl.consumerproducerpassword;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordConsumer implements Runnable {

    private ArrayList<Password> queue = new ArrayList<>();

    public PasswordConsumer(ArrayList<Password> passwords) {
        this.queue = passwords;

    }

    private Password password = null;

    @Override
    public void run() {
        while (true) {
            synchronized (password) {
                if (!queue.isEmpty()) {
                    password = queue.get(0);
                    queue.remove(0);

                } else {
                    password.notify();

                    try {
                        password.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PasswordConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }
    }

    public boolean pwfound(Password password) {
        
    }

}
