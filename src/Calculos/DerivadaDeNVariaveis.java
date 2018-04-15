package Calculos;

import java.util.Stack;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import Listeners.ActionsMsgPopup;
import Telas.MsgPopup;

public class DerivadaDeNVariaveis extends Deriva {
	static MsgPopup msg = new MsgPopup();

	public DerivadaDeNVariaveis(){
		msg.dispose();
	}

	public Stack<Double> Derivadas(String sFunc, String erro, int g, String... sX){

		try {
			String auxFunc[] = sFunc.split(";");
			for (int i = 0; i < auxFunc.length; i++) {
				if(i > 0)
					auxFunc[i] = auxFunc[i-1]+auxFunc[i];
			}

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
			double f1 = equacao(x[j], auxFunc[j], g, j);//f(x[j], auxFunc[j], j);
			x[j] = xj-h;
			double f2 = equacao(x[j], auxFunc[j], g, j);//f(x[j], auxFunc[j], j);
			x[j] = xj;

			p = (f1-f2) / (2*h);
			Stack<Double> d = new Stack<Double>();
			while(j < sX.length) {
				xj = x[j];
				x[j] = xj + h;
				f1 = equacao(x[j], auxFunc[j], g, j);//f(x[j], auxFunc[j], j);
				x[j] = xj-h;
				f2 = equacao(x[j], auxFunc[j], g, j);//f(x[j], auxFunc[j], j);
				while(i < 10) {
					q = p;
					h = h/2;
					x[j] = xj+h;
					f1 = equacao(x[j], auxFunc[j], g, j);//f(x[j], auxFunc[j], j);
					x[j] = xj-h;
					f2 = equacao(x[j], auxFunc[j], g, j);//f(x[j], auxFunc[j], j);
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

	public double f(double x, String sFunc, int j) {

		sFunc = sFunc.replaceAll("x", Double.toString(x));

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			return (double) engine.eval(sFunc);
		} catch (ScriptException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public double equacao(double x, String sFunc, int g, int j) {
		if(g == 2) 
			return ((f(x+h, sFunc, j) - f(x-h, sFunc, j))/(2*h));
		else
			return f(x, sFunc, j);
	}
}
