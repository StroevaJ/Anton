
package EntitiesClasses;

public class Comments {

    private int ID_com;
    private int ID_post;
    private int ID_cust;
    private int ID_prev;
    private String Comment;

    public Comments(int id, int pId, int cId, int prevId, String text) {
        this.ID_com = id;
        this.ID_post = pId;
        this.ID_cust = cId;
        this.ID_prev = prevId;
        this.Comment = text;
    }

    @Override
    public String toString() {
        return getComment();
    }

    public int getID_com() {
        return ID_com;
    }

    public void setID_com(int ID_com) {
        this.ID_com = ID_com;
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

    public int getID_prev() {
        return ID_prev;
    }

    public void setID_prev(int ID_prev) {
        this.ID_prev = ID_prev;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    
}
