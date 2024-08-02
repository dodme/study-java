package study5;

class TvControl {

	boolean power = false; // off
	int channel = 0;

	public void power() {
		power = !power; // power(false <-> true);
	}

	public void channelUp() {
		channel += 1; // channel++;
		if (channel == 1000) {
			channel = 0;
		}
	}

	public void channelDown() {
		channel -= 1; // channel--;
		if (channel == -1) {
			channel = 999;
		}
	}
}

public class MyTv {

	public static void main(String[] args) {

		TvControl tv = new TvControl();

		tv.power();
		tv.channel = 11;
		tv.channelDown();
		System.out.println("전원상태 : " + tv.power);
		System.out.println("채널상태 : " + tv.channel);
		tv.channelUp();
		tv.channelUp();
		System.out.println("채널상태 : " + tv.channel);
		tv.power();
		System.out.println("전원상태 : " + tv.power);

	}

}
