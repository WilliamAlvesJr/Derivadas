package Telas;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Core.Window;


public class PainelDerivadaDeVariasVariaveis extends Window {
	public String DEFAULT_FUNC_MSG  = "Digite a função";
	public String DEFAULT_ERROR_MSG = "Digite o erro";
	public String DEFAULT_X_MSG     = "Digite os valores de x: ";
	
	public JButton derivar       = new JButton("Derivar");
	public JTextField func       = new JTextField(DEFAULT_FUNC_MSG);
	public JLabel d1             = new JLabel("f'(x): ");
	public JLabel d2             = new JLabel("f''(x): ");
	public JLabel eValue         = new JLabel("Erro: ");
	public JTextField erro       = new JTextField(DEFAULT_ERROR_MSG);
	public JLabel f        	  = new JLabel("f(x): ");
	public JScrollPane scrollBar = new JScrollPane();
	public JPanel jpanel         = new JPanel(new FlowLayout());
	public JLabel xInfo		  = new JLabel("INFO: Digite até 15 valores para x, separe cada valor por ';'");
	public JLabel xValue		  = new JLabel("x[i]");
	public JTextField x		  = new JTextField(DEFAULT_X_MSG);
	
	String[] columnNames = {"i",
	"x[i]"};
	
	public String [][] data = {
			{"",""}, {"",""}, {"",""}, {"",""}, {"",""}, {"",""}, {"",""}, {"",""},
			{"",""}, {"",""}, {"",""}, {"",""}, {"",""}, {"",""}, {"",""}
	};

	JTable table = new JTable(data,columnNames);
	
	public PainelDerivadaDeVariasVariaveis() {	

		table = new JTable(data,columnNames);
		scrollBar = new JScrollPane(table);
		
		this.setTitle("Deriavada de varias variáveis");
		this.setSize(480, 380);
		
		jpanel.add(f);
		jpanel.add(func);
		jpanel.add(eValue);
		jpanel.add(erro);
		jpanel.add(xInfo);
		jpanel.add(Box.createRigidArea(new Dimension(60, 0)));
		jpanel.add(xValue);
		jpanel.add(x);
		jpanel.add(derivar);
		jpanel.add(scrollBar);
		
		jpanel.add(scrollBar);
		getContentPane().add(jpanel);
		setVisible(true);
	}
	
	public void reescreveObjeto(Object[][] data, double d){
		jpanel.remove(scrollBar);
		table = new JTable(data, columnNames);
		scrollBar = new JScrollPane(table);
		jpanel.add(scrollBar);
		getContentPane().add(jpanel);
		setVisible(true);
	}
}
