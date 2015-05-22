package pl.edu.agh.ask.sysinf;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.hyperic.sigar.DiskUsage;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import pl.edu.agh.ask.sysinf.model.Disc;
import pl.edu.agh.ask.sysinf.model.DiscInfo;
import pl.edu.agh.ask.sysinf.model.Partition;
import pl.edu.agh.ask.sysinf.provider.DiscInfoFactory;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class DiscPanel extends JPanel {

	private static final long serialVersionUID = 5349271779454888438L;
	static DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	private JScrollPane scrollPane;
	private DiscInfo di;

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
		// this.sigar = sigar;

		initPanel();
		// updateData();

		Thread updater = new Thread() {
			@Override
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// updateData();
			}
		};
		updater.start();
	}

	private void initPanel() {

		DiscInfoFactory dif = DiscInfoFactory.getInstance();
		di = dif.getDiscInfo();
		if (di.getDiscCount() != 0) {

			// Dodawanie informacji na temat dysków
			model.addColumn("Dysk");
			model.addColumn("Rozmiar");
			for (int i = 0; i < di.getDiscCount(); i++) {
				int size = (int) (di.getDisc(i).getSize() / 1000000000);
				model.addRow(new Object[] { "Dysk " + i, size + "GB" });
			}
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			table.setFillsViewportHeight(true);
			scrollPane = new JScrollPane(table);
			scrollPane.setSize(60, 100);
			add(scrollPane, BorderLayout.NORTH);

			model = new DefaultTableModel();
			table = new JTable(model);
			model.addColumn("Partycja");
			model.addColumn("Rozmiar");
			model.addColumn("   Format    ");
			Disc dysk;
			for (int i = 0; i < di.getDiscCount(); i++) {
				dysk = di.getDisc(i);
				for (int j = 0; j < dysk.getPartitionCount(); j++) {
					Partition p = dysk.getPartition(j);
					double size = new Double(((double) p.getBlocks() * (double) dysk
							.getSectorSize()) / (double) dysk.getSize());
					int sizeint = (int) (size*100);
					model.addRow(new Object[] {
							"Partycja " + (j + 1),
							sizeint/100
									+ "GB", p.getSystem() });
				}
			}
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			table.setFillsViewportHeight(true);
			scrollPane = new JScrollPane(table);
			scrollPane.setSize(60, 100);
			add(scrollPane, BorderLayout.NORTH);

			Disc disc = di.getDisc(0);
			if (disc.getPartitionCount() != 0) {
				DefaultPieDataset dataset = new DefaultPieDataset();
				for (Partition p : disc.getPartitions()) {
					dataset.setValue(
							p.getSystem(),
							new Double(((double) p.getBlocks() * (double) disc
									.getSectorSize()) / (double) disc.getSize()));
				}
				JFreeChart chart = ChartFactory.createPieChart(
						disc.getDevice(), dataset, true, true, false);
				PiePlot plot = (PiePlot) chart.getPlot();
				plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
				plot.setNoDataMessage("No data available");
				plot.setCircular(false);
				plot.setLabelGap(0.02);
				ChartPanel chartPanel = new ChartPanel(chart);
				add(chartPanel, "6, 10, fill, fill");
			}
		} else
			System.out.println("Brak dysków");
	}

}
