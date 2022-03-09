package week1.lab3.exercise3;

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
        Author author=new Author("K. Jake", "jakek@gmail.com",'m');
        System.out.println(author);
        author.setEmail("jjk@yahoo.com");
        System.out.println(author.getName()+" "+author.getEmail()+" "+author.getGender());
    }
}


