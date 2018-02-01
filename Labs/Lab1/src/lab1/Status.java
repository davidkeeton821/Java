package lab1;

public enum Status {
	FRESHMAN(1, 0, 30),
	SOPHOMORE(2, 31, 60),
	JUNIOR(3, 61, 90),
	SENIOR(4, 91, 150);
	
	private final int year;
	private final int maxHours;
	private final int minHours;
	
	Status(int year, int minHours, int maxHours) {
		this.year = year;
		this.minHours = minHours;
		this.maxHours = maxHours;
	}
	
	int year() { return year; }
	int minHours() { return minHours; }
	int maxHours() { return maxHours; }
	int hoursRemaining(int currentHours) {
		return maxHours - currentHours + 1;
	}
        
        @Override
        public String toString() {
            switch(year) {
                case 1:
                    return "Freshman";
                case 2:
                    return "Sophomore";
                case 3:
                    return "Junior";
                case 4:
                    return "Senior";
                default:
                    return "Unknown";
            }
        }
}
