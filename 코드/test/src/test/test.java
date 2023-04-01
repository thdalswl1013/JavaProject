package test;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.*;
import java.awt.*;


public class test {
	public static void main(String[] args) {
	   try {
		   UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	   }
	   catch (Exception e) {}
	   DataIndicator indicatorFrame = new DataIndicator();
	   Toolkit toolkit = indicatorFrame.getToolkit();
	   indicatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   indicatorFrame.setVisible(true);
   }
}