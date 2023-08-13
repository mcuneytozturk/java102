import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        for (int i = 1; i < 100; i++) {
            Book book = new Book();
            book.setName("Kitap " + i);
            book.setAuthor(i + ". kitabın yazarı");
            book.setPage(new Random().nextInt(400));
            book.setPublishDate(i + ". kitanın tarihi");
            books.add(book);
        }

        Map<String, String> titleAuthorMap = books.stream().collect(Collectors.toMap(Book::getName, Book::getAuthor));

        System.out.println("Title -> Author");
        titleAuthorMap.forEach((title, author) -> System.out.println(title + " -> " + author));

        List<Book> filteredBooks = books.stream().filter(book -> book.getPage() > 100 ).toList();

        filteredBooks.forEach(book -> System.out.println(book.getName() + " -> " + book.getPage()));
    }
}
