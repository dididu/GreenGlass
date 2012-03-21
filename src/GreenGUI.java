
import java.awt.*; 

public class GreenGUI extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArduinoInterface a;
	private ControlPanel controls;
	private GraphicsPanel display;
	
	private HeartBeat heart;
	private GreenStatus status;

	public GreenGUI() {
		super("Embedded PApplet");

		a = new ArduinoInterface();
		a.init();
		a.setVisible(false);

		status = new GreenStatus();
		
		heart = new HeartBeat(20, a, status);
		heart.start();
		
		this.setSize(600, 600);

		
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