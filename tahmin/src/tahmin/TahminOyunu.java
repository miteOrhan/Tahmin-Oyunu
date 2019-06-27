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
		
		JFrame frameBot = new JFrame ("Tahmin Oyunu - Botun Sýrasý");
		JFrame frameUser = new JFrame ("Tahmin Oyunu - Oyuncu Sýrasý");
        
		final JButton sýraBitirBot;
        sýraBitirBot =new JButton ("Sýrayý Bitir");
		sýraBitirBot.setBounds(350, 375,120, 50);
		sýraBitirBot.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	frameUser.setVisible(true);
		    	frameBot.setVisible(false);
		    }
		});
		frameBot.add(sýraBitirBot);
		
        frameBot.setPreferredSize(new Dimension(500, 500));
        frameBot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBot.getContentPane().add(new TahminOyunuBotPanel());
        frameBot.pack();
        frameBot.setVisible(false);
		
        final JButton sýraBitirUser;
        sýraBitirUser =new JButton ("Sýrayý Bitir");
		sýraBitirUser.setBounds(350, 375,120, 50);
		sýraBitirUser.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	frameUser.setVisible(false);
		    	frameBot.setVisible(true);
		    }
		});
		frameUser.add(sýraBitirUser);
        
        frameUser.setPreferredSize(new Dimension(500, 500));
        frameUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUser.getContentPane().add(new TahminOyunuUserPanel());
        
        frameUser.pack();
        frameUser.setVisible(true);
        
	}

}
