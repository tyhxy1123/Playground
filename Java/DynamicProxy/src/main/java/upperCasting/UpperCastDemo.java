package upperCasting;

import java.util.ArrayList;
import java.util.List;

public class UpperCastDemo {
    private static List<BaseModel> repo = new ArrayList();
    private static int id = 0;

    static int id(){
        return id++;
    }

    public static void main(String[] args) {

        repo.add(new BaseModel(id()));
        repo.add(new DerivedModel(id()));
        repo.forEach(model -> {

            if(model.getClass() == DerivedModel.class){
                ((DerivedModel)model).uniqueSay();
            }
            else{
                model.say();
            }
        });
    }
}
