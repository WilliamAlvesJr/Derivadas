import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PainelDerivadaDeVariasVariaveis extends Window {
	JButton derivar = new JButton("Derivar");
	JTextField func = new JTextField("Digite a função");
	JLabel d1       = new JLabel("f'(x): ");
	JLabel d2       = new JLabel("f''(x): ");
	JLabel eValue   = new JLabel("Erro: ");
	JTextField erro = new JTextField("Digite o erro");
	JLabel f        = new JLabel("f(x): ");
	
	JTable table = new JTable(10,8);

	
	PainelDerivadaDeVariasVariaveis(){
		
		this.setTitle("Deriavada de varias variáveis");
		this.setSize(640, 300);
		JPanel jpanel = new JPanel(new FlowLayout());

		jpanel.add(f);
		jpanel.add(func);
		jpanel.add(eValue);
		jpanel.add(erro);
		jpanel.add(derivar);
		jpanel.add(Box.createRigidArea(new Dimension(100, 50)));

		jpanel.add(table);
		
		this.add(jpanel);
		
		setVisible(true);
	}
}
