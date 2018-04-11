package Telas;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.Window;

public class PainelDerivadas extends Window {
	
	public static final String   DEFAULT_FUNC_MSG  = "Digite a função";
	public static final String   DEFAULT_ERROR_MSG = "Digite o erro";
	public static final String   DEFAULT_X_MSG     = "Digite o valor de x";
	public static final String[] GRAU_VALUE        = {"1","2","3","4"};
	
	public JButton derivar 	   = new JButton("Derivar");
	public JTextField func 	   = new JTextField(DEFAULT_FUNC_MSG);
	public JLabel res     	   = new JLabel("f^n(x): ");
	public JLabel eValue 	   = new JLabel("Erro: ");
	public JTextField erro 	   = new JTextField(DEFAULT_ERROR_MSG);
	public JLabel f      	   = new JLabel("f(x): ");
	public JLabel xValue 	   = new JLabel("Valor de x: ");
	public JTextField x 	   = new JTextField(DEFAULT_X_MSG);
	public JLabel grauValue    = new JLabel("Escolha o grau da derivada");
	public JComboBox grau	   = new JComboBox(GRAU_VALUE);

	public PainelDerivadas(){
		
		setTitle("Derivadas de uma variável");
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, 3));
		jpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 100, 10));
		jpanel.add(f);
		jpanel.add(func);
		jpanel.add(grauValue);
		jpanel.add(grau);
		jpanel.add(xValue);
		jpanel.add(x);
		jpanel.add(eValue);
		jpanel.add(erro);
		jpanel.add(Box.createRigidArea(new Dimension(100, 25)));
		jpanel.add(Box.createRigidArea(new Dimension(100, 25)));
		jpanel.add(derivar);
		jpanel.add(Box.createRigidArea(new Dimension(100, 25)));
		jpanel.add(res);
		
		this.add(jpanel);
		
		setVisible(true);
	}
}
