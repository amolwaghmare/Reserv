public class Reservation {

	static final String[][] planeSeats = new String[20][10];
	static final String[] rowseat = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String contains the reservation seats in a plane.
		String bookedSeats = "67J 21E 25C 25A 33A 1K 54J 37C 37E 37A 14J 13A 40K 6D 2D 2K 4C 1A";

		String[] seatsList = bookedSeats.split(" ");
		String[] sortedBookedList = new String[seatsList.length];

		for (int j = 0; j < seatsList.length; j++) {
			System.out.println("" + seatsList[j]);
			for (int i = 0; i < sortedBookedList.length; i++) {

				if (compare(seatsList[j], seatsList[i]) > 0) {

					System.out.println(seatsList[j] + " is more than " + seatsList[i]);
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
		String[][] seats = prepareSeats(seatsList);
		reservSeats(seats, "5D");
		reservSeats(seats, "5E");
		reservSeats(seats, "12E");
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
					System.out.print("[" + seat + "]");

					planeSeats[outter][inner] = "[" + seat + "]";
				} else {
					seat = "";
					// planeSeats[outter][inner] = "["+seat+"]";
				}

			}
			System.out.println("");
		}
		return planeSeats;

	}

	public static String[][] reservSeats(String[][] seats, String reserverSeat) {

		boolean booked = false;
		for (int outter = 1; outter < seats.length; outter++) {
			if (!booked) {
				for (int inner = 0; inner < seats[outter].length; inner++) {
					String seat = seats[outter][inner];
					System.out.println(" Seat::" + seat);

					if (null != seat) {
						System.out.print("[" + seat + "] is reserved. ");

					} else {

						System.out.print("[" + "" + outter + "" + rowseat[inner] + "] is free. ");
						seats[outter][inner] = reserverSeat;
						booked = true;
						break;

					}
				}

				System.out.println("");
			}
		}
		return planeSeats;

	}

}
