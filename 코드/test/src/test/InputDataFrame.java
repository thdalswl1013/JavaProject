package test;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InputDataFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_hour;
	private JTextField textField_min;
	private String[] days = { "월", "화", "수", "목", "금", "토", "일" };
	private String[] category = { "수업", "시험", "과제 제출", "식사", "약속"  };
	private JTextField textField_endh;
	private JTextField textField_endm;
	
	public InputDataFrame() {
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(new Dimension(400,250));
		frame.setPreferredSize(new Dimension(400,250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(category);
		comboBox.setBounds(24, 63, 105, 23);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(238, 64, 81, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_hour = new JTextField();
		textField_hour.setBounds(123, 96, 50, 21);
		contentPane.add(textField_hour);
		textField_hour.setColumns(5);
		
		textField_min = new JTextField();
		textField_min.setBounds(209, 95, 50, 21);
		contentPane.add(textField_min);
		textField_min.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("일정 이름:");
		lblNewLabel.setBounds(164, 67, 81, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("시");
		lblNewLabel_1.setBounds(174, 99, 52, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("분");
		lblNewLabel_2.setBounds(260, 99, 52, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Write Your Plan");
		lblNewLabel_3.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		lblNewLabel_3.setBounds(49, 10, 233, 38);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox(days);
		comboBox_1.setBounds(34, 96, 50, 23);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("저장");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputDataSet temp = new InputDataSet(comboBox.getSelectedItem().toString(), textField.getText(), Integer.parseInt(textField_hour.getText()), Integer.parseInt(textField_min.getText()), Integer.parseInt(textField_endh.getText()), Integer.parseInt(textField_endm.getText()));
				DataBase.inputData(temp, comboBox_1.getSelectedIndex());
				frame.dispose();
			}
		});
		btnNewButton.setBounds(120, 160, 95, 23);
		contentPane.add(btnNewButton);
		
		frame.getContentPane().add(contentPane);
		
		textField_endh = new JTextField();
		textField_endh.setBounds(184, 129, 50, 21);
		contentPane.add(textField_endh);
		textField_endh.setColumns(10);
		
		textField_endm = new JTextField();
		textField_endm.setBounds(270, 129, 50, 21);
		contentPane.add(textField_endm);
		textField_endm.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("시");
		lblNewLabel_4.setBounds(238, 132, 52, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("분");
		lblNewLabel_5.setBounds(322, 132, 52, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("~");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_6.setBounds(164, 128, 52, 15);
		contentPane.add(lblNewLabel_6);
		
	}
}
