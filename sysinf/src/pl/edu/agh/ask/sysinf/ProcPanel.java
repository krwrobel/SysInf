package pl.edu.agh.ask.sysinf;

import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.ResourceLimit;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ProcPanel extends JPanel {
	

	private static final long serialVersionUID = 5349271779454888438L;
	private Sigar sigar;
	private ResourceLimit  rl;
	private CpuPerc cpuperc;
	
	private JLabel lblProcesorInformcje;
	private JLabel lblUzycieProcesora;
	

	public ProcPanel() {
		super();
		initPanel();
	}

	public ProcPanel(LayoutManager layout) {
		super(layout);
		initPanel();
	}

	public ProcPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initPanel();
	}

	public ProcPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initPanel();
	}

	public ProcPanel(Sigar sigar) {
		super();
		this.sigar = sigar;
		this.rl = new ResourceLimit();

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

		JLabel lblProcesorInformacjelbl = new JLabel("Moc procesora:");
		add(lblProcesorInformacjelbl, "2, 2");
		lblProcesorInformcje = new JLabel("%");
		add(lblProcesorInformcje, "4, 2");

		JLabel lblUzycieProcesoralbl = new JLabel("Użycie procesora");
		add(lblUzycieProcesoralbl, "2, 4");
		lblUzycieProcesora = new JLabel("%");
		add(lblUzycieProcesora, "4, 4");

	}

	private void updateData() {
		try {
			cpuperc = sigar.getCpuPerc();
			rl.gather(sigar);
			Cpu[] lol = sigar.getCpuList();
			String useProcent =Double.toString( cpuperc.getCombined()*100);
			String maxCpu = SysInf.toHumanReadable(rl.getCpuMax());
			

			

			lblUzycieProcesora.setText(useProcent +"%");
			lblProcesorInformcje.setText(lol.length +"x"+maxCpu);
			
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}
}
