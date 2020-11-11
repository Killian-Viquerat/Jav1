package Model.cpnv.jav1.data;

import java.util.ArrayList;
import ch.cpnv.jav1.jav1bird;

public class Vocabulary{

    private String vocName;
    private ArrayList<Word> words;

    public Vocabulary(String vocName){
        this.vocName = vocName;
        this.words = new ArrayList<Word>();
    }

    public void addWord(Word w){
        words.add(w);
    }

    public Word pickAWord(){
        return words.get(jav1bird.random.nextInt(words.size()));
    }
}