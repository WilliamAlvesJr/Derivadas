import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Painel extends Window {
	JButton derivadas 			    = new JButton("Derivadas de uma variável");
	JButton derivadaVariasVariaveis = new JButton("Deriavada de varias variáveis");
	JButton gradiente				= new JButton("Gradiente");
	JButton hessiana 				= new JButton("Hessiana");
	JButton jacobiano 				= new JButton("Jacobiano");

	Painel(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new FlowLayout());
		jpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 100, 10));
		jpanel.add(derivadas);
		jpanel.add(derivadaVariasVariaveis);
		jpanel.add(gradiente);
		jpanel.add(hessiana);
		jpanel.add(jacobiano);
		
		this.add(jpanel);
		
		setSize(320, 180);
		setTitle("Derivadas");
		
		setVisible(true);
		
	}
}
