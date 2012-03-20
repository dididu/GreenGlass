
import java.awt.*; 

public class GreenGUI extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArduinoInterface a;
	private ControlPanel controls;
	private GraphicsPanel display;

	public GreenGUI() {
		super("Embedded PApplet");
		this.setSize(600, 600);

		a = new ArduinoInterface();
		a.init();
		a.setVisible(false);
		
		controls = new ControlPanel(a);
		display = new GraphicsPanel();

		setLayout(new BorderLayout());
		
		add(display, BorderLayout.CENTER);
		add(controls, BorderLayout.EAST);
	}
	
	public static void main(String args[]) {
		GreenGUI gui = new GreenGUI();
		gui.setVisible(true);
	}

}