package Bin;

import java.util.LinkedList;

import Bin.object.Job;

public class Worker extends AbstractWorker {
	
	private LinkedList<Job> jobList;
	private int hoursRemaining;

	public Worker(String name, int hours) {
		super(name, hours);
		jobList = new LinkedList<Job>();
		hoursRemaining = hours;
	}
	
	public int getHoursRemaining() {
		return hoursRemaining;
	}
	
	public LinkedList<Job> getJobList(){
		return jobList;
	}
	
	public int getTaskCount() {
		return jobList.size();
	}
	
	public boolean addJob(Job job) {
		
		//joblist is empty
		if(jobList.isEmpty()) {
			jobList.addFirst(job);
			job.setStartDate(0);
			job.setEndDate(job.getStartDate() + job.getJobDuration());
			return true;
		}
		
		//add infront of the list
		System.out.println("Trying to add at the front . . .");
		Job firstJob = jobList.getFirst();
		int period = firstJob.getStartDate();
		
		if(firstJob.getStartDate() != 0 && job.getJobDuration() <= period && job.getDeadline() >= (0 + job.getJobDuration())){
			jobList.addFirst(job);
			job.setStartDate(0);
			job.setEndDate(job.getStartDate() + job.getJobDuration());
			return true;
		}
		
		//add in between
		if(jobList.size() >= 2) {
			Job first = null;
			Job second = null;
			
			for(int i = 0; i < jobList.size() - 1; i++) {
				first = jobList.get(i);
				second = jobList.get(1);
				period = second.getStartDate() - first.getEndDate();
				
				if(job.getJobDuration() <= period && job.getDeadline() >= (first.getEndDate() + job.getJobDuration())) {
					jobList.add(i, job);
					job.setStartDate(first.getEndDate());
					job.setEndDate(job.getStartDate() + job.getJobDuration());
					return true;
				}
			}
		}
		System.out.println("Trying to add at the end . . .");
		//add at the end of the list
		Job lastJob = jobList.getLast();
		
		period = 40 - lastJob.getEndDate();
		
		if(job.getJobDuration() <= period && job.getDeadline() >= (lastJob.getEndDate() + job.getJobDuration())) {
			jobList.addLast(job);
			job.setStartDate(lastJob.getEndDate());
			job.setEndDate(job.getStartDate() + job.getJobDuration());
			return true;
		}
		
		return false;
		
	}
	
	public double getWorkerUtilization() {
		double hoursRemaining = getHoursRemaining();
		double totalWorkingHours = getWorkingHours();
		
		return hoursRemaining/totalWorkingHours;
	}
	
	@Override
	public int compareTo(Worker worker) {
		return Integer.compare(this.getHoursRemaining(), worker.getHoursRemaining());
	}

}
