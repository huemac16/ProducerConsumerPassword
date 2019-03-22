package htl.huebl.consumerproducerpassword;

public class Password {

    private String password;

    public boolean check(String test) {
        return test.equals(this.password);

    }

}
