package pl.edu.agh.ask.sysinf;

import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;

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
		try {
			Process proc = Runtime.getRuntime().exec("lspci -mm");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			Pattern p = Pattern
					.compile("(\\d+:\\d+.\\d+) \\\"([\\w\\s]+)\\\" \\\"([\\w\\s,\\.\\[\\]/]+)\\\" \\\"([\\w\\s,\\.\\[\\]/\\(\\)]+)\\\"(?: -r(\\d+))?(?: -p(\\d+))? \\\"([\\w\\s,-]*)\\\" \\\"([\\w\\s\\d]*)\\\"");
			String line;
			System.out.println("Lista urządzeń PCI");
			int dev = 1;
			while ((line = reader.readLine()) != null) {
				Matcher m = p.matcher(line);
				if (m.matches()) {
					System.out.println("-- Urządzenie: " + dev + " --");
					System.out.println("Coś1: " + m.group(1));
					System.out.println("Typ urządzenia: " + m.group(2));
					System.out.println("Producent: " + m.group(3));
					System.out.println("Nazwa urządzenia: " + m.group(4));
					System.out.println("Coś2: " + m.group(5));
					System.out.println("Coś3: " + m.group(6));
					System.out.println("Firma?: " + m.group(7));
					System.out.println("Coś4: " + m.group(8));
					dev++;
				}
			}
			System.out.println("Koniec listy urządzeń PCI");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
