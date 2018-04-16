package Telas;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PainelHessiana extends PainelDerivadaDeNVariaveis {
	public static final String DEFAULT_Y_MSG = "Digite os valores de y: ";
	
	public JScrollPane scrollPane;
	public JLabel yValue		  = new JLabel("y[i]");
	public JTextField y			  = new JTextField(DEFAULT_Y_MSG);
	
	public String[] columnNames = {
		"H[i,j]", "1", "2", "3", "4", "5", "6"
	};
	
	public String data[][] = {
			{"1", "", "", "", "", "", ""}, {"2", "", "", "", "", "", ""},
			{"3", "", "", "", "", "", ""}, {"4", "", "", "", "", "", ""},
			{"5", "", "", "", "", "", ""}, {"6", "", "", "", "", "", ""}
	};
	
	public JTable table = new JTable(data, columnNames);
	
	public PainelHessiana() {
		setTitle("Hessiana");
//		this.setSize(1200, 840);
		this.setSize(480, 235);
		xInfo.setText("INFO: Digite até 6 valores para x e para y, separe cada valor por ';'");
		
		jpanel.remove(segunda);
		jpanel.remove(super.scrollPane);
		
		jpanel.remove(derivar);
		
		jpanel.add(yValue);
		jpanel.add(y);
		
		jpanel.add(derivar);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(460, 118));
		
		jpanel.add(scrollPane);
		
		setVisible(true);	
	}
	
	public void reescreveObjeto(Object[][] data){
		jpanel.remove(scrollPane);
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(460, 118));
		jpanel.add(scrollPane);
		getContentPane().add(jpanel);
		setVisible(true);
	}
}
