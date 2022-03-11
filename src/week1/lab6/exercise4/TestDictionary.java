package week1.lab6.exercise4;

import java.util.Scanner;

public class TestDictionary {
    public static void displayChoiceList() {
        System.out.println("""
                List of commands:
                1. Add word
                2. Show definition
                3. Show all words
                4. Show all definitions
                5. Exit""");
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner s = new Scanner(System.in);
        System.out.println("""
                Commands:
                1. View test results
                2. Make new tests
                """);
        System.out.println("Introduce command: ");
        String command = s.nextLine();
        switch (command) {
            case "1":
                dictionary.addWord(new Word("essay"), new Definition("a short piece of writing on a particular subject"));
                dictionary.addWord(new Word("grammar"), new Definition("the rules about how words change their form"));
                dictionary.addWord(new Word("nature"), new Definition("all the animals, plants, rocks, etc. in the world"));
                System.out.println("Words:");
                dictionary.getAllWords().stream().forEach(System.out::println);
                System.out.println("Definitions:");
                dictionary.getAllDefinitions().stream().forEach(System.out::println);
                System.out.println("Definition of grammar: " + dictionary.getDefinition(new Word("grammar")));
                break;
            case "2":
                while (true) {
                    try {
                        while (true) {
                            System.out.println("Enter your choice:");
                            displayChoiceList();
                            System.out.println("Introduce command: ");
                            String choice = s.nextLine();
                            switch (choice) {
                                case "1":
                                    System.out.println("Introduce name of the word:");
                                    String name = s.nextLine();
                                    System.out.println("Introduce description of the word:");
                                    String description = s.nextLine();
                                    dictionary.addWord(new Word(name), new Definition(description));
                                    break;
                                case "2":
                                    System.out.println("Introduce the word:");
                                    String word = s.nextLine();
                                    System.out.println(dictionary.getDefinition(new Word(word)));
                                    break;
                                case "3":
                                    dictionary.getAllWords().forEach(System.out::println);
                                    break;
                                case "4":
                                    dictionary.getAllDefinitions().forEach(System.out::println);
                                    break;
                                case "5":
                                    return;
                                case "exit":
                                    return;
                                default:
                                    System.out.println("Command doesn't exist!");
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                }
            default:
                System.out.println("Command doesn't exist!");
        }
    }
}
