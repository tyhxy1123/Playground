package upperCasting;

public class DerivedModel extends BaseModel {

    private String beschreibung;
    public DerivedModel(int id) {
        super(id);
    }

    @Override
    public void say() {
        System.out.println("say DerivedModel");
    }

    public void uniqueSay(){
        System.out.println("Unique Say");
    }

    
}
