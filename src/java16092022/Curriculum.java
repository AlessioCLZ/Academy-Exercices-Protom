package java16092022;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {
	
	private String fullName;
	private List<Job> jobs = new ArrayList<Job>();
	
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

	

	public Curriculum(String fullName) {
		this.fullName = fullName;
	}
	
	public class Job{
		
		private String profession;
		private int year;
		
		private Job(String p,int y)
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
		
		@SuppressWarnings("unused")
		public String next() {
			Job j= new Job(this.profession, this.year);
			for(int i=0; i<jobs.size(); i++)
			{
				if(jobs.get(i)==j)
				{
					return ""+jobs.get(i+1).profession+": " +jobs.get(i+1).year;
				}
				else
					return null;
			}
			return null;
			
				
			
		}
		
	}
	
	public Curriculum.Job addJob(String profession, int year)
	{
		Job j= new Job(profession, year);
		jobs.add(j);
		return j;
	}
	
	
	
}
