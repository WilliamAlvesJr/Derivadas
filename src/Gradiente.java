import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Gradiente extends DerivadaDeVariasVariaveis {

	public Gradiente() {
		Stack<Double> Gradiente = new Stack<Double>();
		int i = 1;
		while(i < 12) {
			Gradiente = Derivadas("x*x", "1", "1");
			System.out.println(Gradiente);
			i++;
		}
	}
	
	@Override
	public double f(double x, String sFunc) {
		sFunc = sFunc.replaceFirst("x", Double.toString(x));
		String sPartialFunc[] = sFunc.split("x");
		sFunc = sPartialFunc[0];

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			System.out.println(sFunc);
			return (double) engine.eval(sFunc);
		} catch (ScriptException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public double f(String sFunc, double... xi) {

		for (double x : xi) {

			f(x, sFunc);
		}
		return 0;
	}
}
