package Calculos;

import java.util.Stack;

import Listeners.ActionsMsgPopup;
import Telas.MsgPopup;

public class Gradiente extends DerivadaDeNVariaveis {
	static MsgPopup msg = new MsgPopup();

	public Gradiente() {
		msg.dispose();
	}

	public Stack<Double> Derivadas(String sFunc, String erro, String... sX){

		try {
			String auxFunc[] = sFunc.split(";");

			double x[] = new double[sX.length];
			int j = 0;
			for (String sx : sX) {
				if(j < sX.length) {
					x[j] = Double.parseDouble(sx);	
					j++;
				}
			}
			Double e = Double.parseDouble(erro);
			h = 1000*e;
			j = 0;

			Double xj = x[j];
			x[j] = xj + h;
			double f1 = f(x[j], auxFunc[j], j);
			x[j] = xj-h;
			double f2 = f(x[j], auxFunc[j], j);
			x[j] = xj;

			p = (f1-f2) / (2*h);
			Stack<Double> d = new Stack<Double>();
			while(j < sX.length) {
				xj = x[j];
				x[j] = xj + h;
				f1 = f(x[j], auxFunc[j], j);
				x[j] = xj-h;
				f2 = f(x[j], auxFunc[j], j);
				while(i < 10) {
					q = p;
					h = h/2;
					x[j] = xj+h;
					f1 = f(x[j], auxFunc[j], j);
					x[j] = xj-h;
					f2 = f(x[j], auxFunc[j], j);
					p = (f1-f2) / (2*h);

					if(Math.abs(p-q) < e) 
						break;
					i++;
				}
				d.push(p);
				j++;
			}
			return d;
		} catch(Exception e) {
			if(!msg.isVisible()) 
				new ActionsMsgPopup();
			return null;
		}
	}
}
