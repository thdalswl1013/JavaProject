package test;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;


class DataIndicator extends JFrame {
	private String[] days = { "��", "ȭ", "��", "��", "��", "��", "��" };
	
	private JPanel contentPane;
	private StringBuilder schedules = new StringBuilder();
	private StringBuilder schedulesToRead = new StringBuilder();
	private JButton btnNewButton;

	private static int dayOfWeek;
	private static int hour;
	private static int min;
	
	private int selectedIndex;
	/**
	 * Launch the application.
	 */
	
	public void run() {
		try {
			DataIndicator frame = new DataIndicator();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public DataIndicator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("���ʷҹ���", Font.PLAIN, 17));
		lblNewLabel.setBounds(311, 319, 219, 33);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(36, 165, 200, 187);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(36, 406, 495, 147);
		contentPane.add(textArea_1);
		
		btnNewButton = new JButton("���� �ð� �ҷ�����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				hour = cal.get(Calendar.HOUR_OF_DAY);
				min = cal.get(Calendar.MINUTE);
				dayOfWeek = (cal.get(Calendar.DAY_OF_WEEK) - 2) % 7;
				String day = intToDay(dayOfWeek);
				lblNewLabel.setText(String.format("���� �ð� : %s���� %02d : %02d", day, hour, min));
			}
		});
		btnNewButton.setBounds(355, 286, 150, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox(days);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int index = cb.getSelectedIndex();
				if (index == 0) {
					for(InputDataSet i : DataBase.DB_mon) {
						schedules.append(i.toString(i));
					}
				}
				else if(index == 1) {
					for(InputDataSet i : DataBase.DB_tus) {
						schedules.append(i.toString(i));
					}
				}
				else if(index == 2) {
					for(InputDataSet i : DataBase.DB_wed) {
						schedules.append(i.toString(i));
					}
				}
				else if(index == 3) {
					for(InputDataSet i : DataBase.DB_thu) {
						schedules.append(i.toString(i));
					}
				}
				else if(index == 4) {
					for(InputDataSet i : DataBase.DB_fri) {
						schedules.append(i.toString(i));
					}
				}
				else if(index == 5) {
					for(InputDataSet i : DataBase.DB_sat) {
						schedules.append(i.toString(i));
					}
				}
				else if(index == 6) {
					for(InputDataSet i : DataBase.DB_sun) {
						schedules.append(i.toString(i));
					}
				}
				textArea.setText(schedules.toString());
				schedules.delete(0, schedules.length());
				selectedIndex = index;
			}
		});
		comboBox.setBounds(36, 132, 200, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("���� ����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new InputDataFrame();
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(355, 132, 150, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("���� �о��ֱ�");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dayInfo = intToDay(selectedIndex);
				int remainMin = selectedIndex*1440 - dayOfWeek*1440 - hour*60 - min;		
				if(remainMin<0) {
					schedulesToRead.append(String.format("%s���� ���� �Դϴ�. %s���� ������ �������ϴ�.\n", dayInfo, dayInfo));
				}
				else {
					schedulesToRead.append(String.format("%s���� ���� �Դϴ�. %s���� ������ �Ǳ� ���� %d�� %d�ð� %d�� ���ҽ��ϴ�.\n", dayInfo, dayInfo, remainMin/1440, (remainMin%1440)/60, (remainMin%1440)%60));
				}
				
				if (selectedIndex == 0) {
					for(InputDataSet i : DataBase.DB_mon) {
						schedulesToRead.append(i.toStringToRead(i));
					}
				}
				else if(selectedIndex == 1) {
					for(InputDataSet i : DataBase.DB_tus) {
						schedulesToRead.append(i.toStringToRead(i));
					}
				}
				else if(selectedIndex == 2) {
					for(InputDataSet i : DataBase.DB_wed) {
						schedulesToRead.append(i.toStringToRead(i));
					}
				}
				else if(selectedIndex == 3) {
					for(InputDataSet i : DataBase.DB_thu) {
						schedulesToRead.append(i.toStringToRead(i));
					}
				}
				else if(selectedIndex == 4) {
					for(InputDataSet i : DataBase.DB_fri) {
						schedulesToRead.append(i.toStringToRead(i));
					}
				}
				else if(selectedIndex == 5) {
					for(InputDataSet i : DataBase.DB_sat) {
						schedulesToRead.append(i.toStringToRead(i));
					}
				}
				else if(selectedIndex == 6) {
					for(InputDataSet i : DataBase.DB_sun) {
						schedulesToRead.append(i.toStringToRead(i));
					}
				}
				textArea_1.setText(schedulesToRead.toString());
				//*********************************************
				// schedulesToRead.toString() �� �о��ְ� �ϸ� ��!
				//*********************************************
				mp3(schedulesToRead.toString(), "Minji");
				Audio Minji = new Audio("Minji");
				Minji.play();
				schedulesToRead.delete(0, schedulesToRead.length());
			}
		});
		btnNewButton_2.setBounds(62, 376, 150, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Being   Jae-Hyeok Kang");
		lblNewLabel_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		lblNewLabel_1.setBounds(131, 22, 330, 50);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("���� ���� �ҷ�����");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataBase.resetDB();
					DataBase.readPlanFromFile();
				}
				catch(Exception readError) {
					readError.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(36, 82, 140, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("���� ���� �����ϱ�");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataBase.writeToFile();
				}
				catch(Exception writeError) {
					writeError.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(365, 82, 140, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("���� �ʱ�ȭ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.resetDB();
			}
		});
		btnNewButton_5.setBounds(218, 82, 110, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("DB ����(�ð� ����)");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase.sortData();
			}
		});
		btnNewButton_6.setBounds(355, 204, 150, 23);
		contentPane.add(btnNewButton_6);
	}
	
	public String intToDay(int dayOfWeek) {
		String output = "�ʱ�ȭ";
		switch(dayOfWeek) {
		case 0:
			output = "��";
			break;
		case 1:
			output = "ȭ";
			break;
		case 2:
			output = "��";
			break;
		case 3:
			output = "��";
			break;
		case 4:
			output = "��";
			break;
		case 5:
			output = "��";
			break;
		case 6:
			output = "��";
			break;
		}
		return output;
	}
	
	public void mp3(String text, String file)
	{
		String clientId = "366hj8sit4";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
	    String clientSecret = "IDl57ezs27AwtkJyzPyYUHwE5idnVMIoRUhu1UFm";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
	    try {
	        text = URLEncoder.encode(text, "UTF-8"); // 13��
	        String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	        con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	        // post request
	        String postParams = "speaker=jinho&speed=2&format=wav&text=" + text;
	        con.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	        wr.writeBytes(postParams);
	        wr.flush();
	        wr.close();
	        int responseCode = con.getResponseCode();
	        BufferedReader br;
	        if(responseCode==200) { // ���� ȣ��
	            InputStream is = con.getInputStream();
	            int read = 0;
	            byte[] bytes = new byte[1024];
	            // ������ �̸����� mp3 ���� ����
	            
	            File f = new File(file + ".wav");
	            f.createNewFile();
	            OutputStream outputStream = new FileOutputStream(f);
	            while ((read =is.read(bytes)) != -1) {
	                outputStream.write(bytes, 0, read);
	            }
	            is.close();
	        } else {  // ���� �߻�
	            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

}
