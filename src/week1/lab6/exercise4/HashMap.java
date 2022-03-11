package week1.lab6.exercise4;

public class HashMap<Word, Definition> {
    private Word word;
    private Definition definition;

    public HashMap(Word word, Definition definition) {
        this.word = word;
        this.definition = definition;
    }

    public Definition getDefinition() {
        return definition;
    }

    public Word getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "word=" + word +
                ", definition=" + definition +
                '}';
    }
}
