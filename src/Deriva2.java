import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Deriva2 extends Deriva {
	
	public double Deriva2(String sFunc, String sX, String erro){
		Double x = Double.parseDouble(sX);
		Double e = Double.parseDouble(erro);
		h = 1000*e;
		p = ( f(x+2*h, sFunc) - 2*f(x, sFunc) + f(x-2*h, sFunc) ) / (4*h*h);
		while(i < 10) {
			q = p;
			h = h/2;
			p = ( f(x+2*h, sFunc) - 2*f(x, sFunc) + f(x-2*h, sFunc) ) / (4*h*h);
			if(Math.abs(p-q) < e)
				break;
			i++;
		}
		return p;
	}
}
