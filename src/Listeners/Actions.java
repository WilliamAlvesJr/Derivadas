package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Telas.Painel;

public class Actions extends Painel {

	public Actions(){
		hessiana.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new ActionsHessiana();
				
			} 
		});

		derivadaVariasVariaveis.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new ActionsDerivadaNVariaveis();

			} 
		});

		derivadas.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				new ActionsDerivadas();
			} 
		});

		gradiente.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				new ActionsGradiente();
			} 
		});
	}
}