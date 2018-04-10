import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTable;

public class ActionsDerivadaVariasVariaveis extends PainelDerivadaDeVariasVariaveis {
	
	ActionsDerivadaVariasVariaveis(){
		derivar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int i = 1;
				for (Double d : new DerivadaDeVariasVariaveis().Derivadas(func.getText(), erro.getText(), x.getText().split(";"))) {
					data[i-1][0] = "Iteração número: "+i;
					data[i-1][1] = "Valor: "+d;

					reescreveObjeto(data,d);
					i++;

				}
				func.setText(DEFAULT_FUNC_MSG);
				erro.setText(DEFAULT_ERROR_MSG);
				x.setText(DEFAULT_X_MSG);
				setVisible(true);
			} 
		});
		
		
		func.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				func.selectAll();
			}
		});
		
		erro.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				erro.selectAll();
			}
		});
		
		x.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				x.selectAll();
			}
		});
	}
}