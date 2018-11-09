import javax.swing.JFrame;

public class MyFrame extends JFrame {

	static int W_FRAME = 548;
	static int H_FRAME = 570;

	public MyFrame(){
		setTitle("Game Tank 90");
		setSize(W_FRAME, H_FRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyPanel panel = new MyPanel();
		add(panel);
		
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}
}
