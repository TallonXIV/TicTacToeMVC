import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.AbstractButton;

public class Controller implements ActionListener{
	Model model;
	View view;
	Object source;
	int playerNum = 1;
	int winningPlayerR, winningPlayerRX, winningPlayerC, winningPlayerCX, winningPlayerCross, winningPlayerCrossX;
	int turnCounter = 0, moveCounter = 0;
	
	//instantiates model and view
	public Controller (Model model, View view) {
		this.model = model;
		this.view = view;
		addListeners();
	}
	//adds event listeners to each of the buttons in the array
	public void addListeners() {
		for(int i = 0; i < 16; i++) {
			view.buttons[i].addActionListener(this);
		}
	}
	//wait for one of the buttons to be pressed and acts accordingly
	public void actionPerformed(ActionEvent actionEvent) {
		moveCounter++;
		((AbstractButton) actionEvent.getSource()).setEnabled(false);
		source = actionEvent.getSource();
		if(Arrays.asList(view.buttons).contains(source) && playerNum == 1) {
			playerNum = view.toggleButtonTextX(source, playerNum);
			if (playerNum == 1) {/*nothing*/}
			else 
				model.incrementTurnCounter();
				 turnCounter++;
		}
		else if(Arrays.asList(view.buttons).contains(source) && playerNum == 2) {
			playerNum = view.toggleButtonTextO(source, playerNum);
			if (playerNum == 2) {/*nothing*/}
			else 
				model.incrementTurnCounter();
				 turnCounter++;
		}
		buttonChecker();
		if(moveCounter == 16)
			view.declareDraw();
		else if(winningPlayerR != 0)
			view.declareWinner(1);
		else if(winningPlayerRX != 0)
			view.declareWinner(2);
		else if(winningPlayerC != 0) 
			view.declareWinner(3);
		else if(winningPlayerCX != 0) 
			view.declareWinner(4);
		else if(winningPlayerCross != 0) 
			view.declareWinner(5);
		else if(winningPlayerCrossX != 0) 
			view.declareWinner(6);
	}
//=============================================THESE ARE NETHOD CALLS, NO PROCESSING==================================================================
		//============================================ROW PASSER===========================================================
		public void buttonChecker() {
		if(source == view.button1 || source == view.button2 || source == view.button3 || source == view.button4) 
			if(playerNum == 1)
				winningPlayerRX = model.winCheckRO(1);  //increments row 1
			else
				winningPlayerR = model.winCheckRX(1);
		else if(source == view.button5 || source == view.button6 || source == view.button7 || source == view.button8) 
			if(playerNum == 1) 
				winningPlayerRX = model.winCheckRO(2); //incrememnts row 2
			else
				winningPlayerR = model.winCheckRX(2);
		else if(source == view.button9 || source == view.button10 || source == view.button11 || source == view.button12) 
			if(playerNum == 1)
				winningPlayerRX = model.winCheckRO(3); //increments row 3
			else
				winningPlayerR = model.winCheckRX(3);
		else if(source == view.button13 || source == view.button14 || source == view.button15 || source == view.button16) 
			if(playerNum == 1) 
				winningPlayerRX = model.winCheckRO(4); //increments row 4
			else
				winningPlayerR = model.winCheckRX(4);
		//============================================COL PASSER==========================================================
		if(source == view.button1 || source == view.button5 || source == view.button9 || source == view.button13)
			if(playerNum == 1) 
				winningPlayerCX = model.winCheckCO(1); //increments col 1
			else
				winningPlayerC = model.winCheckCX(1);
		else if(source == view.button2 || source == view.button6 || source == view.button10 || source == view.button14)
			if(playerNum == 1)
				winningPlayerCX = model.winCheckCO(2); //increments col 2
			else
				winningPlayerC = model.winCheckCX(2);
		else if(source == view.button3 || source == view.button7 || source == view.button11 || source == view.button15)
			if(playerNum == 1) 
				winningPlayerCX = model.winCheckCO(3); //increments col 3
			else
				winningPlayerC = model.winCheckCX(3);
		else if(source == view.button4 || source == view.button8 || source == view.button12 || source == view.button16)
			if(playerNum == 1) 
				winningPlayerCX = model.winCheckCO(4); //increments col 4
			else
				winningPlayerC = model.winCheckCX(4);
		//============================================CROSS PASSER=======================================================
		if(source == view.button1 || source == view.button6 || source == view.button11 || source == view.button16)
			if(playerNum == 1) 
				winningPlayerCrossX = model.winCheckCrossO(1); //increments cross 1
			else
				winningPlayerCross = model.winCheckCrossX(1);
		else if(source == view.button4 || source == view.button7 || source == view.button10 || source == view.button13)
			if(playerNum == 1)
				winningPlayerCrossX = model.winCheckCrossO(2); //increments cross 2
			else
				winningPlayerCross = model.winCheckCrossX(2);
	} 
}
