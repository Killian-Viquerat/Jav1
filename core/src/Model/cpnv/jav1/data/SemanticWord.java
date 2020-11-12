package Model.cpnv.jav1.data;

import java.util.HashMap;

public class SemanticWord {
    private HashMap<String, String> values;

    public SemanticWord(){
        values = new HashMap<String, String>();
    }

    public void addTranslation(String language,String value){
        values.put(language,value);
    }

    public String getValue(String language){
        return values.get(language);
    }
}
