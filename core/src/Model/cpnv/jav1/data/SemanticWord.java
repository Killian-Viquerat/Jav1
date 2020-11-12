package Model.cpnv.jav1.data;

import com.badlogic.gdx.Gdx;

import java.util.HashMap;

import ch.cpnv.jav1.activities.Play;
import ch.cpnv.jav1.customException.TranslationDoesNotExistException;
import ch.cpnv.jav1.customException.TranslationExistsException;

public class SemanticWord {
    private HashMap<String, String> values;

    public SemanticWord(){
        values = new HashMap<String, String>();
    }

    public void addTranslation(String language,String value) throws TranslationExistsException{
            if (values.get(language) != null) {
                throw new TranslationExistsException("Already exist");
            } else {
                values.put(language, value);
            }
            ;
    }

    public String getValue(String language) throws TranslationDoesNotExistException {
            if (values.get(language) == null){
                throw new TranslationDoesNotExistException("Translation does not exist");
            }else{
                 return values.get(language);
            }
    }

}
