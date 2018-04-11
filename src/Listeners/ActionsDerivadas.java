package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Calculos.Deriva;
import Calculos.DerivaNVezes;
import Telas.PainelDerivadas;

public class ActionsDerivadas extends PainelDerivadas {
	
	ActionsDerivadas(){
		derivar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				d1.setText("f'(x) : "+new Deriva().Deriva(func.getText(), x.getText(), erro.getText()));
				d2.setText("f''(x) : "+new DerivaNVezes().DerivaNVezes(func.getText(), x.getText(), erro.getText()));
				func.setText(DEFAULT_FUNC_MSG);
				erro.setText(DEFAULT_ERROR_MSG);
				x.setText(DEFAULT_X_MSG);
				grau.setText(DEFAULT_X_MSG);
				setVisible(true);
			} 
		});
		
		grau.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				grau.selectAll();
			}
		});
		
		func.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				func.selectAll();
			}
		});
		
		x.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				x.selectAll();
			}
		});
		
		erro.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				erro.selectAll();
			}
		});
	}
}