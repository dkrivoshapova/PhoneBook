public class PhoneNumberAlreadyExists extends Exception {
    private String number;
    public String getPhoneNumber(){return this.number;}
    public PhoneNumberAlreadyExists(String message,String phoneNumber) {
        super(message);
        number = phoneNumber;

    }
}
