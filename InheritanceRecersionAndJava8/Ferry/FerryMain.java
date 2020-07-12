package mj223vn_assign1.exercise2;
/**
 * A program simulating a ferry boarding cars, buses, lorrys, bikes and passengers. 
 * And printing money earned from each trip and total
 * @author Marcus
 */
import java.util.Random;


public class FerryMain  {
	
	public static int ID = 0;
	public static void main(String[] args) {
		TheFerry ferry = new TheFerry();
		Random rand = new Random();
		int journeys = 0;
		while( journeys < 5) {
	 		while(ferry.hasSpaceFor(new Bike())) {
	 			
				switch(rand.nextInt(4)) {
				case 0: Car cars = new Car();
				for(int i = 0; i < rand.nextInt(4); i++) {
					cars.addPassenger(new Passenger());
				}
				ferry.embark(cars);
				break;
				case 1: Bus buses = new Bus();
				for(int i = 0; i < rand.nextInt(20); i++) {
					buses.addPassenger(new Passenger());
				}
				ferry.embark(buses);
				break;
				case 2: Lorry lorrys = new Lorry();
				for(int i = 0; i < 1; i++) {
					lorrys.addPassenger(new Passenger());
				}
				ferry.embark(lorrys);
				break;
				case 3: Bike bikes = new Bike();
				bikes.addPassenger(new Passenger());
				ferry.embark(bikes);
				break;
				case 4: Passenger passengers = new Passenger();
				ferry.embark(passengers);
				}
			}
	 	System.out.println("Money after trip " + (journeys+1) + " " + ferry.countMoney() + " kr");	
 		ferry.disembark();
 		journeys++;
		}
		System.out.println();
		System.out.println("Total money: " + ferry.countMoney() + " kr");	
	}

}
