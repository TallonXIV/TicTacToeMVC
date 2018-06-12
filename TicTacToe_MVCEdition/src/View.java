import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
public class View extends JFrame{                               
	JButton[] buttons;
	JButton StartNewGame;
	JLabel ButtonLabel;
	int PTurnNum;
	boolean hasDecided;
	Font turnDisplayFont = new Font("Times New Roman", Font.BOLD, 40);
	Font buttonDisplayFont = new Font("Times New Roman", Font.BOLD, 80);
	JButton newGame, button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16;
	JTextField text = new JTextField(20);
	
	//Calls view layout
	public View() {                                                
		initButtons();
		initLayout();
	}
	
	//Method for instantiating and creating buttons and default text
	public void initButtons() {                                  
		this.buttons = new JButton[16];
		/*1 2 3 4
		  5 6 7 8
		  9 10 11 12
		  13 14 15 16*/
		
		button1 = new JButton(" ");                             
		buttons[0] = button1;
		
		button2 = new JButton(" "); 
		buttons[1] = button2;
		
		button3 = new JButton(" "); 
		buttons[2] = button3;
		
		button4 = new JButton(" ");
		buttons[3] = button4;
		
		button5 = new JButton(" "); 
		buttons[4] = button5;
		
		button6 = new JButton(" ");
		buttons[5] = button6;
		
		button7 = new JButton(" "); 
		buttons[6] = button7;
		
		button8 = new JButton(" ");
		buttons[7] = button8;
		
		button9 = new JButton(" "); 
		buttons[8] = button9;
		
		button10 = new JButton(" "); 
		buttons[9] = button10;
		
		button11 = new JButton(" "); 
		buttons[10] = button11;
		
		button12 = new JButton(" ");
		buttons[11] = button12;
		
		button13 = new JButton(" "); 
		buttons[12] = button13;
		
		button14 = new JButton(" "); 
		buttons[13] = button14;
		
		button15 = new JButton(" "); 
		buttons[14] = button15;
		
		button16 = new JButton(" ");
		buttons[15] = button16;
		
		//These lines allow the developer to change the color of the buttons by changing the appended value behind "Color"
		for(int i = 0; i < 16; i++) {
			buttons[i].setBackground(Color.WHITE);
		}
	}
	
	//this method allows the buttons to be disabled after clicked and when the game ends. Avoid miscalculations or "double clicks"
	public void buttonDisabler() {
		for(int i = 0; i < 16; i++) {
			buttons[i].setEnabled(false);
		}
	}
	
	//This method sets up the initial button layout and panel layout
	public void initLayout() {                                     
		JFrame gameFrame = new JFrame("Tic-Tac-Toe");
		JPanel hudPanel = new JPanel();
		
		gameFrame.setLayout(new BorderLayout());
		gameFrame.setBackground(Color.BLACK);
		
		hudPanel.setLayout(new GridLayout(4, 4, 5, 5));
		hudPanel.setSize(600, 600);
		
		hudPanel.add(button1);
		hudPanel.add(button2);
		hudPanel.add(button3);
		hudPanel.add(button4);
		hudPanel.add(button5);
		hudPanel.add(button6);
		hudPanel.add(button7);
		hudPanel.add(button8);
		hudPanel.add(button9);
		hudPanel.add(button10);
		hudPanel.add(button11);
		hudPanel.add(button12);
		hudPanel.add(button13);
		hudPanel.add(button14);
		hudPanel.add(button15);
		hudPanel.add(button16);
		
		text.setEditable(false);
		text.setText("             Player X's Turn"); 
		text.setFont(turnDisplayFont);
		
		gameFrame.add(text, BorderLayout.NORTH);
		
		gameFrame.add(hudPanel);
		gameFrame.setSize(600, 600);
		gameFrame.setVisible(true);
		hudPanel.setVisible(true);		
	}
	
	//Toggles to player 2 if it is player 1's turn
	public int toggleButtonTextX(Object object, int playerNum) {   //Toggles button display, prevents swapping of other's squares, and changes turn number
		PTurnNum = 2;
		if(!hasDecided) {
			if(((AbstractButton) object).getText() == " ") {
				((AbstractButton) object).setFont(buttonDisplayFont);
				((AbstractButton) object).setText("X");
				text.setText("             Player O's Turn");
				return 2;
			}
			else 
				return 1;
		}
		else
			return 0;
	}
	
	//Toggles to Player 1 if it is player 2's turn
	public int toggleButtonTextO(Object object, int playerNum) {
		PTurnNum = 1;
		if(!hasDecided) {
			if(((AbstractButton) object).getText() == " ") {
				((AbstractButton) object).setFont(buttonDisplayFont);
				((AbstractButton) object).setText("O");
				text.setText("             Player X's Turn");
				return 1;
			}
			else 
				return 2;
		}
		else
			return 0;
	}
	
	//Outputs winner based on number passed from controller
	public void declareWinner(int winner) {
		if(!hasDecided)
			if(winner == 1) 
				text.setText("                      X wins!");
			else if(winner == 2) 
				text.setText("                      O wins!");
			else if(winner == 3) 
				text.setText("                      X wins!");
			else if(winner == 4) 
				text.setText("                      O wins!");
			else if(winner == 5) 
				text.setText("                      X wins!");
			else if(winner == 6)
				text.setText("                      O wins!");
		if(winner == 1 || winner == 2 || winner == 3 || winner == 4 || winner == 5 || winner == 6) 
			hasDecided = true;
			buttonDisabler();
	}
	
	//if passed the correct variable, outputs a draw notification
	public void declareDraw() {
		if(!hasDecided)
			text.setText("                         Draw");
	}
}
