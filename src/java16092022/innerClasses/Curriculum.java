package java16092022.innerClasses;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {
	
	private String fullName;
	private List<Job> jobs = new ArrayList<Job>();
	
	private Job job;
	
	//costruttore aad un solo campo
	public Curriculum(String fullName) {
		super();
		this.fullName = fullName;
	}

	 //getter e setter
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	//classe interna
	public class Job{
		
		private String profession;
		private int year;
		private Job next;
		
		public Job(String p,int y)
		{
			profession=p;
			year=y;
		}

		public String getProfession() {
			return profession;
		}

		public void setProfession(String profession) {
			this.profession = profession;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}
		
		@Override
		public String toString()
		{
			return profession+ ": "+year;
		}

		public Job next() {
			return this.next;	
			
		}
		
	}
	
	//aggiunta di un lavoro senza l'uso di una lista
	public Curriculum.Job addJob(String profession, int year)
	{
		//creo una nuova istanza di Job
		Job j= new Job(profession, year);
		
		//se il lavoro richiamato è pieno
		if(job!=null) {
			// ne creo un riferimento nel metodo
			Job jj = job;
			
			while(jj.next!= null) {
				//e gli assegno il valore del lavoro successivo
				jj=jj.next;
			}
			//dandolo alla nuova istanza di lavoro all'interno del metodo
			jj.next=j;
		}else {
			//e infine all'istanza richiamata
			job=j;
		}
		return j;
	}
	
	
	
}
