package Calculos;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import Listeners.ActionsMsgPopup;
import Telas.MsgPopup;

public class DerivadaDeDuasVariaveis extends Deriva {
	static MsgPopup msg = new MsgPopup();

	public static final String[][] DEFAULT_VALUES = {
			{"1", "", "", "", "", "", ""}, {"2", "", "", "", "", "", ""},
			{"3", "", "", "", "", "", ""}, {"4", "", "", "", "", "", ""},
			{"5", "", "", "", "", "", ""}, {"6", "", "", "", "", "", ""}
	};

	public DerivadaDeDuasVariaveis(){
		msg.dispose();
	}

	public Object[][] DerivadasXY(String sFunc, String erro, String sX[], String sY[]) {
		Object valores[][] = {
				{"1", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {"2", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
				{"3", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {"4", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
				{"5", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {"6", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
		};

		try {

			double x[] = new double[sX.length];
			int j = 0;
			for (String sx : sX) {
				if(j < sX.length) {
					x[j] = Double.parseDouble(sx);	
					j++;
				}
			}
			double y[] = new double[sY.length];
			int k = 0;
			for (String sy : sY) {
				if(k < sY.length) {
					y[k] = Double.parseDouble(sy);	
					k++;
				}
			}

			Double e = Double.parseDouble(erro);
			h = 1000*e;
			j = 0;
			k = 0;

			Double yj = y[j];
			Double xj = x[j];

			x[j] = xj + h;
			y[j] = yj + j;

			double f1;
			double f2;
			double f3;
			double f4 = 0;

			if(k != j) {
				x[j] = xj + h; y[k] = yj + h; f1 = f(x[j], y[k], sFunc);
				y[k] = yj - h;				  f2 = f(x[j], y[k], sFunc);
				x[j] = xj - h;				  f4 = f(x[j], y[k], sFunc);
				y[k] = yj + h;				  f3 = f(x[j], y[k], sFunc);
				p = (f1-f2-f3+f4)/(4*h*h);
			} else {
				x[j] = xj+2*h;				  f1 = f(x[j], y[k], sFunc);
				x[j] = xj-2*h;				  f2 = f(x[j], y[k], sFunc);
				x[j] = xj;					  f3 = f(x[j], y[k], sFunc);
				p = (f1-2*f2+f3)/(4*h*h);
			}

			while(j < sX.length) {
				while(k < sY.length) {
					while(i < 10) {
						valores[k][j+1] = p;
						System.out.println(valores[k][j+1]);
						
						q = p;
						h = h/2;

						if(k != j) {
							x[j] = xj + h; y[j] = yj + h; f1 = f(x[j], y[k], sFunc);
							y[k] = yj - h;				  f2 = f(x[j], y[k], sFunc);
							x[j] = xj - h;				  f4 = f(x[j], y[k], sFunc);
							y[k] = yj + h;				  f3 = f(x[j], y[k], sFunc);
							p = (f1-f2-f3+f4)/(4*h*h);
						} else {
							x[j] = xj+2*h;				  f1 = f(x[j], y[k], sFunc);
							x[j] = xj-2*h;				  f2 = f(x[j], y[k], sFunc);
							x[j] = xj;					  f3 = f(x[j], y[k], sFunc);
							p = (f1-2*f2+f3)/(4*h*h);
						}
						if(Math.abs(p-q) < e) {
							break;	
						}
						i++;
					}
					k++;
					i = 0;
				}
				j++;
				k = 0;
			}
			return valores;
		} catch(Exception e) {
			if(!msg.isVisible()) 
				new ActionsMsgPopup();
			return DEFAULT_VALUES;
		}
	}


	public double f(double x, double y, String sFunc) {

		sFunc = sFunc.replaceAll("x", Double.toString(x));
		sFunc = sFunc.replaceAll("y", Double.toString(y));

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			return (double) engine.eval(sFunc);
		} catch (ScriptException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
