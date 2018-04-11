package Calculos;

public class DerivaNVezes extends Deriva {
	
	public double DerivanrNVezes(String sFunc, String sX, String erro){
		
		Double x = Double.parseDouble(sX);
		Double e = Double.parseDouble(erro);
		h = 1000*e;
		
		p = equacao(x, sFunc, 2);
		while(i < 10) {
			q = p;
			h = h/2;
			p = equacao(x, sFunc, 2);
			if(Math.abs(p-q) < e)
				break;
			i++;
		}
		return p;
	}
}
