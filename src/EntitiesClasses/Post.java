
package EntitiesClasses;

public class Post {

    private int ID_post;
    private int ID_cust;
    private int ID_sect;
    private String Text;

    public Post(int id, int cid, int sid, String str) {
        this.ID_post = id;
        this.ID_cust = cid;
        this.ID_sect = sid;
        this.Text = str;
    }

    @Override
    public String toString() {
        return getText();
    }

    public int getID_post() {
        return ID_post;
    }

    public void setID_post(int ID_post) {
        this.ID_post = ID_post;
    }

    public int getID_cust() {
        return ID_cust;
    }

    public void setID_cust(int ID_cust) {
        this.ID_cust = ID_cust;
    }

    public int getID_sect() {
        return ID_sect;
    }

    public void setID_sect(int ID_sect) {
        this.ID_sect = ID_sect;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

}
