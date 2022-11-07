import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneBook {
    private List<Record> recordList = new ArrayList<Record>();

    public List<Record> getAllRecords(){
        return this.recordList;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        if (isConsistPhoneNumber(record)) {
            throw new PhoneNumberAlreadyExists("В справочнике есть запись с номером телефона: ", record.phoneNumber);
        }
        this.recordList.add(record);
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid, PhoneNumberAlreadyExists {
        if (!isConsistId(record.id)) {
            throw new RecordNotFound("Невозможно обновить запись. В справочнике нет записи с id: ", record.id);
        }
        if (!record.isValid()) {
            throw new RecordNotValid("В новой записи не заполнено поле name и/или поле phoneNumber ", record);
        }
        deleteRecord(record.id);
        createRecord(record);
    }

    public void deleteRecord(long id) throws RecordNotFound {
        if (!isConsistId(id)) {
            throw new RecordNotFound("Невозможно удалить запись.В справочнике нет записи с id: ", id);
        }
        recordList.removeIf(r -> r.id == id);
    }

    private boolean isConsistId (long id) {
        for (Record r : recordList) {
            if (r.id == id) {
                return true;
            }
        }
        return false;
    }

    private boolean isConsistPhoneNumber(Record record){
        if (record.phoneNumber.isEmpty()) {
            return false;
        }
        for (Record r : recordList) {
            if (r.phoneNumber == record.phoneNumber) {
                return true;
            }
        }
        return false;
    }
}
