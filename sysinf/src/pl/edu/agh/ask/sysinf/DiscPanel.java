package pl.edu.agh.ask.sysinf;

import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.hyperic.sigar.DiskUsage;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class DiscPanel extends JPanel {

	private static final long serialVersionUID = 5349271779454888438L;
	private Sigar sigar;

	private JLabel lblPojemnoscWart = new JLabel(" ");
	private JLabel lblInterface2;
	private JLabel lblInterface3;

	public DiscPanel() {
		super();
		initPanel();
	}

	public DiscPanel(LayoutManager layout) {
		super(layout);
		initPanel();
	}

	public DiscPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initPanel();
	}

	public DiscPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initPanel();
	}

	public DiscPanel(Sigar sigar) {
		super();
		this.sigar = sigar;

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

		JLabel lblPojemnosc = new JLabel("Pojemność:");
		add(lblPojemnosc, "2, 2");
		lblPojemnoscWart = new JLabel("%");
		add(lblPojemnoscWart, "4, 2");

		JLabel lblPojemnosc2 = new JLabel("Dostepne:");
		add(lblPojemnosc2, "2, 4");
		lblInterface2 = new JLabel("%");
		add(lblInterface2, "4, 4");

		JLabel lblUzycieProcesoralbla = new JLabel("Użyte:");
		add(lblUzycieProcesoralbla, "2, 6");
		lblInterface3 = new JLabel("%");
		add(lblInterface3, "4, 6");
	}

	private void updateData() {
		try {
			//dalej nie działa
			// String dirName = "C:\\";
			FileSystemUsage f = sigar.getFileSystemUsage("/dev/sda");
			float fTotal = f.getTotal();
			long fAvail = f.getAvail();
			long fUsed = f.getUsed();
			DiskUsage disc = new DiskUsage();
			disc.gather(sigar, "/dev/sda");

			lblPojemnoscWart.setText(fTotal + " ");
			lblInterface2.setText(fAvail + " ");
			lblInterface3.setText(fUsed + " ");
			//System.out.println("info: " + disc.getReadBytes());
			// lblInterface1.setText(Double.toString(fUsed));
			 // For Disk
	       /* System.out.println("-----Disk Info-----");
	        FileSystem fileSystemList[] = sigar.getFileSystemList();
	        for (int s = 0; s < fileSystemList.length; s++) {
	            String devName = fileSystemList[s].getDevName();
	            int devType = fileSystemList[s].getType();
	            //Only get the physical disk
	            if (devType == FileSystem.TYPE_LOCAL_DISK) {
	                System.out.println("Disk " + devName);
	                System.out.println(sigar.getDirUsage(devName));
	                System.out.println(sigar.getDiskUsage(devName));
	                System.out.println(sigar.getFileSystemUsage(devName));
	            }
	        }*/
		} catch (SigarException e) {
		}
	}
}
