package pl.edu.agh.ask.sysinf;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import pl.edu.agh.ask.antlr.HelloBaseListener;
import pl.edu.agh.ask.antlr.HelloLexer;
import pl.edu.agh.ask.antlr.HelloParser;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class UsbPanel extends JPanel {
	int x = 0;
	static DefaultTableModel model = new DefaultTableModel(); 
	JTable table = new JTable(model); 
	
	public class LsusbParser extends HelloBaseListener {

		@Override
		public void enterThis(@NotNull HelloParser.ThisContext ctx) {
			// Tutaj wypisuje pokolei nazwy portów usb
			// Ewentualnie można wyciągnać inne dane jak trzeba będzie
			//System.out.println("Port Usb " + ctx.getText());
			x++;
			model.addRow(new Object[]{"Port "+ x, ctx.getText()});
		}

	}

	private static final long serialVersionUID = 5349271779454888438L;
	private	JScrollPane scrollPane;
	//private JLabel lblPojemnoscWart = new JLabel(" ");
	//private JLabel lblInterface2;
	//private JLabel lblInterface3;

	public UsbPanel(LayoutManager layout) {
		super(layout);
		initPanel();
	}

	public UsbPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initPanel();
	}

	public UsbPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initPanel();
	}

	public UsbPanel() {
		super();

		initPanel();
		//updateData();

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
	
		ANTLRInputStream input;
		String command = "lsusb";

		Process proc = null;
		try {
			proc = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			System.out.println("Nie odebrano");
			e.printStackTrace();
		}

		// Read the output

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				proc.getInputStream()));

		String line = "";
		String enter = "";
		try {
			while ((line = reader.readLine()) != null) {
				enter += line + '\n';
			}
		} catch (IOException e) {
			System.out.println("Nie wyswietlono");
			e.printStackTrace();
		}

		// System.out.println(enter);
		input = new ANTLRInputStream(enter);

		HelloLexer lexer = new HelloLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HelloParser parser = new HelloParser(tokens);
		ParseTree tree = parser.input();
		// System.out.println(tree.toStringTree(parser));
		ParseTreeWalker walker = new ParseTreeWalker();
		System.out.println("Urządzenia na portach usb");
		
		model.addColumn("Port Nr"); 
		model.addColumn("Nazwa"); 

		
		walker.walk(new LsusbParser(), tree);
		
				
				// Add the table to a scrolling pane
				scrollPane = new JScrollPane( table );
				add( scrollPane, BorderLayout.CENTER );

	}

	private void updateData() {
;

	}
}
