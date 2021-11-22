package view;

import misc.Instructions;
import misc.MapEditor;
import model.Question;
import view.FancyButton;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.SysData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;




public class QuestionScreen extends JFrame {
SysData s = SysData.getInstance();
 ArrayList<Question> al = s.getQuestions();
	public QuestionScreen() {
		
		setSize(600,400);
		getContentPane().setBackground(Color.black);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
//        ImageIcon logo = new ImageIcon();
//    try {
//        logo = new ImageIcon(ImageIO.read(this.getClass().getResource("/resources/images/pacman_logo.png")));
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//    //  Register Custom fonts
//    try {
//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/resources/fonts/crackman.ttf")));
//    } catch (IOException|FontFormatException e) {
//        e.printStackTrace();
//    }
//    //getContentPane().setLayout(new CardLayout(0, 0));
   //getContentPane().add(new JLabel(logo), "name_347941458356300");
        
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewQuestion = new JButton("Add a New Question");
		btnNewQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton backBTN = new JButton("Back");
		GridBagConstraints gbc_backBTN = new GridBagConstraints();
		gbc_backBTN.insets = new Insets(0, 0, 5, 5);
		gbc_backBTN.gridx = 4;
		gbc_backBTN.gridy = 1;
		getContentPane().add(backBTN, gbc_backBTN);
		

		
		JLabel lblEditQuestion = new JLabel("Edit Questions");
		lblEditQuestion.setForeground(Color.ORANGE);
		lblEditQuestion.setSize(200,200);
		GridBagConstraints gbc_lblEditQuestion = new GridBagConstraints();
		gbc_lblEditQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditQuestion.gridx = 7;
		gbc_lblEditQuestion.gridy = 2;
		getContentPane().add(lblEditQuestion, gbc_lblEditQuestion);
		GridBagConstraints gbc_btnNewQuestion = new GridBagConstraints();
		gbc_btnNewQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewQuestion.gridx = 7;
		gbc_btnNewQuestion.gridy = 3;
		getContentPane().add(btnNewQuestion, gbc_btnNewQuestion);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 7;
		gbc_comboBox.gridy = 4;
		//gbc_comboBox.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
		getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblAnswer1 = new JLabel("New label");
		lblAnswer1.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblAnswer1 = new GridBagConstraints();
		gbc_lblAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer1.gridx = 7;
		gbc_lblAnswer1.gridy = 5;
		getContentPane().add(lblAnswer1, gbc_lblAnswer1);
		
		JLabel lblAnswer2 = new JLabel("New label");
		lblAnswer2.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblAnswer2 = new GridBagConstraints();
		gbc_lblAnswer2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer2.gridx = 7;
		gbc_lblAnswer2.gridy = 6;
		getContentPane().add(lblAnswer2, gbc_lblAnswer2);
		
		JLabel lblAnswer3 = new JLabel("New label");
		lblAnswer3.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblAnswer3 = new GridBagConstraints();
		gbc_lblAnswer3.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer3.gridx = 7;
		gbc_lblAnswer3.gridy = 7;
		getContentPane().add(lblAnswer3, gbc_lblAnswer3);
		
		JLabel lblAnswer4 = new JLabel("New label");
		lblAnswer4.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblAnswer4 = new GridBagConstraints();
		gbc_lblAnswer4.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer4.gridx = 7;
		gbc_lblAnswer4.gridy = 8;
		getContentPane().add(lblAnswer4, gbc_lblAnswer4);
		
		JButton EasyQuestionsBTN = new JButton("Easy");
		EasyQuestionsBTN.setBackground(Color.WHITE);
		GridBagConstraints gbc_EasyQuestionsBTN = new GridBagConstraints();
		gbc_EasyQuestionsBTN.insets = new Insets(0, 0, 5, 5);
		gbc_EasyQuestionsBTN.gridx = 6;
		gbc_EasyQuestionsBTN.gridy = 10;
		getContentPane().add(EasyQuestionsBTN, gbc_EasyQuestionsBTN);
		
		JButton MediumQuestionBTN = new JButton("Medium");
		MediumQuestionBTN.setBackground(Color.YELLOW);
		MediumQuestionBTN.setForeground(Color.BLACK);
		GridBagConstraints gbc_MediumQuestionBTN = new GridBagConstraints();
		gbc_MediumQuestionBTN.insets = new Insets(0, 0, 5, 5);
		gbc_MediumQuestionBTN.gridx = 7;
		gbc_MediumQuestionBTN.gridy = 10;
		getContentPane().add(MediumQuestionBTN, gbc_MediumQuestionBTN);
		
		JButton HardQuestionBTN = new JButton("Hard");
		HardQuestionBTN.setBackground(Color.RED);
		GridBagConstraints gbc_HardQuestionBTN = new GridBagConstraints();
		gbc_HardQuestionBTN.insets = new Insets(0, 0, 5, 5);
		gbc_HardQuestionBTN.gridx = 8;
		gbc_HardQuestionBTN.gridy = 10;
		getContentPane().add(HardQuestionBTN, gbc_HardQuestionBTN);
		
		JButton DeleteBTN = new JButton("Delete");
		GridBagConstraints gbc_DeleteBTN = new GridBagConstraints();
		gbc_DeleteBTN.insets = new Insets(0, 0, 5, 5);
		gbc_DeleteBTN.gridx = 5;
		gbc_DeleteBTN.gridy = 12;
		getContentPane().add(DeleteBTN, gbc_DeleteBTN);
		
		JButton SaveBTN = new JButton("Save");
		SaveBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_SaveBTN = new GridBagConstraints();
		gbc_SaveBTN.insets = new Insets(0, 0, 5, 5);
		gbc_SaveBTN.gridx = 9;
		gbc_SaveBTN.gridy = 12;
		getContentPane().add(SaveBTN, gbc_SaveBTN);
		
		setVisible(true);
		
		   backBTN.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		             StartWindow sw = new StartWindow();
		             dispose();
		         }
		     });
	}
	

