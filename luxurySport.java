package inheritance;

// extends use for class inheritance. only one class possible
public class luxurySport extends Car {
	String color = "Red";
	public luxurySport() {// 생성자메소드. 
		// 하위클래스의 생성자 메소드에서 상위클래스의 생성자 메소드 호출
		// 반드시 첫번째 실행문으로 기술해야 한다.
		super("Lightblue", "Escalade"); // this()
		System.out.println("luxurySport()생성자 메소드");
	}
	public luxurySport(String color) {
		//this.color = color;
		//상위클래스 하위클래스에 같은 멤버변수가 존재할때
		//상위클래스를 멤버면수를 지정한다.
		super.color = color;
		System.out.println(this.color+","+super.color);
	}
	// override : redefine method at child class when inherited
	public void speedUp() {
		speed += 20;
		if(speed>=300) speed = 300;
	}
	public void speedUp(int lbl) {
		speed += lbl;
		if(speed>=300) speed = 300;
	}
	/*
	public static void main(String a[]) {
		//상속관계에서 생성자 메소드 상위클래스의 생성자가 먼저 실행된다.
		luxurySport l = new luxurySport(); // 생성자메소드가 실행됨.
		System.out.println("color = " +l.color);
		l.speedUp();
		System.out.println("speed = "+l.speed);
		///////////////////////////
		luxurySport ll = new luxurySport("Green");
		System.out.println("luxurySport.color = " +ll.color);
	}
	*/
}
