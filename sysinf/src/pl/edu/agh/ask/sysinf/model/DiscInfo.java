package pl.edu.agh.ask.sysinf.model;

import java.util.ArrayList;
import java.util.List;

public class DiscInfo {

	private List<Disc> discs;

	public DiscInfo() {
		this.discs = new ArrayList<Disc>();
	}

	public DiscInfo(List<Disc> discs) {
		this.discs = discs;
	}

	public List<Disc> getDiscs() {
		return discs;
	}

	public int getDiscCount() {
		return discs.size();
	}

	public Disc getDisc(int index) {
		return discs.get(index);
	}

	public void setDisc(Disc disc) {
		this.discs.add(disc);
	}
}
