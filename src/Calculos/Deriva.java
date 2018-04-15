package Calculos;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import Listeners.ActionsMsgPopup;
import Telas.MsgPopup;

public class Deriva {
	static MsgPopup msg = new MsgPopup();

	double h;
	double p, q;
	int i = 1;

	public Deriva(){
		msg.dispose();
	}

	public double Derivar(String sFunc, String sX, String erro, int g){
		try {

			Double e = Double.parseDouble(erro);
			Double x = Double.parseDouble(sX);
			h = 1000*e;
			p = equacao(x, sFunc, g);
			while(i < 10) {
				q = p;
				h = h/2;
				p = equacao(x, sFunc, g);
				if(Math.abs(p-q) < e)
					break;
				i++;
			}}catch(Exception e){
				if(!msg.isVisible()) 
					new ActionsMsgPopup();
			}
		return p;
	}

	public double f(double x, String sFunc) {

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

	public double equacao(double x, String sFunc, int g) {
		if(g > 1) {
			if(g == 2) {
				return ( f(x+g*h, sFunc) - g*f(x, sFunc) + f(x-g*h, sFunc) ) / (Math.pow((2*h), g));
			}
			if(g == 3) {
				return ( f(x+g*h, sFunc) - g*f(x+h, sFunc) + g*f(x-h, sFunc) - f(x-g*h, sFunc) ) / (Math.pow((2*h), g));
			}
			else
				return ( f(x+g*h, sFunc) - g*f(x+2*h, sFunc) + 6*f(x, sFunc) - 4*f(x-2*h, sFunc) + f(x-g*h, sFunc)) / (Math.pow((2*h), g));
		}
		else
			return ((f(x+h, sFunc) - f(x-h, sFunc))/(2*h));
	}
}
