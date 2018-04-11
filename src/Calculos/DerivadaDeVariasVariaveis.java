package Calculos;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DerivadaDeVariasVariaveis extends Deriva {

	public Stack<Double> Derivadas(String sFunc, String erro, String... sX){
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
		double f1 = f(x[j], sFunc);//, j);
		x[j] = xj-h;
		double f2 = f(x[j], sFunc);//, j);
		x[j] = xj;

		p = (f1-f2) / (2*h);
		Stack<Double> d = new Stack<Double>();
		while(j < sX.length) {
			xj = x[j];
			x[j] = xj + h;
			f1 = f(x[j], sFunc);//, j);
			x[j] = xj-h;
			f2 = f(x[j], sFunc);//, j);
			while(i < 10) {
				q = p;
				h = h/2;
				x[j] = xj+h;
				f1 = f(x[j], sFunc);//, j);
				x[j] = xj-h;
				f2 = f(x[j], sFunc);//, j);
				p = (f1-f2) / (2*h);

				if(Math.abs(p-q) < e)
					break;
				i++;
			}
			d.push(p);
			j++;
		}
		return d;
	}
	
//	public double f(double x, String sFunc, int j) {
//		System.out.println("sFunc: "+sFunc);
//		sFunc = sFunc.replaceAll("x0", Double.toString(x));
//		System.out.println("sFunc: "+sFunc);
////		String sPartialFunc[] = sFunc.split("x");
////		sFunc = sFunc.replaceAll("x", "0");
////		sFunc = sPartialFunc[0];
//
////		ScriptEngineManager mgr = new ScriptEngineManager();
////		ScriptEngine engine = mgr.getEngineByName("JavaScript");
////		try {
////			return (double) engine.eval(sFunc);
////		} catch (ScriptException e) {
////			e.printStackTrace();
//			return 0;
////		}
//	}
//
//	public double f(String sFunc, double... xi) {
//
//		for (double x : xi) {
//
//			f(x, sFunc);
//		}
//		return 0;
//	}
}
