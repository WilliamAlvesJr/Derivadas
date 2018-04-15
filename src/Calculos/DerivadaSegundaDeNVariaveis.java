//package Calculos;
//
//import java.util.Stack;
//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptException;
//
//import Listeners.ActionsMsgPopup;
//import Telas.MsgPopup;
//
//public class DerivadaSegundaDeNVariaveis extends DerivadaDeNVariaveis {
//	static MsgPopup msg = new MsgPopup();
//
//	public DerivadaSegundaDeNVariaveis(){
//		msg.dispose();
//	}
//
//	public Stack<Double> Derivadas(String sFunc, String erro, String... sX){
//		Stack<Double> d = new Stack<Double>();
//		try {
//			d = super.Derivadas(sFunc, erro, sX);
//			return d;
//		}
//		catch(Exception e) {
//			if(!msg.isVisible()) 
//				new ActionsMsgPopup();
//			return null;
//		}
//	}
//}
