package lab3.exercise3;

class TestAuthor{
    public static void main(String[] args){
        Author author=new Author("K. Jake", "jakek@gmail.com",'m');
        System.out.println(author);
        author.setEmail("jjk@yahoo.com");
        System.out.println(author.getName()+" "+author.getEmail()+" "+author.getGender());
    }
}