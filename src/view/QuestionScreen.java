package view;

import model.Question;

import javax.swing.*;

import controller.SysData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
/**
 *This page will let the user read the existing questions.
 *The user also have the ability to edit, delete and add new question.
 */
public class QuestionScreen extends JFrame {
SysData s = SysData.getInstance();
 ArrayList<Question> al = s.getQuestions();
	ArrayList<Question> hq = new ArrayList<Question>();
	ArrayList<Question> mq = new ArrayList<Question>();
	ArrayList<Question> eq = new ArrayList<Question>();
	Object selectedItem = new Object();
	JButton easyQuestionsBTN = new JButton("Easy");
	JButton mediumQuestionBTN = new JButton("Medium");
	JButton hardQuestionBTN = new JButton("Hard");
	JButton allQuestionsBTN = new JButton("All ");
	public QuestionScreen() {
		setSize(600,400);
		getContentPane().setBackground(Color.black);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
//		JButton backBTN = new JButton("Back");
		FancyButton backBTN = new FancyButton("Back", 20f);
		GridBagConstraints gbc_backBTN = new GridBagConstraints();
		gbc_backBTN.insets = new Insets(0, 0, 5, 5);
		gbc_backBTN.gridx = 4;
		gbc_backBTN.gridy = 1;
		getContentPane().add(backBTN, gbc_backBTN);
				

				
				JLabel lblEditQuestion = new JLabel("Edit Questions");
				lblEditQuestion.setForeground(Color.ORANGE);
				lblEditQuestion.setSize(200,200);
				GridBagConstraints gbc_lblEditQuestion = new GridBagConstraints();
				gbc_lblEditQuestion.gridwidth = 5;
				gbc_lblEditQuestion.insets = new Insets(0, 0, 5, 5);
				gbc_lblEditQuestion.gridx = 17;
				gbc_lblEditQuestion.gridy = 2;
				getContentPane().add(lblEditQuestion, gbc_lblEditQuestion);
				
//				JButton btnNewQuestion = new JButton("Add a New Question");
				FancyButton btnNewQuestion = new FancyButton("Add a New Question", 20f);
				btnNewQuestion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NewQuestionScreen nqs = new NewQuestionScreen();
						dispose();
					}
				});
				GridBagConstraints gbc_btnNewQuestion = new GridBagConstraints();
				gbc_btnNewQuestion.gridwidth = 5;
				gbc_btnNewQuestion.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewQuestion.gridx = 17;
				gbc_btnNewQuestion.gridy = 3;
				getContentPane().add(btnNewQuestion, gbc_btnNewQuestion);
		

				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel<Question>(al.toArray(new Question[0])));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.gridwidth = 6;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 17;
				gbc_comboBox.gridy = 4;
				getContentPane().add(comboBox, gbc_comboBox);


		JLabel lblAnswer1 = new JLabel(al.get(0).answers.get(0).aBody.toString());
		lblAnswer1.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblAnswer1 = new GridBagConstraints();
		gbc_lblAnswer1.gridwidth = 2;
		gbc_lblAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer1.gridx = 18;
		gbc_lblAnswer1.gridy = 5;
		getContentPane().add(lblAnswer1, gbc_lblAnswer1);
		
				JLabel lblAnswer2 = new JLabel(al.get(0).answers.get(1).aBody.toString());
				lblAnswer2.setForeground(Color.ORANGE);
				GridBagConstraints gbc_lblAnswer2 = new GridBagConstraints();
				gbc_lblAnswer2.gridwidth = 2;
				gbc_lblAnswer2.insets = new Insets(0, 0, 5, 5);
				gbc_lblAnswer2.gridx = 18;
				gbc_lblAnswer2.gridy = 6;
				getContentPane().add(lblAnswer2, gbc_lblAnswer2);
				
				JLabel lblAnswer3 = new JLabel(al.get(0).answers.get(2).aBody.toString());
				lblAnswer3.setForeground(Color.ORANGE);
				GridBagConstraints gbc_lblAnswer3 = new GridBagConstraints();
				gbc_lblAnswer3.gridwidth = 2;
				gbc_lblAnswer3.insets = new Insets(0, 0, 5, 5);
				gbc_lblAnswer3.gridx = 18;
				gbc_lblAnswer3.gridy = 7;
				getContentPane().add(lblAnswer3, gbc_lblAnswer3);
				
				JLabel lblAnswer4 = new JLabel(al.get(0).answers.get(3).aBody.toString());
				lblAnswer4.setForeground(Color.ORANGE);
				GridBagConstraints gbc_lblAnswer4 = new GridBagConstraints();
				gbc_lblAnswer4.gridwidth = 2;
				gbc_lblAnswer4.insets = new Insets(0, 0, 5, 5);
				gbc_lblAnswer4.gridx = 18;
				gbc_lblAnswer4.gridy = 8;
				getContentPane().add(lblAnswer4, gbc_lblAnswer4);
		

				easyQuestionsBTN.setBackground(Color.WHITE);
				GridBagConstraints gbc_EasyQuestionsBTN = new GridBagConstraints();
				gbc_EasyQuestionsBTN.insets = new Insets(0, 0, 5, 5);
				gbc_EasyQuestionsBTN.gridx = 17;
				gbc_EasyQuestionsBTN.gridy = 10;
				getContentPane().add(easyQuestionsBTN, gbc_EasyQuestionsBTN);
				//display only easy question
						easyQuestionsBTN.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								easyQuestionsBTN.setForeground(Color.ORANGE);
								mediumQuestionBTN.setForeground(Color.black);
								hardQuestionBTN.setForeground(Color.black);
								allQuestionsBTN.setForeground(Color.black);
								eq.clear();
								//create array of only easy questions
								for(Question q : al) {
									if(q.diff==1 && !eq.contains(q))
									{
										eq.add(q);
				
									}
				
								}
								comboBox.setModel(new DefaultComboBoxModel<Question>(eq.toArray(new Question[0])));
								//display the answers for each question
								if (eq.size() > 0) {
									Question selectedItem = (Question) comboBox.getSelectedItem();
									comboBox.setSelectedItem(eq.get(0));
									lblAnswer1.setText(selectedItem.answers.get(0).aBody.toString() + (selectedItem.answers.get(0).isCorrect ? " (True)" : ""));
									lblAnswer2.setText(selectedItem.answers.get(1).aBody.toString() + (selectedItem.answers.get(1).isCorrect ? " (True)" : ""));
									lblAnswer3.setText(selectedItem.answers.get(2).aBody.toString() + (selectedItem.answers.get(2).isCorrect ? " (True)" : ""));
									lblAnswer4.setText(selectedItem.answers.get(3).aBody.toString() + (selectedItem.answers.get(3).isCorrect ? " (True)" : ""));
								}
								else {
									//if there is no question display empty labels
									comboBox.setSelectedItem(null);
									lblAnswer1.setText(" ");
									lblAnswer2.setText(" ");
									lblAnswer3.setText(" ");
									lblAnswer4.setText(" ");
								}
							}
						});
		

		mediumQuestionBTN.setBackground(Color.YELLOW);
		mediumQuestionBTN.setForeground(Color.BLACK);
		GridBagConstraints gbc_MediumQuestionBTN = new GridBagConstraints();
		gbc_MediumQuestionBTN.insets = new Insets(0, 0, 5, 5);
		gbc_MediumQuestionBTN.gridx = 18;
		gbc_MediumQuestionBTN.gridy = 10;
		getContentPane().add(mediumQuestionBTN, gbc_MediumQuestionBTN);

		//display only medium question
				mediumQuestionBTN.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						easyQuestionsBTN.setForeground(Color.black);
						mediumQuestionBTN.setForeground(Color.ORANGE);
						hardQuestionBTN.setForeground(Color.black);
						allQuestionsBTN.setForeground(Color.black);
						mq.clear();
						//create array of only medium questions
						for(Question q : al ) {
							if(q.diff==2 && !mq.contains(q))
							{
								mq.add(q);
		
							}
		
						}
						comboBox.setModel(new DefaultComboBoxModel<Question>(mq.toArray(new Question[0])));
						//display the answers for each question
						if (mq.size() > 0) {
							Question selectedItem = (Question) comboBox.getSelectedItem();
							comboBox.setSelectedItem(mq.get(0));
							lblAnswer1.setText(selectedItem.answers.get(0).aBody.toString() + (selectedItem.answers.get(0).isCorrect ? " (True)" : ""));
							lblAnswer2.setText(selectedItem.answers.get(1).aBody.toString() + (selectedItem.answers.get(1).isCorrect ? " (True)" : ""));
							lblAnswer3.setText(selectedItem.answers.get(2).aBody.toString() + (selectedItem.answers.get(2).isCorrect ? " (True)" : ""));
							lblAnswer4.setText(selectedItem.answers.get(3).aBody.toString() + (selectedItem.answers.get(3).isCorrect ? " (True)" : ""));
						}
						//if there is no question display empty labels
						else {
							comboBox.setSelectedItem(null);
							lblAnswer1.setText(" ");
							lblAnswer2.setText(" ");
							lblAnswer3.setText(" ");
							lblAnswer4.setText(" ");
						}
					}
				});

		//display only hard question
		hardQuestionBTN.setBackground(Color.RED);
		GridBagConstraints gbc_HardQuestionBTN = new GridBagConstraints();
		gbc_HardQuestionBTN.insets = new Insets(0, 0, 5, 5);
		gbc_HardQuestionBTN.gridx = 19;
		gbc_HardQuestionBTN.gridy = 10;
		getContentPane().add(hardQuestionBTN, gbc_HardQuestionBTN);
		
				hardQuestionBTN.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						easyQuestionsBTN.setForeground(Color.black);
						mediumQuestionBTN.setForeground(Color.black);
						hardQuestionBTN.setForeground(Color.ORANGE);
						allQuestionsBTN.setForeground(Color.black);
						hq.clear();
						//create array of only hard questions
						for (Question q : al) {
							if (q.diff == 3 && !hq.contains(q)) {
								hq.add(q);

							}

						}


						comboBox.setModel(new DefaultComboBoxModel<Question>(hq.toArray(new Question[0])));
						//display the answers for each question
						if (hq.size() > 0) {
							Question selectedItem = (Question) comboBox.getSelectedItem();
							comboBox.setSelectedItem(hq.get(0));
							lblAnswer1.setText(selectedItem.answers.get(0).aBody.toString() + (selectedItem.answers.get(0).isCorrect ? " (True)" : ""));
							lblAnswer2.setText(selectedItem.answers.get(1).aBody.toString() + (selectedItem.answers.get(1).isCorrect ? " (True)" : ""));
							lblAnswer3.setText(selectedItem.answers.get(2).aBody.toString() + (selectedItem.answers.get(2).isCorrect ? " (True)" : ""));
							lblAnswer4.setText(selectedItem.answers.get(3).aBody.toString() + (selectedItem.answers.get(3).isCorrect ? " (True)" : ""));
						}
						//if there is no question display empty labels
						else {
							comboBox.setSelectedItem(null);
							lblAnswer1.setText(" ");
							lblAnswer2.setText(" ");
							lblAnswer3.setText(" ");
							lblAnswer4.setText(" ");
						}
					}
				});
										

				allQuestionsBTN.setForeground(Color.ORANGE);
				allQuestionsBTN.setBackground(Color.CYAN);
				GridBagConstraints gbc_allQuestionsBTN = new GridBagConstraints();
				gbc_allQuestionsBTN.insets = new Insets(0, 0, 5, 5);
				gbc_allQuestionsBTN.gridx = 20;
				gbc_allQuestionsBTN.gridy = 10;
				getContentPane().add(allQuestionsBTN, gbc_allQuestionsBTN);
		//display all questions from all levels
		allQuestionsBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				easyQuestionsBTN.setForeground(Color.black);
				mediumQuestionBTN.setForeground(Color.black);
				hardQuestionBTN.setForeground(Color.black);
				allQuestionsBTN.setForeground(Color.ORANGE);
				comboBox.setModel(new DefaultComboBoxModel<Question>(al.toArray(new Question[0])));
				//display the answers of the question
				if (al.size() > 0) {
					comboBox.setSelectedItem(al.get(0));
					Question selectedItem = (Question) comboBox.getSelectedItem();
					lblAnswer1.setText(selectedItem.answers.get(0).aBody.toString() + (selectedItem.answers.get(0).isCorrect ? " (True)" : ""));
					lblAnswer2.setText(selectedItem.answers.get(1).aBody.toString() + (selectedItem.answers.get(1).isCorrect ? " (True)" : ""));
					lblAnswer3.setText(selectedItem.answers.get(2).aBody.toString() + (selectedItem.answers.get(2).isCorrect ? " (True)" : ""));
					lblAnswer4.setText(selectedItem.answers.get(3).aBody.toString() + (selectedItem.answers.get(3).isCorrect ? " (True)" : ""));
				}
				//if there is no question display empty labels
			else
			{
					comboBox.setSelectedItem(null);
					lblAnswer1.setText(" ");
					lblAnswer2.setText(" ");
					lblAnswer3.setText(" ");
					lblAnswer4.setText(" ");
				}
			}
		});
		
								
