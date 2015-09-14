import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import model.MyoaStory;

public class MyoaGui extends JPanel {

	private static final long SERIALVERSIONUID = 5726988697266110395L;
	private static JTextField textField;
	static File file;
	protected static int count = 0;

	static JRadioButton abyssalForest = new JRadioButton("The Abyssal Forest");
	static JRadioButton testStory = new JRadioButton("Test Story");
	
	static JButton enterButton = new JButton("Enter");
	static JButton resetButton = new JButton("reset");
	
	static GridBagConstraints c = new GridBagConstraints();

	static JFrame guiFrame = new JFrame("Make Your Own Adventure");
	static JPanel contentPane;
	
	
	
	static JTextArea textArea;
	
	

	public MyoaGui() {
		addButtons();
		formatJFrame();
		formatJPanel();
		formatTextArea();
		formatTextField();
		PushedReset();
		formatEnterButton();
		

		

		c.anchor = GridBagConstraints.EAST;
	}




	private void formatTextField() {
		textField = new JTextField(50);
		c.anchor = GridBagConstraints.SOUTHWEST;
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		contentPane.add(textField, c);
	}


	private void addButtons() {
		ButtonGroup group = new ButtonGroup();
		
		addAbyssalForestButton(group);
		addTestStoryButton(group);
	}

	private void addAbyssalForestButton(ButtonGroup group) {
		group.add(abyssalForest);
	}


	private void addTestStoryButton(ButtonGroup group) {
		group.add(testStory);
		
	}

	private void formatJFrame() {
		
		setCloseOperation(guiFrame);	
		guiFrame.add(contentPane);
		guiFrame.pack();
		guiFrame.setVisible(true);

	}

	
	private void setCloseOperation(JFrame guiFrame) {
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	private void formatJPanel(){
	
		contentPane = new JPanel(new GridBagLayout());
		c.anchor = GridBagConstraints.EAST;
		contentPane.add(abyssalForest);
		contentPane.add(testStory);
		contentPane.add(resetButton);
	}
	
	private void formatTextArea() {
		Font textFont = new Font("Verdana", Font.BOLD, 12);
		
		textArea = new JTextArea(30, 60);
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx = 0;
		c.gridy = 0;
		JScrollPane scroller = new JScrollPane(textArea);
		contentPane.add(scroller, c);
		
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(textFont);
	}
		
	private void formatEnterButton() {
		c.anchor = GridBagConstraints.SOUTHEAST;
		contentPane.add(enterButton, c);
	}

	private void PushedReset() {
		resetButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			count = 0;
			textArea.append("Game has been reset \n");
		}
		});
	}
}
