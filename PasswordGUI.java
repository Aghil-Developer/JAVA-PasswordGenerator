package GUI;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PasswordGUI extends JFrame{

	private PasswordGenerator passwordgenerator;
	public PasswordGUI() {
		super("Password Generator");
		
		setSize(540, 570);
		
		setResizable(false);
		
		setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		getContentPane().setBackground(Color.decode("#000000")); // or any color

		passwordgenerator = new PasswordGenerator();
		
		addGuiComponenets();
	}
	
	private void addGuiComponenets() {
		JLabel titleLabel = new JLabel("Password Generator");
		titleLabel.setFont(new Font("Dialog" , Font.BOLD, 32));
		titleLabel.setForeground(Color.decode("#ffd93d"));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		titleLabel.setBounds(0,10,540,39);
		
		add(titleLabel);
		JTextArea passwordOutput = new JTextArea();
		
		passwordOutput.setEditable(false);
		passwordOutput.setFont(new Font("Dialog" , Font.BOLD, 32));
		
		
		JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
		passwordOutputPane.setBounds(25,97,479,70);
		
		passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(passwordOutputPane);
		
		JLabel passwordLength = new JLabel("Password Length");
		passwordLength.setFont(new Font("Dialog" , Font.PLAIN,32));
	    passwordLength.setForeground(Color.decode("#ffd93d"));
		passwordLength.setBounds(25,215,272,39);
		add(passwordLength);
		
		JTextArea passwordLengthInput = new JTextArea();
		passwordLengthInput.setFont(new Font("Dialog" , Font.PLAIN,32));
		passwordLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		passwordLengthInput.setBounds(310,215,192,39);
		add(passwordLengthInput);
		
		JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
		passwordLengthInput.setFont(new Font("Dialog" , Font.PLAIN,26));
		uppercaseToggle.setBounds(25,302,225,56);
		uppercaseToggle.setBackground(Color.decode("#ffd93d")); 
		uppercaseToggle.setForeground(Color.decode("#000000"));
		uppercaseToggle.setOpaque(true);
		uppercaseToggle.setBorderPainted(false);

		add(uppercaseToggle);
		
		JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
		passwordLengthInput.setFont(new Font("Dialog" , Font.PLAIN,32));
		lowercaseToggle.setBounds(282,302,225,56);
		lowercaseToggle.setBackground(Color.decode("#ffd93d")); 
		lowercaseToggle.setForeground(Color.decode("#000000"));
		add(lowercaseToggle);
		
		JToggleButton numbersToggle = new JToggleButton("Numbers");
		passwordLengthInput.setFont(new Font("Dialog" , Font.PLAIN,32));
		numbersToggle.setBackground(Color.decode("#ffd93d")); // sky blue
		numbersToggle.setForeground(Color.decode("#000000"));
		numbersToggle.setBounds(25,373,225,56);
		add(numbersToggle);
		
		JToggleButton symbolsToggle = new JToggleButton("Symbols");
		passwordLengthInput.setFont(new Font("Dialog" , Font.PLAIN,32));
		symbolsToggle.setBounds(282,373,225,56);
		symbolsToggle.setBackground(Color.decode("#ffd93d")); // sky blue
		symbolsToggle.setForeground(Color.decode("#000000"));
		add(symbolsToggle);
		
		JButton generateButton = new JButton("Generate");
		generateButton.setFont(new Font("Dialog" , Font.PLAIN,32));
		generateButton.setBackground(Color.decode("#ffd93d")); // sky blue
		generateButton.setForeground(Color.decode("#000000"));
		generateButton.setBounds(155,477,222,41);
		generateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(passwordLengthInput.getText().length()<=0) return;
				boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || numbersToggle.isSelected() || symbolsToggle.isSelected();
				int passwordLength = Integer.parseInt(passwordLengthInput.getText());
				if(anyToggleSelected) {
					String generatedPassword = passwordgenerator.generatePassword(passwordLength,uppercaseToggle.isSelected(),lowercaseToggle.isSelected(),numbersToggle.isSelected(),symbolsToggle.isSelected());
						passwordOutput.setText(generatedPassword);
					
				}
			}
			
		});
		add(generateButton);
		
	}
}
