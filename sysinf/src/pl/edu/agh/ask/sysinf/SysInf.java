package pl.edu.agh.ask.sysinf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import org.hyperic.sigar.Sigar;

public class SysInf extends JFrame {
	private static final long serialVersionUID = -326403577850794010L;
	private Sigar sigar;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SysInf frame = new SysInf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SysInf() {
		sigar = new Sigar();
		setTitle("Informacje o systemie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new MemoryPanel(sigar);
		tabbedPane.addTab("Pamięć", null, panel_1, null);

		JPanel panel_2 = new ProcPanel(sigar);
		tabbedPane.addTab("Procesor", null, panel_2, null);
		
		JPanel panel_3 = new InterfacePanel(sigar);
		tabbedPane.addTab("Interfejsy", null, panel_3, null);
		
		JPanel panel_4 = new DiscPanel(sigar);
		tabbedPane.addTab("Dysk", null, panel_4, null);
		
		JPanel panel_5 = new UsbPanel();
		tabbedPane.addTab("Usb", null, panel_5, null);
		
		JPanel pciPanel = new PciPanel();
		tabbedPane.addTab("Urządzenia PCI", null, pciPanel, null);
	}

	public static String toHumanReadable(long bytes) {
		String[] units = new String[] { "B", "kB", "MB", "GB", "TB", "PB",
				"EB", "ZB", "YB" };
		float value = (float) bytes;
		for (int i = 0; i < units.length; i++) {
			if (value <= 1024.0f) {
				return Float.toString(value) + " " + units[i];
			}
			value /= 1024.0f;
		}
		return Float.toString(value) + " " + units[units.length - 1];
	}
}
