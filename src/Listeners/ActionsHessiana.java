package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Calculos.DerivadaDeDuasVariaveis;
import Telas.PainelHessiana;

public class ActionsHessiana extends PainelHessiana {
	
	ActionsHessiana(){
		derivar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Object[][] d = new DerivadaDeDuasVariaveis().DerivadasXY(func.getText(), erro.getText(), 
						x.getText().split(";"), y.getText().split(";"));
				
						reescreveObjeto(d);
				
				
				func.setText(DEFAULT_FUNC_MSG);
				erro.setText(DEFAULT_ERROR_MSG);
				x.setText(DEFAULT_X_MSG);
				y.setText(DEFAULT_Y_MSG);
				setVisible(true);
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
		
		y.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) {
				y.selectAll();
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