package sample_tests;

import hw4.LiftElement;

public class LiftTest {
	public static void main(String[] args) {
		// top side at y = 100, height 10, bottom side at 90
		LiftElement l = new LiftElement(50, 100, 10, 10);
		l.setBounds(80, 110);
		l.setVelocity(0, 6);
		l.update();
		System.out.println(l.getYReal() + ", " + (l.getYReal() - 10)); // [106, 96]
		System.out.println("Velocity " + l.getDeltaY()); // 6.0
		l.update();
		System.out.println(l.getYReal() + ", " + (l.getYReal() - 10)); // [110, 90]
		System.out.println("Velocity " + l.getDeltaY()); // -6.0
		l.update();
		System.out.println(l.getYReal() + ", " + (l.getYReal() - 10)); // [104, 94]
		System.out.println("Velocity " + l.getDeltaY()); // -6.0
		l.update();
		System.out.println(l.getYReal() + ", " + (l.getYReal() - 10)); // [98, 88]
		System.out.println("Velocity " + l.getDeltaY()); // -6.0
		l.update();
		System.out.println(l.getYReal() + ", " + (l.getYReal() - 10)); // [92, 82]
		System.out.println("Velocity " + l.getDeltaY()); // -6.0
		l.update();
		System.out.println(l.getYReal() + ", " + (l.getYReal() - 10)); // [90, 80]
		System.out.println("Velocity " + l.getDeltaY()); // 6.0
		System.out.println(l.getFrameCount()); // expected 6
	}
}
