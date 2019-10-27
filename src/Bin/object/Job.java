package Bin.object;

public class Job extends AbstractJob {
	private int priority;
	private int jobDuration;
	private int startDate;
	private int endDate;
	private int deadline;
	
	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	
	public int getJobPriority() {
		return priority;
	}
	
	public int getJobDuration() {
		return jobDuration;
	}
	
	@Override
	public int compareTo(Job job) {
		return Integer.compare(this.getJobDuration(), job.getJobDuration());
	}
	
	public Job(int jobPriority, int jobDuration, int deadline) {
		this.jobDuration = jobDuration;
		this.priority = jobPriority;
		this.deadline = deadline;
		this.startDate = 0;
		this.endDate = 0;
	}

}
