
package EntitiesClasses;

public class Section {

    private int ID_sect;
    private String Name_sect;

    public Section(int id, String name) {
        this.ID_sect = id;
        this.Name_sect = name;
    }

    @Override
    public String toString() {
        return getName_sect();
    }

    public int getID_sect() {
        return ID_sect;
    }

    public void setID_sect(int ID_sect) {
        this.ID_sect = ID_sect;
    }

    public String getName_sect() {
        return Name_sect;
    }

    public void setName_sect(String Name_sect) {
        this.Name_sect = Name_sect;
    }

    
}
