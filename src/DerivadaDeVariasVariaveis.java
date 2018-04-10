import java.util.Stack;

public class DerivadaDeVariasVariaveis extends Deriva {

	public Stack<Double> Derivadas(String sFunc, String erro, String... sX){
		double x[] = new double[sX.length];
		int j = 0;
		for (String sx : sX) {
			//			System.out.println("Fora: "+sx);
			if(j < sX.length) {
				//				System.out.println("Dentro: "+sx);
				x[j] = Double.parseDouble(sx);	
				//				System.out.println("x["+j+"]: "+x[j]);
				j++;
			}
		}
		Double e = Double.parseDouble(erro);
		h = 1000*e;
		j = 0;

		Double xj = x[j];
		x[j] = xj + h;
		double f1 = f(x[j], sFunc);
		x[j] = xj-h;
		double f2 = f(x[j], sFunc);
		x[j] = xj;

		p = (f1-f2) / (2*h);
		Stack<Double> d = new Stack<Double>();
		while(j < sX.length) {
			xj = x[j];
			x[j] = xj + h;
			f1 = f(x[j], sFunc);
			x[j] = xj-h;
			f2 = f(x[j], sFunc);
			while(i < 10) {
				q = p;
				h = h/2;
				x[j] = xj+h;
				f1 = f(x[j], sFunc);
				x[j] = xj-h;
				f2 = f(x[j], sFunc);
				p = (f1-f2) / (2*h);

				if(Math.abs(p-q) < e)
					break;
				i++;
			}
			d.push(p);
			j++;
		}
//		System.out.println("Valor de d: "+d);	
		return d;
	}
}
