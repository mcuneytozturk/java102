
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book hp1 = new Book("Harry Potter ve Felsefe Taşı");
        Book hs = new Book("HaşHaş Savaşı");
        Book lly = new Book("Locke Lomora'nın Yalanları");
        Book  witcher = new Book("The Witcher");
        Book aebg = new Book("Adanın Etrafında Bir Gece");

        Set<Book> books = new TreeSet<>();
        books.add(hp1);
        books.add(hs);
        books.add(lly);
        books.add(witcher);
        books.add(aebg);

        for (Book b: books){
            System.out.println(b);
        }

    }
}