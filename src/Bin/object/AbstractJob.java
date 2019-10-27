package Bin.object;

import java.util.UUID;

public abstract class AbstractJob implements JobInterface {

	private String id;
	
	public String getJobId() {
		return id;
	}
	
	public AbstractJob() {
		this.id =  UUID.randomUUID().toString();
	}
	
}
