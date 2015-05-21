package pl.edu.agh.ask.sysinf.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.edu.agh.ask.sysinf.model.Disc;
import pl.edu.agh.ask.sysinf.model.DiscInfo;
import pl.edu.agh.ask.sysinf.model.Partition;

public class DiscInfoFactory {

	private static DiscInfoFactory instance;

	public static synchronized DiscInfoFactory getInstance() {
		if (instance == null) {
			instance = new DiscInfoFactory();
		}
		return instance;
	}

	private DiscInfoFactory() {
	}

	public DiscInfo getDiscInfo() {
		DiscInfo di = new DiscInfo();
		try {
			Process proc = Runtime.getRuntime().exec("fdisk -l");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			Pattern disc_p = Pattern
					.compile("^Disk\\s([\\w/]+):\\s.*,\\s(\\d+)\\sbytes");
			Pattern sect_p = Pattern
					.compile("^Sector size\\s.*:\\s(\\d+)\\sbytes.*");
			Pattern iden_p = Pattern.compile("^Disk identifier:\\s(\\w+)");
			Pattern part_p = Pattern
					.compile("^([\\w/]+)\\s+(\\*)?\\s+(\\d+)\\s+(\\d+)\\s+([\\d]+)\\+?\\s+(\\w+)\\s+(.*)$");
			String line;
			Disc disc = null;
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				Matcher m = disc_p.matcher(line);
				if (m.matches()) {
					if (disc != null) {
						di.setDisc(disc);
					}
					disc = new Disc();
					disc.setDevice(m.group(1));
					disc.setSize(Long.parseLong(m.group(2)));
					continue;
				}
				m = sect_p.matcher(line);
				if (m.matches()) {
					disc.setSectorSize(Integer.parseInt(m.group(1)));
					continue;
				}
				m = iden_p.matcher(line);
				if (m.matches()) {
					disc.setId(m.group(1));
					continue;
				}
				m = part_p.matcher(line);
				if (m.matches()) {
					boolean boot = "*".equals(m.group(2));
					Partition partition = new Partition(m.group(1), boot,
							Integer.parseInt(m.group(3)), Integer.parseInt(m
									.group(4)), Integer.parseInt(m.group(5)),
							m.group(6), m.group(7));
					disc.setPartition(partition);
				}
			}
			if (disc != null) {
				di.setDisc(disc);
			}
		} catch (IOException e) {
			System.out.println("Bład 444");
			e.printStackTrace();
		}
		return di;
	}
}
