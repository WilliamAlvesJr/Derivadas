import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions extends Painel {

	Actions(){
			derivadaVariasVariaveis.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					new ActionsDerivadaVariasVariaveis();

				} 
			});

			derivadas.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					new ActionsDerivadas();
				} 
			});
	}
}