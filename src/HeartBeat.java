
public class HeartBeat extends Thread {

	private int bpm = 30;
	private ArduinoInterface a;
	private GreenStatus status;

	public HeartBeat(int bpm, ArduinoInterface a, GreenStatus status) {
		this.bpm = bpm;
		this.a = a;
		this.status = status;
	}

	public void run() {

		while (true) {
			
			int val = a.analogRead(0);
			if (val > 0) status.setAmbientLight(val);

			System.out.println(status);

			try {
				Thread.sleep((60 * 1000)/bpm);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}