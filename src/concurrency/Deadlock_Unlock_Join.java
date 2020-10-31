package concurrency;

/**
 * ����(Deadlock)
 * 
 * �ɮ�: Deadlock.java + A.java + B.java 
 * ����: java Deadlock 
 *  �� : 1.�HCTRL + C �פ�{��
 *       2.�HCTRL + BREAK �l��"�����"�P "monitor" �� cache �O�� 3.���� Main-Thread ���s�b
 * 
 * ���}����: 
 *       1.���I���b���}����, ���I�O���n���{�����s���������i�� 
 *       2.�H���{���Ө�,�Ѱ�4��synchronized���@�Y�i
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
		b.lastB(); // ������������������������������������������������������������������������������������������������������������������������ ---> �q ClassA �I�s ClassB �� lastB() --> ��52��
	}

	synchronized void lastA() {
		String name = Thread.currentThread().getName();
		System.out.println("\t\t\t\t" + name + " �w�g���\�i�J A.lastA()..."); // ���\�i�J�ɤ~��Q�L�X
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
		a.lastA(); // ������������������������������������������������������������������������������������������������������������������������ ---> �q ClassB �I�s ClassA �� lastA() --> ��29��
	}

	synchronized void lastB() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " �w�g���\�i�J B.lastB()..."); // ���\�i�J�ɤ~��Q�L�X
	}
}

class Deadlock_Unlock_Join implements Runnable {
	A a = new A();
	B b = new B();

	Thread bThread1;  //���������
	Thread bThread2;  //�f�f�����
	
	Deadlock_Unlock_Join() {
		Thread.currentThread().setName("aThread");
		  bThread1 = new Thread(this, "bThread1-����");
		  bThread2 = new Thread(this, "bThread2-�f�f");
		  bThread1.start();
		  bThread2.start();
		a.aoo(b); // aThread �X�� (���o"a"����X��) ------------------------------------> aThread �I�s ClassA �� aoo() --> ��15��

		System.out.println("aThread �^�a�F!"); // aThread �^�a�F(�^���Ӥ~��Q�L�X)
	}

	public void run() {
		b.boo(a); // bThread �X�� (���o"b"����X��) -------------------------------------> bThread �I�s ClassB �� boo() --> ��38��
		
		if(Thread.currentThread().getName().equals("bThread1-����")){
			  //����bThread2 [�f�f�����] ���^��
		    try{bThread2.join();} catch (InterruptedException e) {}
		}
		                                                   //bThread �^�a�F(�^���Ӥ~��Q�L�X)(�ë����^�Ӫ��O���@�Ӱ����) 
		System.out.println("\t\t\t\t" + "bThread �^�a�F!"+" [�ڬO "+Thread.currentThread().getName()+"]"); // bThread �^�a�F(�^���Ӥ~��Q�L�X)
	}

	public static void main(String args[]) {
		new Deadlock_Unlock_Join();
	}
}