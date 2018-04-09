import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Deriva {
	double h;
	double p, q;
	int i = 1;
	
	public double Deriva(String sFunc, String sX, String erro){
		Double e = Double.parseDouble(erro);
		Double x = Double.parseDouble(sX);
		h = 1000*e;
		p = equacao(x, sFunc);
		while(i < 10) {
			q = p;
			h = h/2;
			p = equacao(x, sFunc);
			if(Math.abs(p-q) < e)
				break;
			i++;
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
	
	public double equacao(double x, String sFunc) {
			return ((f(x+h, sFunc) - f(x-h, sFunc))/(2*h));
	}
}
