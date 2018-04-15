package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Calculos.Gradiente;
import Telas.PainelGradiente;

public class ActionsGradiente extends PainelGradiente {

	public ActionsGradiente() {
		derivar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				int j = 'i';
				for (Double d : new Gradiente().Derivadas(func.getText(), erro.getText(), x.getText().split(";"))) {
					String partialFunc[] = func.getText().split(";");

					data[i][0] = partialFunc[i];
					data[i][1] = "Valor: "+d+" "+	((char) (j+i));

					reescreveObjeto(data, d);
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
