package pl.edu.agh.ask.sysinf;

import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import pl.edu.agh.ask.sysinf.model.PciDevice;
import java.awt.BorderLayout;

public class PciPanel extends JPanel {
	private static final long serialVersionUID = -5274381399627931917L;

	public PciPanel(LayoutManager layout) {
		super(layout);
		initPanel();
	}

	public PciPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initPanel();
	}

	public PciPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initPanel();
	}

	public PciPanel() {
		super();
		initPanel();
	}

	private void initPanel() {
		List<PciDevice> devices = new ArrayList<PciDevice>();
		try {
			Process proc = Runtime.getRuntime().exec("lspci -mm");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			Pattern p = Pattern
					.compile("(\\d+:\\d+.\\d+) \\\"([\\w\\s]+)\\\" \\\"([\\w\\s,\\.\\[\\]/]+)\\\" \\\"([\\w\\s,\\.\\[\\]/\\(\\)]+)\\\"(?: -r(\\d+))?(?: -p(\\d+))? \\\"([\\w\\s,-]*)\\\" \\\"([\\w\\s\\d]*)\\\"");
			String line;
			/*
			 * System.out.println("Lista urządzeń PCI"); int dev = 1;
			 */
			while ((line = reader.readLine()) != null) {
				Matcher m = p.matcher(line);
				if (m.matches()) {
					PciDevice device = new PciDevice(m.group(2), m.group(3),
							m.group(4));
					devices.add(device);
					/*
					 * System.out.println("-- Urządzenie: " + dev + " --");
					 * System.out.println("Coś1: " + m.group(1));
					 * System.out.println("Typ urządzenia: " + m.group(2));
					 * System.out.println("Producent: " + m.group(3));
					 * System.out.println("Nazwa urządzenia: " + m.group(4));
					 * System.out.println("Coś2: " + m.group(5));
					 * System.out.println("Coś3: " + m.group(6));
					 * System.out.println("Firma?: " + m.group(7));
					 * System.out.println("Coś4: " + m.group(8)); dev++;
					 */
				}
			}
			/*
			 * System.out.println("Koniec listy urządzeń PCI");
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[][] rows = new String[devices.size()][3];
		for (int i = 0; i < devices.size(); ++i) {
			PciDevice device = devices.get(i);
			rows[i][0] = device.getType();
			rows[i][1] = device.getCompany();
			rows[i][2] = device.getName();
		}
		setLayout(new BorderLayout(0, 0));

		JTable table = new JTable();
		table.setModel(new DefaultTableModel(rows, new String[] {
				"Typ urz\u0105dzenia", "Producent", "Nazwa urz\u0105dzenia" }) {
			private static final long serialVersionUID = 776143460408807841L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane);
	}
}
