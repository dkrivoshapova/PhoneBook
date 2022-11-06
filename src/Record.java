import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Record {
    public long id;
    public String phoneNumber = "";
    public String name = "";

    public Record(long id , String phoneNumber, String name){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Record(long id , String info){
        this.id = id;
        if (isPhoneNumber()){
            this.phoneNumber = info;
        } else {
            this.name = info;
        }
    }

    public Record(long id ){
        this.id = id;

    }

    @Override
    public String toString() {
        return this.id + " " + this.name+ " " + this.phoneNumber;
    }

    public boolean isValid(){
        if (!Objects.equals(this.name, "")) {
            return false;
        }
        return Objects.equals(this.phoneNumber, "");
    }
    private boolean isPhoneNumber() {
        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(this.phoneNumber);
        return matcher.matches();
    }
}
