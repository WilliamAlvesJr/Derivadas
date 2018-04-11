import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Deriva {
	static MsgPopup msg = new MsgPopup();
	
	double h;
	double p, q;
	int i = 1;

	public double Deriva(String sFunc, String sX, String erro){
		msg.dispose();
		
		try {
		Double e = Double.parseDouble(erro);
		Double x = Double.parseDouble(sX);
		h = 1000*e;
		p = equacao(x, sFunc, 1);
		while(i < 10) {
			q = p;
			h = h/2;
			p = equacao(x, sFunc, 1);
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
//			if(!msg.isVisible())
//				new ActionsMsgPopup();
			return 0;
		}
	}

	public double equacao(double x, String sFunc, int g) {
		int grau = g;
		if(grau > 1) {
			grau--;
			//			return ( f(x+2*h, sFunc) - 2*f(x, sFunc) + defineSignal(grau) *f(x-2*h, sFunc))/(4*h*h);
			//			return ( f(x+2*h, sFunc) - 2*f(x, sFunc) + f(x-2*h, sFunc) ) /           (4*h*h);
			return (
				(f(x+g*h, sFunc) 
				- (2*f(x, sFunc)) 
				+ (defineSinal(g) 
				* f(x-g*h, sFunc)))   
				/ (Math.pow(2*h, g))
			);
		}
		else
			return ((f(x+h, sFunc) - f(x-h, sFunc))/(2*h));
	}

	public int defineSinal(int grau) {
		int signal = -1;
		for(int i = 1; i < grau; i++) {
			signal *= -1; 
		}
		return signal;
	}
	
	public double defineFunc1(double x, String sFunc, int g) {
		if(g%2 == 0) { 
			return 2*(g-1)*f(x, sFunc)*defineSinal(g+1);
		}
		else
			return 0;
	}
}
