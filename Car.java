package inheritance;

public class Car extends Object { // 보통 extends object는 생
	int speed = 0;
	String color = "white";
	String brand = "Ferrari";
	public Car() {
		System.out.println("Car()생성자 메소드");
	}
	public Car(String color, String brand) {
		this.color = color;
		this.brand = brand;
	}
	public void speedUp() {
		speed++;
		if(speed>=150) {
			speed = 150;
		}
	}
	public void speedBreak() {
		speed--;
		if(speed<=0) speed = 0;	
	}
}
