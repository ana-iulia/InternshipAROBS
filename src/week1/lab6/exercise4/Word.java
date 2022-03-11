package week1.lab6.exercise4;

import week1.lab6.exercise1.BankAccount;

import java.util.Objects;

public class Word {
    private String name;

    public Word(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Word{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            Word word = (Word) obj;
            return (Objects.equals(name, word.name));
        }
        return false;
    }
}
