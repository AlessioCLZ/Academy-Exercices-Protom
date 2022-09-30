package java_30_9_2022.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
public class Library {

	public class Book{
		
		private String title;
		public Book() {}
		
		public Book(String title)
		{
			this.title=title;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
	}
	
	Map<Book, LocalDateTime> books;
	
	public Library() {
		books=new HashMap<Book, LocalDateTime>();
	}
	
	public boolean addBook(Book b) {
		if(books.containsKey(b))
			return false;
		else
		{
			books.put(b, null);
			return true;
		}
	}
	
	public boolean loanBook(Book b) throws Exception
	{		
		if(books.containsKey(b))
		{
			if(books.get(b)==null)
			{
				books.replace(b, LocalDateTime.now());
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			throw new Exception("Il libro richiesto non è presente nel catalogo");
		}
			
	}
	
	public boolean returnBook(Book b) throws Exception
	{
		if(books.containsKey(b))
		{
			if(books.get(b)!=null)
			{
				books.replace(b, null);
				return true;
			}
			else
			{
				throw new Exception("Il libro che si vuole restituire non è stato prestato dalla biblioteca");
			}
		}
		else
		{
			throw new Exception("Il libro che si vuole restituire non appartiene alla biblioteca");
		}
		
		
	}
	
	public Set<Book> printLoans()
	{
		return books.
				entrySet().
				stream().
				filter(book->book.getValue()!=null).
				sorted((o1,o2)->o2.getValue().compareTo(o1.getValue())).
				map(e -> e.getKey()).
				collect(Collectors.toCollection(TreeSet::new));		
	}
	
	
}
