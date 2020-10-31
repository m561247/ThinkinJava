package concurrency;

/**
 * 死結(Deadlock)
 * 
 * 檔案: Deadlock.java + A.java + B.java 
 * 執行: java Deadlock 
 *  註 : 1.以CTRL + C 終止程式
 *       2.以CTRL + BREAK 追蹤"執行緒"與 "monitor" 的 cache 記錄 3.提醒 Main-Thread 的存在
 * 
 * 打開死結: 
 *       1.重點不在打開死結, 重點是不要讓程式內存有死結的可能 
 *       2.以此程式而言,解除4個synchronized之一即可
 */

class A {
  /*synchronized*/   void aoo(B b) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered A.aoo()");

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("A Interrupted");
		}

		System.out.println(name + " trying to call B.lastB()...");
		b.lastB(); // ●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●● ---> 從 ClassA 呼叫 ClassB 的 lastB() --> 第52行
	}

	synchronized void lastA() {
		String name = Thread.currentThread().getName();
		System.out.println("\t\t\t\t" + name + " 已經成功進入 A.lastA()..."); // 成功進入時才能被印出
	}
}



class B {
	synchronized void boo(A a) {
		String name = Thread.currentThread().getName();
		System.out.println("\t\t\t\t" + name + " entered B.boo()");

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("B Interrupted");
		}

		System.out.println("\t\t\t\t" + name + " trying to call A.lastA()...");
		a.lastA(); // ●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●● ---> 從 ClassB 呼叫 ClassA 的 lastA() --> 第29行
	}

	synchronized void lastB() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " 已經成功進入 B.lastB()..."); // 成功進入時才能被印出
	}
}

class Deadlock_Unlock_Join implements Runnable {
	A a = new A();
	B b = new B();

	Thread bThread1;  //哥哥執行緒
	Thread bThread2;  //妹妹執行緒
	
	Deadlock_Unlock_Join() {
		Thread.currentThread().setName("aThread");
		  bThread1 = new Thread(this, "bThread1-哥哥");
		  bThread2 = new Thread(this, "bThread2-妹妹");
		  bThread1.start();
		  bThread2.start();
		a.aoo(b); // aThread 出門 (取得"a"的鎖出門) ------------------------------------> aThread 呼叫 ClassA 的 aoo() --> 第15行

		System.out.println("aThread 回家了!"); // aThread 回家了(回的來才能被印出)
	}

	public void run() {
		b.boo(a); // bThread 出門 (取得"b"的鎖出門) -------------------------------------> bThread 呼叫 ClassB 的 boo() --> 第38行
		
		if(Thread.currentThread().getName().equals("bThread1-哥哥")){
			  //控制bThread2 [妹妹執行緒] 先回來
		    try{bThread2.join();} catch (InterruptedException e) {}
		}
		                                                   //bThread 回家了(回的來才能被印出)(並指明回來的是那一個執行緒) 
		System.out.println("\t\t\t\t" + "bThread 回家了!"+" [我是 "+Thread.currentThread().getName()+"]"); // bThread 回家了(回的來才能被印出)
	}

	public static void main(String args[]) {
		new Deadlock_Unlock_Join();
	}
}