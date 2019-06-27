package tahmin;
import java.util.*;
import java.awt.geom.Arc2D;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

import java.lang.Math;

//import tahmin.TahminOyunuUserPanel.TahminUserListener;

public class TahminOyunuUserPanel extends JPanel {
	//tahmin bot için variablelar
	
	//tahmin user methodu için variablelar
	static int nt,at=0,bt=0,ct=0,dt=0,a1t=0,b1t=0,c1t=0,d1t=0,Bt=0,Ct,ch=0;
	public JTextField tahminKutu;
	
	public JButton push3;
	JLabel label = new JLabel();
	
	static int y=-50;
	
	Scanner scanIn = new Scanner(System.in);
	Random rand = new Random();
	
	public TahminOyunuUserPanel()
    {
		
		setLayout(null);
		tahminKutu = new JTextField(5);
		tahminKutu.setBounds(300, 170,50, 30);
		add(tahminKutu);
		
		label.setBounds(190, 170,200, 30);
		label.setText("Tahmininizi giriniz:");
		add(label);
		
		push3 =new JButton ("Tahmin Et");
		push3.setBounds(300, 50,150, 50);
		add(push3);
		push3.addActionListener(new TahminUserListener());
		
		
    }
	public void tahminUser() {
		
	{
		
		JLabel labelTahminSonuç = new JLabel();
        JLabel artýEksi = new JLabel();
        JLabel çizgi = new JLabel();    
		String text = tahminKutu.getText();	
    		
    	while((at==bt||at==ct||at==dt||bt==ct||bt==dt||ct==dt)&&at==0)
    	{
    		dt=Math.abs(rand.nextInt()%10);
    		ct=Math.abs(rand.nextInt()%10);
    		bt=Math.abs(rand.nextInt()%10);
    		at=Math.abs(rand.nextInt()%10);
    	}	
    	while(Bt!=4)
    	{
    		nt=0;
    		while(a1t==b1t||a1t==c1t||a1t==d1t||b1t==c1t||b1t==d1t||c1t==d1t||nt<123||nt>9876)
    		{
    			
    			nt=Integer.parseInt(text);
    			d1t=nt%10;
    			c1t=(nt/10)%10;
    			b1t=(nt/100)%10;
    			a1t=(nt/1000)%10;
    				
    		}	
    		Bt=0;Ct=0;
    		if(a1t==bt||a1t==ct||a1t==dt) {Ct++;} else if(a1t==at) {Bt++;}
    		if(b1t==at||b1t==ct||b1t==dt) {Ct++;} else if(b1t==bt) {Bt++;}
    		if(c1t==bt||c1t==at||c1t==dt) {Ct++;} else if(c1t==ct) {Bt++;}
    		if(d1t==bt||d1t==ct||d1t==at) {Ct++;} else if(d1t==dt) {Bt++;}
    		ch++;
    		System.out.printf("Artý\tEksi\n %d \t %d\n",Bt,Ct);
    		if(Bt==4) {
    			removeAll();
    			repaint();
    			JLabel tebrik = new JLabel();
    			tebrik.setBounds(90, 170,500, 30);
    			add(tebrik);
    			tebrik.setText("Tebrikler! "+ch+ " hamlede bildin.");
    			
    			
    			
    		}	
    		break;
    		}
    	
    	y=y+60;
		
        
		labelTahminSonuç.setBounds(10, y,200, 30);
		artýEksi.setBounds(10, y+20,200, 30);
		çizgi.setBounds(10, y+40,200, 30);
		labelTahminSonuç.setText("Tahmin "+(ch+1)+": "+text);
		artýEksi.setText(" Artý: "+(Bt)+" Eksi: "+Ct);
		çizgi.setText("---------------");
		add(labelTahminSonuç);
		add(artýEksi);
		add(çizgi);
		labelTahminSonuç.repaint();
		artýEksi.repaint();
		çizgi.repaint();
            
        } 
		
	}
	
	
	
	private class TahminUserListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
        	tahminUser();
        }   
        
        
    }
	
	   
	
}
