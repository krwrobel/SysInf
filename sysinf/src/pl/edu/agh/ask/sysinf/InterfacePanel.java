package pl.edu.agh.ask.sysinf;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import pl.edu.agh.ask.sysinf.UsbPanel.LsusbParser;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class InterfacePanel extends JPanel {
	

	private static final long serialVersionUID = 5349271779454888438L;
	private Sigar sigar;	
	private String[] interfaceList; 
	private	JScrollPane scrollPane;
	static DefaultTableModel model = new DefaultTableModel(); 
	JTable table = new JTable(model); 
	
	//private JLabel lblInterface1 = new JLabel(" ");
	//private JLabel lblInterface2 = new JLabel(" ");
	//private JLabel lblInterface3 =new JLabel(" ");
	

	public InterfacePanel() {
		super();
		initPanel();
	}

	public InterfacePanel(LayoutManager layout) {
		super(layout);
		initPanel();
	}

	public InterfacePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initPanel();
	}

	public InterfacePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initPanel();
	}

	public InterfacePanel(Sigar sigar) {
		super();
		this.sigar = sigar;

		initPanel();
	//	updateData();

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

		model.addColumn("Nazwa"); 
		model.addColumn("Adres"); 
		model.addColumn("Maska"); 
		
		
		
				
				// Add the table to a scrolling pane
			;
		try {
			interfaceList = sigar.getNetInterfaceList();
		
			System.out.println("Szczegóły Interfejsów:");
			for(String s:interfaceList){
				 NetInterfaceConfig config = sigar.getNetInterfaceConfig(s);
				 model.addRow(new Object[]{config.getName(), config.getAddress(),config.getNetmask()});
				// System.out.println(config.getName());
				// System.out.println(config.getAddress());
				// System.out.println(config.getNetmask());
			}
			
		/*	System.out.println("-----Network Info-----");
	        System.out.println(sigar.getNetInfo());
	        NetStat thisNetState = sigar.getNetStat();
	        System.out.println("in-bound " + thisNetState.getAllInboundTotal()
	                + " out-bound " + thisNetState.getAllOutboundTotal());
	      */
			scrollPane = new JScrollPane( table );
			add( scrollPane, BorderLayout.CENTER );
		} catch (SigarException e) {
			e.printStackTrace();
		}
	/*	setLayout(new FormLayout(
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

		JLabel lblUzycieProcesoralbl = new JLabel("Interfejsy:");
		add(lblUzycieProcesoralbl, "2, 1");
		lblInterface1 = new JLabel("%");
		add(lblInterface1, "2, 3");
		
		lblInterface2 = new JLabel("%");
		add(lblInterface2, "2, 5");
		
		lblInterface3 = new JLabel("%");
		add(lblInterface3, "2, 6");
		*/

	}

	private void updateData() {
	
	}
}
