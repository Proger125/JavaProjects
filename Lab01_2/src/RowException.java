public class RowException extends Exception {
    public RowException(String message){
        super(message);
    }
    public String GetMessage(){
        return super.getMessage();
    }
}