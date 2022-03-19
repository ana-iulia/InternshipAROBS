package lab4.exercise2;

class TestAuthor{
    public static void main(String[] args){
        Author author=new Author("J. Lynn", "jlynn@gmail.com",'f');
        System.out.println(author);
        author.setEmail("jenniferlynn@yahoo.com");
        System.out.println(author.getName()+" email:"+author.getEmail()+" gender:"+author.getGender());
    }
}
