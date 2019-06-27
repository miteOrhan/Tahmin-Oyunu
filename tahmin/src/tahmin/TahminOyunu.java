package tahmin;
import java.util.Arrays;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tahmin.TahminOyunuBotPanel;
//import tahmin.TahminOyunuBotPanel.TahminBotListener;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;


public class TahminOyunu extends JPanel{

	public static void main(String[] args) {
		
		JFrame frameBot = new JFrame ("Tahmin Oyunu - Botun S�ras�");
		JFrame frameUser = new JFrame ("Tahmin Oyunu - Oyuncu S�ras�");
        
		final JButton s�raBitirBot;
        s�raBitirBot =new JButton ("S�ray� Bitir");
		s�raBitirBot.setBounds(350, 375,120, 50);
		s�raBitirBot.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	frameUser.setVisible(true);
		    	frameBot.setVisible(false);
		    }
		});
		frameBot.add(s�raBitirBot);
		
        frameBot.setPreferredSize(new Dimension(500, 500));
        frameBot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBot.getContentPane().add(new TahminOyunuBotPanel());
        frameBot.pack();
        frameBot.setVisible(false);
		
        final JButton s�raBitirUser;
        s�raBitirUser =new JButton ("S�ray� Bitir");
		s�raBitirUser.setBounds(350, 375,120, 50);
		s�raBitirUser.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	frameUser.setVisible(false);
		    	frameBot.setVisible(true);
		    }
		});
		frameUser.add(s�raBitirUser);
        
        frameUser.setPreferredSize(new Dimension(500, 500));
        frameUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUser.getContentPane().add(new TahminOyunuUserPanel());
        
        frameUser.pack();
        frameUser.setVisible(true);
        
	}

}
