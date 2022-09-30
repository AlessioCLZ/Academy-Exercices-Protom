package java_27_09_2022.streams.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
	
	public class Book {

		@SuppressWarnings("unused")
		private String title, author;
		private Set<String> tags;
		
		public Book() {}

		public Book( String author, String title) {
			super();
			this.title = title;
			this.author = author;
		}

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Set<String> getTags() {
			return tags;
		}
		public void setTags(Set<String> tags) {
			this.tags = tags;
		}
		
		public void addTag(String tag)
		{
			tags.add(tag);
		}
		
		public String toString()
		{
			return title + ", by " +author;
		}
	}
	
	private Map<String, Book> books;
	
	public Library() {
		books = new HashMap<>();
	}
	
	
	
	public Book addBook(String author, String title)
	{
		Book res= new Book(author, title);	
		books.put(res.getTitle(), res);
		return res;
	}
	
	public Set<Book> getBooksbyTag(String tag)
	{
		Set<Book> res = books.values().stream().filter(book -> book.getTags().contains(tag)).collect(Collectors.toSet());
		return res;
	}
	
}
