public class RecordNotFound extends RuntimeException {
    long iD;

    public long getId() {return this.iD;}

    public RecordNotFound(String message, long id) {
        super(message);
        this.iD = id;
    }
}
