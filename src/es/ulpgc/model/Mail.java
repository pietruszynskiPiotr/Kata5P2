package es.ulpgc.model;

public class Mail {

    private final String email;

    public Mail(String email) {
        this.email = email;
    }

    public String getDomain() {
        int i = email.lastIndexOf('@');
        return email.substring(i);
    }

}
