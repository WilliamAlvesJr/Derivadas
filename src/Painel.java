import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Painel extends Window {
	JButton derivadas 			    = new JButton("Derivadas de uma variável");
	JButton derivadaVariasVariaveis = new JButton("Deriavada de varias variáveis");

	Painel(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new FlowLayout());
		jpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 100, 10));
		jpanel.add(derivadaVariasVariaveis);
		jpanel.add(derivadas);
		
		this.add(jpanel);
		
		setSize(320, 200);
		setTitle("Derivadas");
		
		setVisible(true);
		
	}
}
