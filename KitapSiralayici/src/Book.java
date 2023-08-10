public class Book implements Comparable<Book>{
    private String name;
    private int pageNum;
    private String author;
    private String releaseDate;

    public Book(String name, int pageNum, String author, String releaseDate) {
        this.name = name;
        this.pageNum = pageNum;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pageNum=" + pageNum +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }
}
