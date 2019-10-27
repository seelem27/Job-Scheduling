package Bin.scheduling;

import java.util.ArrayList;

import Bin.Worker;
import Bin.object.Job;
public class SampleData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Arraylist to store all workers
		ArrayList<Worker> workerlist = new ArrayList<Worker>();
		
		//Arraylist to store all jobs
		ArrayList<Job> joblist = new ArrayList<Job>();
		
		//ArrayList to store unassigned jobs
		ArrayList<Job> unassignedJoblist = new ArrayList<Job>();
		
		//Worker sample data
		Worker w1 = new Worker("See Lem", 40);
		Worker w2 = new Worker("Jia Yong", 40);
		Worker w3 = new Worker("John", 40);
		Worker w4 = new Worker("Dheeno", 40);
		
		workerlist.add(w1);
		workerlist.add(w2);
		workerlist.add(w3);
		workerlist.add(w4);
		
		//Jobs sample data
		
		Job j1 = new Job(10, 5, 20);
		Job j2 = new Job(5, 4, 30);
		Job j3 = new Job(1, 5, 40);
		Job j4 = new Job(10, 5, 20);
		Job j5 = new Job(10, 3, 40);
		Job j6 = new Job(10, 5, 20);
		Job j7 = new Job(10, 5, 20);
		Job j8 = new Job(10, 5, 20);
		Job j9 = new Job(10, 5, 20);
		Job j10 = new Job(10, 5, 20);
		Job j11 = new Job(10, 5, 20);
		Job j12 = new Job(10, 5, 20);
		Job j13 = new Job(10, 5, 20);
		Job j14 = new Job(10, 5, 20);
		Job j15 = new Job(10, 5, 20);
		Job j16 = new Job(10, 5, 20);
		Job j17 = new Job(5, 6, 10);
		
		joblist.add(j1);
		joblist.add(j2);
		joblist.add(j3);
		joblist.add(j4);
		joblist.add(j5);
		joblist.add(j6);
		joblist.add(j7);
		joblist.add(j8);
		joblist.add(j9);
		joblist.add(j10);
		joblist.add(j11);
		joblist.add(j12);
		joblist.add(j13);
		joblist.add(j14);
		joblist.add(j15);
		joblist.add(j16);
		joblist.add(j17);
		
		
		Job aJob = null;
		
		for(int i = 0; i < joblist.size(); i++) {
			aJob = joblist.get(i);
			
			if(!addJobToWorker(workerlist, aJob)) {
				unassignedJoblist.add(aJob);
			}
			
		}
		
		int priorities = 0;
		
		System.out.println("\n--------- Worker Schedule --------- ");
		for(Worker aWorker: workerlist) {
			priorities = 0;
			System.out.println("\nName:  "   + aWorker.getWorkerName());
			for (Job job : aWorker.getJobList()) {
				priorities = priorities + job.getJobPriority();
				System.out.print("Job: " + job.getJobId() + " \tStart:"   + job.getStartDate() + " \tEnd: " + job.getEndDate() + " ");
				System.out.println();
			}
			System.out.println("Total Priority Index: " + priorities);
		}
		
		System.out.println("\nUnassigned Jobs");
		for (Job uAJob : unassignedJoblist) {
			System.out.println("Job:  "   + uAJob.getJobId());
			System.out.println();
		}
		
		
	}
	
	public static boolean addJobToWorker(ArrayList<Worker> wList, Job job) {
		
		Worker worker = null;
		
		for(int i=0; i < wList.size(); i++) {
			worker = wList.get(i);
			
			if(worker.addJob(job)) {
				return true;
			}
		}
		
		return false;
	}

}
