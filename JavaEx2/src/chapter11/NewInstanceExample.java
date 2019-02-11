package chapter11;

import java.util.Random;

public class NewInstanceExample {
	public static void main(String[] args) {
		Class[] clazz = { chapter11.ReceiveAction.class, chapter11.SendAction.class };
		try {
			Action action = (Action) clazz[0].newInstance();
			action.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//Class[] clazz = { TimeBoomb.class, Boomb.class, Mine.class, Missile.class };
//Boombable[] boombs = new Boombable[4];
//
//Random r = new Random();
//
//int sel = r.nextInt(clazz.length);
//boombs[i] = (Boombable)clazz[sel].newInstance();