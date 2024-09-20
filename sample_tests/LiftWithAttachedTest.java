package sample_tests;

import hw4.AttachedElement;
import hw4.LiftElement;

public class LiftWithAttachedTest {
	public static void main(String[] args) {
		// top side at y = 100, height 10, bottom side at 90
		LiftElement l = new LiftElement(50, 100, 10, 10);
		l.setBounds(80, 110);
		l.setVelocity(0, 6);

		// size 5 x 5, offset 2 units from left of platform, 15 above
		AttachedElement c = new AttachedElement(5, 5, 2, 15);

		// this should automatically make p the base of c
		l.addAssociated(c);

		// x position should be the base position + 2 = 52
		// y position should be base y - attached element height - hover = 80
		System.out.println(c.getXReal()); // expected 52
		System.out.println(c.getYReal()); // expected 80
		l.update();
		System.out.println(c.getXReal()); // expected 52
		System.out.println(c.getYReal()); // expected 86
		l.update();
		System.out.println(c.getXReal()); // expected 52
		System.out.println(c.getYReal()); // expected 90

		// calling update on p should update associated elements too
		System.out.println(c.getFrameCount()); // expected 2
	}
}
