public class Main {
    public static void main(String[] args) {
        PhoneBook g = new PhoneBook();
        try {
            g.createRecord(new Record(90000));
            g.createRecord(new Record(90001, "89829381506", "Даша К"));
            g.createRecord(new Record(90002, "89529381507", "Alina К"));
            g.createRecord(new Record(90003, "89529381508"));
            g.createRecord(new Record(90004, "Sveta К"));
            g.createRecord(new Record(90005, "89829381506", "Даша Кривошапова"));

        } catch(PhoneNumberAlreadyExists e) {
            System.out.print(e.getMessage());
            System.out.println(e.getPhoneNumber());
        }
        System.out.println(g.getAllRecords());

        try {
            g.updateRecord(new Record(90002, "89529383507", "Alina U"));
            g.updateRecord(new Record(90004, "Sveta U"));
        } catch(PhoneNumberAlreadyExists e) {
            System.out.print(e.getMessage());
            System.out.println(e.getPhoneNumber());
        } catch (RecordNotValid e){
            System.out.print(e.getMessage());
            System.out.println(e.getRecord());
        }

        System.out.println(g.getAllRecords());
        g.deleteRecord(90004);
        System.out.println(g.getAllRecords());

    }
}