//	    public QuestionScreen(){
//	        setSize(600,400);
//	        //getContentPane().setBackground(Color.black);
//	        setLocationRelativeTo(null);
//	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//	        
//	      
//	      //  getContentPane().add(lblNewLabel_2, BorderLayout.CENTER);
//	        
//	       
//	        //getContentPane().add(lblNewLabel_1, BorderLayout.CENTER);
//
////	        ImageIcon logo = new ImageIcon();
////	        try {
////	            logo = new ImageIcon(ImageIO.read(this.getClass().getResource("/resources/images/pacman_logo.png")));
////	        } catch (IOException e) {
////	            e.printStackTrace();
////	        }
////
////	        //  Register Custom fonts
////	        try {
////	            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
////	            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/resources/fonts/crackman.ttf")));
////	        } catch (IOException|FontFormatException e) {
////	            e.printStackTrace();
////	        }
//	        //getContentPane().setLayout(new CardLayout(0, 0));
//	        //getContentPane().add(new JLabel(logo), "name_347941458356300");
//
//	        JPanel buttonsC = new JPanel();
//	        buttonsC.setBackground(Color.black);
//
//
//	        //buttonsC.setLayout(new BoxLayout(buttonsC,BoxLayout.Y_AXIS));
//	        
//	        JLabel lblNewLabel = new JLabel("Edit Questions");
//	        lblNewLabel.setForeground(Color.YELLOW);
//	       // getContentPane().add(lblNewLabel, "name_347941475154800");
//	        FancyButton instButton = new FancyButton("Instructions");
//	        //getContentPane().add(instButton, BorderLayout.SOUTH);
//	        
////	        	        instButton.addActionListener(new ActionListener() {
////	        	            @Override
////	        	            public void actionPerformed(ActionEvent e) {
////	        	                Instructions me = new Instructions();
////	        	                dispose();
////	        	            }
////	        	        });
//
//	       // getContentPane().add(buttonsC, BorderLayout.NORTH);
//
//	        setVisible(true);
//	    }
	

	
	
}
