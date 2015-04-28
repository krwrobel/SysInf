package pl.edu.agh.ask.sysinf;

import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MemoryPanel extends JPanel {
	private static final long serialVersionUID = -5274381399627931917L;

	private Sigar sigar;
	private Mem mem;

	private JLabel lblCakowitaPamiecRamWartosc;
	private JLabel lblWolnaPamiecRamWartosc;
	private JLabel lblZajetaPamiecRamWartosc;

	public MemoryPanel() {
		super();
		initPanel();
	}

	public MemoryPanel(LayoutManager layout) {
		super(layout);
		initPanel();
	}

	public MemoryPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initPanel();
	}

	public MemoryPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initPanel();
	}

	public MemoryPanel(Sigar sigar) {
		super();
		this.sigar = sigar;
		this.mem = new Mem();

		initPanel();
		updateData();

		Thread updater = new Thread() {
			@Override
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				updateData();
			}
		};
		updater.start();
	}

	private void initPanel() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblCakowitaPamiecRam = new JLabel("Całkowita pamięć RAM:");
		add(lblCakowitaPamiecRam, "2, 2");
		lblCakowitaPamiecRamWartosc = new JLabel("%");
		add(lblCakowitaPamiecRamWartosc, "4, 2");

		JLabel lblWolnaPamiecRam = new JLabel("Wolna pamięć RAM:");
		add(lblWolnaPamiecRam, "2, 4");
		lblWolnaPamiecRamWartosc = new JLabel("%");
		add(lblWolnaPamiecRamWartosc, "4, 4");

		JLabel lblZajetaPamiecRam = new JLabel("Zajęta pamięć RAM:");
		add(lblZajetaPamiecRam, "2, 6");
		lblZajetaPamiecRamWartosc = new JLabel("%");
		add(lblZajetaPamiecRamWartosc, "4, 6");
	}

	private void updateData() {
		try {
			mem.gather(sigar);
			String totalHR = SysInf.toHumanReadable(mem.getTotal());
			String freeHR = SysInf.toHumanReadable(mem.getActualFree());
			String usedHR = SysInf.toHumanReadable(mem.getActualUsed());

			String freePerc = Float
					.toString(((float) mem.getActualFree() / (float) mem
							.getTotal()) * 100);
			String usedPerc = Float
					.toString(((float) mem.getActualUsed() / (float) mem
							.getTotal()) * 100);

			lblCakowitaPamiecRamWartosc.setText(totalHR);
			lblWolnaPamiecRamWartosc.setText(freeHR + " (" + freePerc + " %)");
			lblZajetaPamiecRamWartosc.setText(usedHR + " (" + usedPerc + " %)");
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}
}
