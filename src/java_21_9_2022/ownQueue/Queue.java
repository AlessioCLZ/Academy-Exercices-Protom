package java_21_9_2022.ownQueue;


public class Queue<E> {

	public class Element{
		
		private E index; //elemento chiave inserito nella queue
		private Element next; //riferimento all'elemento successivo
		
		public Element(E index, Element next)
		{
			this.index=index;
			this.next=next;
		}
		
	}
	private Element top; //elemento iniziale della queue
	
	public Element getTop() {
		return top;
	}
	
	//First in
	public void push (E index) {
		//
		Element formerTop= top;
		
		top=new Element(index, formerTop);
	}
	
	//first out
	public E pop()
	{
		if(this.top==null)
			return null;
		else{
			E index = top.index;
			top=top.next;
			return index;
		}		
	}
	
	public E readTop()
	{
		if(this.top==null)
			return null;
		else
			return top.index;
	}
	
	//metodi LIFO
	
	//last in
	public void insertBottom(E index)
	{
		Element element = new Element(index, null);
		if(this.top==null)
			top=element;
		else
		{
			Element current= this.top;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=element;
		}
	}
	
	//last out
	public void removeBottom() {
		Element current = this.top;
		Element former=this.top;
		if(this.top==null)
			return;
		else {
			while(current.next!=null) {
				former=current;
				current=current.next;
			}
			former.next=null;
			current=null;
			System.gc();
		}
	}
	
	//print methods
	
	public void printAllByDefPosition() {
		if(this.top==null)
			System.out.println("Coda/stack vuoto. Inserisci dei metodi usando: push(<E> index) o insertBottom(<E> index)");
		else {
			Element current = top;
			while(current!=null) {
				System.out.println("Indice:"+current.index);
				current=current.next;
			}
			System.out.println("Vuoto");
		}
	}
	
	public boolean isEmpty() {
		return (this.top == null);
	}
	
	public void printAllInReverse(Element top) {
		if (null == top) {
            return;
        }
		printAllInReverse(top.next);
        System.out.print("Indice=" + top.index);
	}
	
}
