package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Calculos.DerivadaDeNVariaveis;
import Telas.PainelDerivadaDeNVariaveis;

public class ActionsDerivadaNVariaveis extends PainelDerivadaDeNVariaveis {

	public ActionsDerivadaNVariaveis(){
		derivar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int i = 1;
				if(segunda.isSelected()) {
					for (Double d : new DerivadaDeNVariaveis().Derivadas(func.getText(), erro.getText(), 2, x.getText().split(";"))) {
						String partialFunc[] = func.getText().split(";");
						for (int j = 0; j < partialFunc.length; j++) {
							if(j > 0)
								partialFunc[j] = partialFunc[j-1]+partialFunc[j];
						}
						columnNames[1] = "f''(x[i])";
						data[i-1][0] = partialFunc[i-1];
						data[i-1][1] = "Valor: "+d;

						reescreveObjeto(data,d);
						i++;
					}
				} else {
					for (Double d : new DerivadaDeNVariaveis().Derivadas(func.getText(), erro.getText(), 1, x.getText().split(";"))) {
						String partialFunc[] = func.getText().split(";");
						for (int j = 0; j < partialFunc.length; j++) {
							if(j > 0)
								partialFunc[j] = partialFunc[j-1]+partialFunc[j];
						}
						columnNames[1] = "f'(x[i])";
						data[i-1][0] = partialFunc[i-1];
						data[i-1][1] = "Valor: "+d;

						reescreveObjeto(data,d);
						i++;
					}
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