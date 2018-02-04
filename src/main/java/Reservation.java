public class Reservation {

	static final String[][] planeSeats = new String[20][10];
	static final String[] rowseat = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String contains the reservation seats in a plane.
		String bookedSeats = "67J 21E 25C 25A 33A 1K 54J 37C 37E 37A 14J 13A 40K 6D 2D 2K 4C 1A";

		String[] seatsList = sortBookedList(bookedSeats);

		String[][] seats = prepareSeats(seatsList);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);

		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservSeats(seats, 1,bookedSeats);
		bookedSeats = reservFamilySeats(seats, 1,bookedSeats);
		printSeats(seats);
		System.out.println("Booked Seats: "+bookedSeats);
	}

	private static String[] sortBookedList(String bookedSeats) {
		String[] seatsList = bookedSeats.split(" ");
		String[] sortedBookedList = new String[seatsList.length];

		for (int j = 0; j < seatsList.length; j++) {
			for (int i = 0; i < sortedBookedList.length; i++) {

				if (compare(seatsList[j], seatsList[i]) > 0) {

					//System.out.println(seatsList[j] + " is more than " + seatsList[i]);
					String temp = seatsList[i];
					seatsList[i] = seatsList[j];
					seatsList[j] = temp;
					continue;

				}
			}
		}
		return seatsList;
	}

	public static int compare(String s1, String s2) {
		String preS1 = s1.substring(0, s1.length() - 1);
		String preS2 = s2.substring(0, s2.length() - 1);

		if (Integer.parseInt(preS1) < Integer.parseInt(preS2)) {
			return 1;
		} else if (Integer.parseInt(preS1) == Integer.parseInt(preS2)) {
			return (s2.substring(s2.length() - 1, s2.length()).compareTo(s1.substring(s1.length() - 1, s1.length())));

		} else {
			return -1;
		}
	}

	public static boolean doesContain(String seat, String[] seatsList) {
		for (int i = 0; i < seatsList.length; i++) {
			if (seat.equals(seatsList[i])) {
				return true;
			}
		}
		return false;

	}

	public static String[][] prepareSeats(String[] seatsList) {
		for (int outter = 1; outter < 20; outter++) {
			for (int inner = 0; inner < rowseat.length; inner++) {
				String seat = "" + outter + "" + rowseat[inner];
				if (doesContain(seat, seatsList)) {
					// System.out.println("Seat reserved :"+seat);
					//System.out.print("[" + seat + "]");

					//planeSeats[outter][inner] = "[" + seat + "]";
					planeSeats[outter][inner] = "Y";
				} else {
					seat = "";
					// planeSeats[outter][inner] = "["+seat+"]";
				}

			}
			//System.out.println("");
		}
		return planeSeats;

	}

	public static String reservSeats(String[][] seats, int requestedSeats, String bookedSeats) {

		boolean booked = false;
		for (int outter = 1; outter < seats.length; outter++) {
			if (!booked) {
				for (int inner = 0; inner < seats[outter].length; inner++) {
					String seat = seats[outter][inner];
					//System.out.println(" Seat::" + seat);
					if (null != seat) {
						System.out.print("[" + seat + "] is reserved. ");

					} else {
						String seatNumber = "" + outter + "" + rowseat[inner] ;
						System.out.print("[" + seatNumber+ "] is free. ");
						seats[outter][inner] = "Y";
						bookedSeats = bookedSeats + " "+seatNumber;
						System.out.println("Booked Seats:" +bookedSeats);
						booked = true;
						break;
					} 
				}

				//System.out.println("");
			}
		}

		System.out.println("");
		return bookedSeats;

	}
	public static String reservFamilySeats(String[][] seats, int requestedSeats, String bookedSeats) {

		boolean booked = false;
		for (int outter = 1; outter < seats.length; outter++) {
		
				if(seats[outter][0] == null && seats[outter][1] == null  && seats[outter][2] == null ) {
					seats[outter][0] = "Y";
					seats[outter][1] = "Y";
					seats[outter][2] = "Y";
					bookedSeats = " "+outter+"A"+" "+outter+"B"+" "+outter+"C"; 
				}
				if(seats[outter][7] == null && seats[outter][8] == null  && seats[outter][9] == null ) {
					seats[outter][7] = "Y";
					seats[outter][8] = "Y";
					seats[outter][9] = "Y";
					bookedSeats = " "+outter+"H"+" "+outter+"J"+" "+outter+"K";
				}
		}

		System.out.println("");
		return bookedSeats;

	}
	
	public static void printSeats(String[][] seats) {

		for (int outter = 1; outter < seats.length; outter++) {
				for (int inner = 0; inner < seats[outter].length; inner++) {
					String seat = seats[outter][inner];
					if (null != seat) {
						System.out.print( "["+seat+"]" );

					} else {
						System.out.print("[]");
						
					}
				}

				System.out.println("");
			}
		
	}

}
