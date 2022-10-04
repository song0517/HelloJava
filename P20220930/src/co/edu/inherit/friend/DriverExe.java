package co.edu.inherit.friend;

public class DriverExe {
	public static void main(String[] args) {
		Car car = new Car();
		Bus bus = new Bus();
		
		//동일한 기능을 실행하는데 다른 결과가 나타나는 것.
		//동일한 driver 메소드를 통해 다양한 기능을 실행.
		Driver driver = new Driver();
		driver.drive(car);  //Vehicle 인스턴스가 매개값으로.
		driver.drive(bus);
	}
}
