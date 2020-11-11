package Model.cpnv.jav1.data;

public class Word{
    
    private String value1;
    private String value2;
    private boolean allocated;
    private boolean found;

    public String getValue1(){
        return value1;
    }

    public String getValue2(){
        return value2;
    }

    public Word(String value1, String value2){
        this.value1 = value1;
        this.value2 = value2;
        allocated = false;
        found = false;
    }
}