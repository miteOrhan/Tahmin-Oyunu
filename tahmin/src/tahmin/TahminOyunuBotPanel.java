package tahmin;
import java.util.*;
import java.awt.geom.Arc2D;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.lang.Math;

//import tahmin.TahminOyunuBotPanel.TahminUserListener;

public class TahminOyunuBotPanel extends JPanel {
	//tahmin bot için variablelar
	static int n,B1,C1,j;
	static int i=0;
	static int a[]=new int[10],
			b[]=new int[10],
			c[]=new int[10],
			d[]=new int[10],
			B[]=new int[10],
			C[]=new int[10];
	
	public JButton push;
	public JButton push2;
	
	
	
	Scanner scanIn = new Scanner(System.in);
	Random rand = new Random();
	
	public TahminOyunuBotPanel()
    {
		Arrays.fill(a, 1);
		Arrays.fill(b, 1);
		Arrays.fill(c, 1);
		Arrays.fill(d, 1);
		Arrays.fill(B, 1);
		Arrays.fill(C, 1);
		
		setLayout(null);
		
		push =new JButton ("Bottan Yeni Tahmin Al");
		push.setBounds(50, 50,200, 50);
		add(push);
		push.addActionListener(new TahminBotListener());
		
		
		i=0;
    }
	
	
	
	public void tahminBot() {
		
		if(B[B.length-1]!=4)
		{
			a[i]=0;b[i]=0;
			while(a[i]==b[i]||a[i]==c[i]||a[i]==d[i]||b[i]==c[i]||b[i]==d[i]||c[i]==d[i])
			{
				d[i]=Math.abs(rand.nextInt()%10);
				c[i]=Math.abs(rand.nextInt()%10);
				b[i]=Math.abs(rand.nextInt()%10);
				a[i]=Math.abs(rand.nextInt()%10);
			}	
			for(j=0;j<i;j++)
			{
				B1=0;C1=0;
				if(a[j]==b[i]||a[j]==c[i]||a[j]==d[i]) {C1=C1+1;}else if(a[j]==a[i]) {B1=B1+1;}
				if(b[j]==a[i]||b[j]==c[i]||b[j]==d[i]) {C1=C1+1;}else if(b[j]==b[i]) {B1=B1+1;}
				if(c[j]==b[i]||c[j]==a[i]||c[j]==d[i]) {C1=C1+1;}else if(c[j]==c[i]) {B1=B1+1;}
				if(d[j]==b[i]||d[j]==c[i]||d[j]==a[i]) {C1=C1+1;}else if(d[j]==d[i]) {B1=B1+1;}
				if(B1!=B[j]||C1!=C[j])
				{
					a[i]=0;b[i]=0;
					while(a[i]==b[i]||a[i]==c[i]||a[i]==d[i]||b[i]==c[i]||b[i]==d[i]||c[i]==d[i])
					{
						d[i]=Math.abs(rand.nextInt()%10);
						c[i]=Math.abs(rand.nextInt()%10);
						b[i]=Math.abs(rand.nextInt()%10);
						a[i]=Math.abs(rand.nextInt()%10);
					}
					j=-1;
				}	
			}
			System.out.printf("\nTahmin : %d%d%d%d\n",a[i],b[i],c[i],d[i]);
			System.out.printf("Artý   : ");
			
			B[i]=scanIn.nextInt();
			if(B[i]!=4)
			{
				System.out.printf("Eksi   : ");
				C[i]=scanIn.nextInt();
			}
			else {
				removeAll();
    			repaint();
    			JLabel label = new JLabel();
    			label.setBounds(70, 170,500, 30);
    			add(label);
    			label.setText("\nBen kazandým. Tuttuðun "+a[i]+""+b[i]+""+c[i]+""+d[i]+ " sayýsýný "+ (i+1) +" hamlede bildim.");
				push.setVisible(false);
			}	
		}i++;
		
		
	}
	
	
	
	private class TahminBotListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
        	tahminBot();
        }   
        
        
    }    
	
	
	
}
