import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelDerivadas extends Window {

	JButton derivar = new JButton("Derivar");
	JTextField func = new JTextField("Digite a função");
	JLabel d1       = new JLabel("f'(x): ");
	JLabel d2       = new JLabel("f''(x): ");
	JLabel eValue   = new JLabel("Erro: ");
	JTextField erro = new JTextField("Digite o erro");
	JLabel f        = new JLabel("f(x): ");
	JLabel xValue   = new JLabel("Valor de x: ");
	JTextField x 	= new JTextField("Digite o valor de x");
	
	PainelDerivadas(){
		
		setTitle("Derivadas de uma variável");
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, 3));
		jpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 100, 10));
		jpanel.add(f);
		jpanel.add(func);
		jpanel.add(xValue);
		jpanel.add(x);
		jpanel.add(eValue);
		jpanel.add(erro);
		jpanel.add(Box.createRigidArea(new Dimension(100, 50)));
		jpanel.add(derivar);
		jpanel.add(Box.createRigidArea(new Dimension(100, 50)));
		jpanel.add(d1);
		jpanel.add(d2);
		
		this.add(jpanel);
		
		setVisible(true);
	}
}
