/**
 * @author Aresu Matteo 4Cinf
 * @version 2.0, Last Update 02/02/2020
 */

//set import
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//definizione classe
public class DiceRoll {
	
	//attributi globali
	static JLabel ud, c;
	
	//programma principale
	public static void main (String args[]) {

		//sezione dichiarativa
		JFrame frame;
		JButton button[], cancella;
		JPanel p1, p2, p3, p4;

		//sezione esecutiva
		//creazione finestra
		frame = new JFrame ("Dice Roll 2.0");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600,450);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.darkGray);

		//creazione primo panel
		p1 = new JPanel ();
		frame.getContentPane().add(p1);
		p1.setBorder(BorderFactory.createTitledBorder("Dadi"));
		p1.setLocation(0,0);
		p1.setSize(600,100);
		button = new JButton [7];
		button[0] = new JButton ("D4");
		button[1] = new JButton ("D6");
		button[2] = new JButton ("D8");
		button[3] = new JButton ("D10");
		button[4] = new JButton ("D12");
		button[5] = new JButton ("D20");
		button[6] = new JButton ("D100");
		for (int cont = 0; cont < 7; cont++) {
			p1.add(button[cont]);
			switch (cont) {
				case 0:
				button[cont].addActionListener(new DiceListener(4));
				break;
				
				case 1:
				button[cont].addActionListener(new DiceListener(6));
				break;
				
				case 2:
				button[cont].addActionListener(new DiceListener(8));
				break;
				
				case 3:
				button[cont].addActionListener(new DiceListener(10));
				break;
				
				case 4:
				button[cont].addActionListener(new DiceListener(12));
				break;
				
				case 5:
				button[cont].addActionListener(new DiceListener(20));
				break;
				
				case 6:
				button[cont].addActionListener(new DiceListener(100));
				break;
			}			
			
		}
		//p1.setBackground(Color.darkGray);
		
		//creazione secondo panel
		p2 = new JPanel ();
		frame.getContentPane().add(p2);
		p2.setBorder(BorderFactory.createTitledBorder("Ultimo dado lanciato"));
		p2.setLocation(0,100);
		p2.setSize(600,100);
		ud = new JLabel("0");
		p2.add(ud);
		
		//creazione terzo panel
		p3 = new JPanel ();
		frame.getContentPane().add(p3);
		p3.setBorder(BorderFactory.createTitledBorder("Cronologia dei dadi lanciati"));
		p3.setLocation(0,200);
		p3.setSize(600,100);
		c = new JLabel ("");
		p3.add(c);
		
		//creazione quarto panel
		p4 = new JPanel ();
		frame.getContentPane().add(p4);
		p4.setBorder(BorderFactory.createTitledBorder("Impostazioni"));
		p4.setLocation(0,300);
		p4.setSize(600,100);
		cancella = new JButton ("Cancella la cronologia");
		p4.add(cancella);
		cancella.addActionListener(new DeleteListener ());
	   
		//direttive finali
		frame.setVisible(true);
		
	}
	
	//classe annidata per il lancio dei dadi
	private static class DiceListener implements ActionListener{
		//attributi variabili
		private int tipo, ris;
		
		//metodi costruttori
		public DiceListener(int tipo) {
			this.tipo = tipo;
			ris = 0;
		}
		
		//metodo pulsante
		public void actionPerformed (ActionEvent event) {
			Dado dado = new Dado (1, tipo);
			ris = dado.lancia();
			ud.setText(""+ris);
			c.setText(c.getText() + ris + ", ");
		}
		
	}
	
	//classe annidata per cancellare la cronologia
	private static class DeleteListener implements ActionListener{
		//metodo costruttore
		public DeleteListener () { }
		
		//metodo pulsante
		public void actionPerformed (ActionEvent event) {
			c.setText("");
			
		}
		
	}

}
