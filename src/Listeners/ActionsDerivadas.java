package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Calculos.Deriva;
import Telas.PainelDerivadas;

public class ActionsDerivadas extends PainelDerivadas {
	
	ActionsDerivadas(){
		derivar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int g = grau.getSelectedIndex()+1;
				if(g > 1)
					if(g == 2)
						res.setText("f''(x) : "+new Deriva().Derivar(func.getText(), x.getText(), erro.getText(), g));
					else if(g == 3)
						res.setText("f'''(x) : "+new Deriva().Derivar(func.getText(), x.getText(), erro.getText(), g));
					else 
						res.setText("f''''(x) : "+new Deriva().Derivar(func.getText(), x.getText(), erro.getText(), g));
				else 
					res.setText("f'(x) : "+new Deriva().Derivar(func.getText(), x.getText(), erro.getText(), g));
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