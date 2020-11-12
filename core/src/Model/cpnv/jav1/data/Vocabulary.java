package Model.cpnv.jav1.data;

import java.util.ArrayList;
import ch.cpnv.jav1.jav1bird;

public class Vocabulary{

    private String vocName;
    private ArrayList<SemanticWord> words;

    public Vocabulary(String vocName){
        this.vocName = vocName;
        this.words = new ArrayList<SemanticWord>();
    }

    public void addSemanticWord(SemanticWord sw){
        words.add(sw);
    }

    public SemanticWord pickAWord(){
        return words.get(jav1bird.random.nextInt(words.size()));
    }
}