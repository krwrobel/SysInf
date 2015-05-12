package pl.edu.agh.ask.sysinf.model;

import java.util.ArrayList;
import java.util.List;

public class Disc {

	private String device;
	private long size;
	private long sectorSize;
	private String id;
	private List<Partition> partitions;

	public Disc() {
		partitions = new ArrayList<Partition>();
	}

	public Disc(String device, long size, int sectorSize, String id,
			List<Partition> partitions) {
		this.device = device;
		this.size = size;
		this.sectorSize = sectorSize;
		this.id = id;
		this.partitions = partitions;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getSectorSize() {
		return sectorSize;
	}

	public void setSectorSize(long sectorSize) {
		this.sectorSize = sectorSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(List<Partition> partitions) {
		this.partitions = partitions;
	}

	public int getPartitionCount() {
		return partitions.size();
	}

	public Partition getPartition(int index) {
		return partitions.get(index);
	}

	public void setPartition(Partition partition) {
		partitions.add(partition);
	}
}
