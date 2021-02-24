package App;

public class MyException extends Exception {
    public MyException(String ex) {
        super(ex);
    }

    public void print_message() {
        System.out.println(super.getMessage());
    }
}
