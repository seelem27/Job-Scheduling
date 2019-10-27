package Bin;

import java.util.UUID;

public abstract class AbstractWorker implements WorkerBin {

	private String workerId;
	private String name;
	private int workingHours;
	
	public AbstractWorker(String name, int hours) {
		this.workerId =  UUID.randomUUID().toString();
		this.workingHours = hours;
		this.name = name;
	}
	
	public String getWorkerId() {
		return this.workerId;
	}
	
	public String getWorkerName() {
		return this.name;
	}
	
	public int getWorkingHours() {
		return this.workingHours;
	}
	
	
}
