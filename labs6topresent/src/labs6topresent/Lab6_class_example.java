package labs6topresent;
import java.util.Scanner;
public class Lab6_class_example {
	
	
	
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			Weather w1 = createWeatherObject(scan);
			Weather w2 = createWeatherObject(scan);
			Weather prefered;
			Weather notPrefered;
			if(w1.temperature > w2.temperature) {
				prefered = w1;
				notPrefered = w2;
				warmUp(w2);
			} else {
				prefered = w2;
				notPrefered = w1;
				warmUp(w1);
			}
			System.out.println("I prefer " + prefered.temperature +
					" " + prefered.forecast);
			System.out.println("I don't like " + notPrefered.temperature +
					" " + notPrefered.forecast);
			
			
		}
		
		public static Weather createWeatherObject(Scanner scan) {
			Weather w1 = new Weather();
			w1.temperature = scan.nextInt();
			//if you want temperature and forecast on the same line,
			//comment out this next line:
			scan.nextLine();
			w1.forecast = scan.nextLine();
			return w1;
		}
		
		public static void warmUp(Weather w) {
			w.temperature += 10;
		}
	}

	class Weather {
		int temperature;
		String forecast; 
	}

