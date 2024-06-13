package upperCasting;

public class BaseModel {
    private int id;

    public BaseModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void say(){
        System.out.println("say BaseModel");
    }
}
