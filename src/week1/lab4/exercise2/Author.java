package week1.lab4.exercise2;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ") at " + email;

    }
}

class TestAuthor{
    public static void main(String[] args){
        Author author=new Author("J. Lynn", "jlynn@gmail.com",'f');
        System.out.println(author);
        author.setEmail("jenniferlynn@yahoo.com");
        System.out.println(author.getName()+" email:"+author.getEmail()+" gender:"+author.getGender());
    }
}

