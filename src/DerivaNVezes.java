public class DerivaNVezes extends Deriva {
	
	public double DerivaNVezes(String sFunc, String sX, String erro){
		Double x = Double.parseDouble(sX);
		Double e = Double.parseDouble(erro);
		h = 1000*e;
		
//		Double	 s2 = (f(s1+h, sFunc) - f(s1-h, sFunc))/(2*h);
		
//		s = s.replaceAll(sX, "x");
//		String s2 = s2.replaceAll("x", sX);
		
		p = equacao(x, sFunc, 2);
//		p = ( f(x+2*h, sFunc, 2) - 2*f(x, sFunc) + f(x-2*h, sFunc) ) / (4*h*h);
		while(i < 10) {
			q = p;
			h = h/2;
//			s = String.valueOf(Deriva(sFunc, sX, erro));
//			p = equacao(x, sFunc)/(2*h);
//			s = String.valueOf(equacao(x,sFunc));
			p = equacao(x, sFunc, 2);
//			p = ( f(x+2*h, sFunc) - 2*f(x, sFunc) + f(x-2*h, sFunc) ) / (4*h*h);
			if(Math.abs(p-q) < e)
				break;
			i++;
		}
		return p;
	}
}