//				JButton DeleteBTN = new JButton("Delete");
				FancyButton DeleteBTN = new FancyButton("Delete", 20f);
				GridBagConstraints gbc_DeleteBTN = new GridBagConstraints();
				gbc_DeleteBTN.insets = new Insets(0, 0, 5, 5);
				gbc_DeleteBTN.gridx = 16;
				gbc_DeleteBTN.gridy = 12;
				getContentPane().add(DeleteBTN, gbc_DeleteBTN);

				//delete selected question
				DeleteBTN.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Question selectedItem = (Question)comboBox.getSelectedItem();
						if(selectedItem==null){
							JOptionPane.showMessageDialog(null, "No question selected", "Deletion Failed", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							s.deleteQuestion(selectedItem);
							s.updateQuestionsJSON();
							System.out.println(al);
							comboBox.setModel(new DefaultComboBoxModel<Question>(al.toArray(new Question[0])));
							JOptionPane.showMessageDialog(null, "Question deleted successfully", "", JOptionPane.INFORMATION_MESSAGE);
							allQuestionsBTN.doClick();
						}
					}
				});
								
								
				// go to EditQuestionScreen in order to edit selected question
//				JButton editBTN = new JButton("Edit");
				FancyButton editBTN = new FancyButton("Edit", 20f);
				editBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Question selectedQuestion = (Question)comboBox.getSelectedItem();
						if(selectedQuestion==null){
							JOptionPane.showMessageDialog(null, "No question selected", "", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							EditQuestionScreen eqs = new EditQuestionScreen(selectedQuestion);
							dispose();
						}
					}
				});
				GridBagConstraints gbc_editBTN = new GridBagConstraints();
				gbc_editBTN.insets = new Insets(0, 0, 5, 5);
				gbc_editBTN.gridx = 23;
				gbc_editBTN.gridy = 12;
				getContentPane().add(editBTN, gbc_editBTN);

		//show the answers for the selected question that the user chose
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("item changed in combobox");
				Question selectedItem = (Question)comboBox.getSelectedItem();

				lblAnswer1.setText(selectedItem.answers.get(0).aBody.toString() + (selectedItem.answers.get(0).isCorrect ? " (True)": ""));
				lblAnswer2.setText(selectedItem.answers.get(1).aBody.toString() + (selectedItem.answers.get(1).isCorrect ? " (True)": ""));
				lblAnswer3.setText(selectedItem.answers.get(2).aBody.toString() + (selectedItem.answers.get(2).isCorrect ? " (True)": ""));
				lblAnswer4.setText(selectedItem.answers.get(3).aBody.toString() + (selectedItem.answers.get(3).isCorrect ? " (True)": ""));

			}

		});
		allQuestionsBTN.doClick();
		setVisible(true);
		//back to previous page
		   backBTN.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		             StartWindow sw = new StartWindow();
		             dispose();
		         }
		     });

	}

}
