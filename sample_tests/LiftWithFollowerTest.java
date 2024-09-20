package sample_tests;

import hw4.FollowerElement;
import hw4.LiftElement;
import hw4.PlatformElement;

public class LiftWithFollowerTest {
	public static void main(String[] args) {
		// first try an example where the base doesn't move
		// top side at y = 200, height 10, bottom side at 190
		LiftElement l = new LiftElement(50, 200, 10, 10);
		l.setBounds(180, 210);

		// size 5 x 5, initial offset 2 units from left of platform
		FollowerElement e = new FollowerElement(5, 5, 2);
		e.setVelocity(2, 0);

		// this should automatically make l the base of e
		// and the left and right sides of l the boundaries of e
		l.addAssociated(e);
		System.out.println(e.getMin()); // 50
		System.out.println(e.getMax()); // 60

		// x position should be the base position + 2 = 52
		// y position should be base y - follower height = 195
		System.out.println(e.getXReal()); // expected 52
		System.out.println(e.getYReal()); // expected 195

		// platform doesn't move here, but follower does
		l.update();
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 54, 59
		System.out.println(e.getDeltaX()); // expected 2.0
		l.update();
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 55, 60
		System.out.println(e.getDeltaX()); // expected -2.0
		System.out.println();

		// next, what if lift is moving, but follower velocity is 0?
		// top side at x = 200, height 10, bottom side at 190
		l = new LiftElement(50, 200, 10, 10);
		l.setBounds(180, 210);
		l.setVelocity(0, 3);

		// size 5 x 5, initial offset 2 units from left of platform
		e = new FollowerElement(5, 5, 2);
		l.addAssociated(e);
		System.out.println(e.getYReal() + ", " + (e.getYReal() - 5)); // expected 195, 190

		// when b moves, the boundaries of e shouldn't shift
		l.update();
		System.out.println("bounds " + e.getMin() + ", " + e.getMax()); // 50, 60

		// when l moves, the height of e should shift
		System.out.println(e.getYReal() + ", " + (e.getYReal() - 5)); // expected 198, 193
		System.out.println();

		// next, what if platform is moving, and follower velocity is nonzero?
		// top side at x = 200, height 10, bottom side at 190
		l = new LiftElement(50, 200, 10, 10);
		l.setBounds(180, 210);
		l.setVelocity(0, 3);
		// size 5 x 5, initial offset 2 units from left of platform
		e = new FollowerElement(5, 5, 2);
		e.setVelocity(2, 0);
		l.addAssociated(e);
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 52,57
		l.update();
		// e is now 4 units from left bound, since its velocity is 2
		System.out.println("bounds " + e.getMin() + ", " + e.getMax()); // 50, 60
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // 54, 59
		// when l moves, the height of e should shift
		System.out.println(e.getYReal() + ", " + (e.getYReal() - 5)); // expected 198, 193
		l.update();
		// hits the right boundary at 60 and reverses direction
		System.out.println("bounds " + e.getMin() + ", " + e.getMax()); // 50, 60
		System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // 55, 60
		System.out.println("velocity " + e.getDeltaX()); // expected -2
	}
}
