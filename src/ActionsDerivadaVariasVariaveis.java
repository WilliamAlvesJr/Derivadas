import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ActionsDerivadaVariasVariaveis extends PainelDerivadaDeVariasVariaveis {
	
	ActionsDerivadaVariasVariaveis(){
		System.out.println(new DerivadaDeVariasVariaveis().Derivadas("x*x", "0.1", "6","7","8"));
		
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
	}
}