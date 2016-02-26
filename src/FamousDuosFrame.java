import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class FamousDuosFrame extends JFrame {
	private static String[] person1 = {"THELMA","HARRY","BATMAN","ANTONY","ROMEO","BONNIE","PINKY","SIMON","BEAUTY","BEAVIS","ROCKY","ABBOT","DR. JEKYLL","SAMSON","BUTCH CASSIDY","BILL","DAVID","SHERLOCK HOLMES","JAY","ANNA","CALVIN","TIMON","MARY-KATE","MARIO"};
	private static String[] person2 = {"LOUISE","SALLY","ROBIN","CLEOPATRA","JULIET","CLYDE","THE BRAIN","GARFUNKEL","BEAST","BUTTHEAD","BULLWINKLE","COSTELLO","MR. HYDE","DELILAH","THE SUNDANCE KID","TED","GOLIATH","WATSON","SILENT BOB","THE KING","HOBBES","PUMBAA","ASHLEY OLSEN","LUIGI"};
	private JLabel[] leftLArr, rightLArr;
	private Random r;
	public FamousDuosFrame() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/xkcdicon.png"));
		r = new Random();
		setSize(500, 700);
		setLocationRelativeTo(null);
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/xkcd-Regular.otf")));
		} catch (Exception e) {
			//font not found, using default
		}
		JPanel panelFiller = new JPanel();
		panelFiller.setLayout(new GridBagLayout());
		panelFiller.addMouseListener(new MouseClicker());
		panelFiller.setOpaque(true);
		panelFiller.setBackground(Color.white);
		
		//setBackground(Color.red);
		Font f = new Font("xkcd-Regular", Font.PLAIN, 25);
		GridBagConstraints gbc = new GridBagConstraints();
		//gbc.gridwidth = 3;
		gbc.gridheight = person1.length;
		leftLArr = new JLabel[person1.length];
		rightLArr = new JLabel[person2.length];
		for (int index = 0; index < person1.length; index++) {
			JLabel leftL = new JLabel(person1[index], JLabel.RIGHT);
			JLabel centerL = new JLabel(" AND ");
			centerL.setForeground(Color.gray);
			JLabel rightL = new JLabel(person2[index], JLabel.LEFT);
			leftL.setFont(f);
			centerL.setFont(f);
			rightL.setFont(f);
			leftLArr[index] = leftL;
			rightLArr[index] = rightL;
			
			gbc.gridx = 0;
			panelFiller.add(leftL, gbc);
			gbc.gridx = 1;
			panelFiller.add(centerL, gbc);
			gbc.gridx = 2;
			panelFiller.add(rightL, gbc);

		}
		add(panelFiller);
		setVisible(true);
	}
	public void refresh() {
		int[] newIndexes = UniqueShuffle(leftLArr.length);
		for (int index = 0; index < leftLArr.length; index++) {
			//System.out.println(leftLArr[index].getText() + " AND " + rightLArr[index].getText());
			rightLArr[index].setText(person2[newIndexes[index]]);
		}
	}
	public int[] UniqueShuffle(int length) {
		int[] newIndexes = new int[length];
		for (int i = 0; i < length; i++) newIndexes[i] = i;
		for (int i = 0; i < length; i++) {
			int newIndex = r.nextInt(length - 1);
			int temp = newIndexes[i];
			newIndexes[i] = newIndexes[newIndex];
			newIndexes[newIndex] = temp;
		}
		return newIndexes;
	}
	
	public static void main(String[] args) {
		FamousDuosFrame f = new FamousDuosFrame();
	}
	public class MouseClicker implements MouseListener {
		public void mousePressed(MouseEvent e){
			refresh();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
	}
		
}
