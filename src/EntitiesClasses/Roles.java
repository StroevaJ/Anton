
package EntitiesClasses;

public class Roles {

    private int ID_role;
    private String Name_role;

    public Roles(int id, String name) {
        this.ID_role = id;
        this.Name_role = name;
    }

    @Override
    public String toString() {
        return getName_role();
    }

    public int getID_role() {
        return ID_role;
    }

    public void setID_role(int ID_role) {
        this.ID_role = ID_role;
    }

    public String getName_role() {
        return Name_role;
    }

    public void setName_role(String Name_role) {
        this.Name_role = Name_role;
    }
}
