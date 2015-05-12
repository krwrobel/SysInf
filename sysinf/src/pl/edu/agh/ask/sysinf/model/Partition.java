package pl.edu.agh.ask.sysinf.model;

public class Partition {

	private String device;
	private boolean boot;
	private long start;
	private long end;
	private long blocks;
	private String id;
	private String system;

	public Partition() {
	}

	public Partition(String device, boolean boot, long start, long end,
			long blocks, String id, String system) {
		this.device = device;
		this.boot = boot;
		this.start = start;
		this.end = end;
		this.blocks = blocks;
		this.id = id;
		this.system = system;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public boolean getBoot() {
		return boot;
	}

	public void setBoot(boolean boot) {
		this.boot = boot;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public long getBlocks() {
		return blocks;
	}

	public void setBlocks(long blocks) {
		this.blocks = blocks;
	}

	public String getId() {
		return id;
	}

	public void setString(String id) {
		this.id = id;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}
}
