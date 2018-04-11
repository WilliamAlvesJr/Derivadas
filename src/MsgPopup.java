import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MsgPopup extends Window {
	JLabel msg1 = new JLabel("Atenção");
	JLabel msg2 = new JLabel("Valor inválido");
	JButton btn = new JButton("Ok");
	
	MsgPopup() {
		setTitle("Aviso");
		setSize(200, 120);
		setAlwaysOnTop(true);
		setLocation(50, 50);

		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		jpanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		jpanel.add(msg1, BorderLayout.NORTH);
		jpanel.add(msg2, BorderLayout.CENTER);
		jpanel.add(btn, BorderLayout.SOUTH);
		
		add(jpanel);
		
		setVisible(true);
	}
}
