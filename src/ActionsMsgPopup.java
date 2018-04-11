import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionsMsgPopup extends MsgPopup {

	ActionsMsgPopup(){
		btn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				dispose();

			} 
		});
	}
}