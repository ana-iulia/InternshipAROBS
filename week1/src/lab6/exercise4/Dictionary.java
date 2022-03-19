package lab6.exercise4;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<HashMap> hashMaps = new ArrayList<>();

    public void addWord(Word word, Definition definition) {
        HashMap hashMap = new HashMap(word, definition);
        this.hashMaps.add(hashMap);
    }

    public Definition getDefinition(Word word) {
        for (HashMap hashMap : hashMaps) {
            if (word.equals(hashMap.getWord())) {
                return (Definition) hashMap.getDefinition();
            }
        }
        return null;
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        hashMaps
                .stream()
                .forEach(x -> words.add((Word) x.getWord()));
        return words;
    }

    public List<Definition> getAllDefinitions() {
        List<Definition> definitions = new ArrayList<>();
        hashMaps
                .stream()
                .forEach(x -> definitions.add((Definition) x.getDefinition()));
        return definitions;
    }

}
