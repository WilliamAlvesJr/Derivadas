package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Telas.MsgPopup;

public class ActionsMsgPopup extends MsgPopup {

	public ActionsMsgPopup(){
		btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose();

			} 
		});
	}
}