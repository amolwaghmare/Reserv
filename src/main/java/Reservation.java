public class Reservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String contains the reservation seats in a plane.
		String bookedSeats = "67J 21E 25C 25A 33A 1K 54J 37C 37E 37A 40K 6D 4C 1A";
		
		String[] seatsList = bookedSeats.split(" ");
		String[] sortedBookedList = new String[seatsList.length];

		for (int j = 0; j < seatsList.length; j++) {
			System.out.println("" + seatsList[j]);
			for (int i = 0; i < sortedBookedList.length; i++) {

				if(compare(seatsList[j],seatsList[i]) > 0) {

					System.out.println(seatsList[j]+" is more than "+seatsList[i]);
					String temp = seatsList[i];
					seatsList[i] = seatsList[j];
					seatsList[j] = temp;
					continue;
					
				} 
			}
		}

		System.out.println("sortedBookedList:" + seatsList.toString());
		for (int i = 0; i < seatsList.length; i++) {
			
			System.out.println("" + seatsList[i]);

		}

	}
	
	public static int compare(String s1, String s2) {
		String preS1 = s1.substring(0,s1.length()-1);
		String preS2 = s2.substring(0,s2.length()-1);

		if (Integer.parseInt(preS1) < Integer.parseInt(preS2)) {
			return 1;
		} else if (Integer.parseInt(preS1) == Integer.parseInt(preS2)){
			return (s2.substring(s2.length()-1,s2.length()).compareTo( s1.substring(s1.length()-1,s1.length())));
					
		} else {
			return -1; 
		}
	}

}
