
package EntitiesClasses;

public class Customer {

    private int ID_cust;
    private String Login;
    private String Password;
    private int ID_role;
    private String Family;
    private String Name;
    private String Patronymic;
    private String Email;

    public Customer(int id, String login, String password, int status_id, String second_name, String first_name, String patronymic, String mail) {
        this.ID_cust = id;
        this.Login = login;
        this.Password = password;
        this.ID_role = status_id;
        this.Family = second_name;
        this.Name = first_name;
        this.Patronymic = patronymic;
        this.Email = mail;
    }

    public int getID_cust() {
        return ID_cust;
    }

    public void setID_cust(int ID_cust) {
        this.ID_cust = ID_cust;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getID_role() {
        return ID_role;
    }

    public void setID_role(int ID_role) {
        this.ID_role = ID_role;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String Family) {
        this.Family = Family;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return getLogin();
    }
}
