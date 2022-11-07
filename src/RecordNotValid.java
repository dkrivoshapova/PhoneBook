public class RecordNotValid extends Exception {
    private Record person;
    
    public RecordNotValid(String message,Record record) {
        super(message);
        person = record;
    }

    public String getRecord() {
        return person.toString();
    }
}
