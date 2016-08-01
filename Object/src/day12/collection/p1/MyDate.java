package day12.collection.p1;

public class MyDate implements Comparable{
	private Integer year;
	private Integer month;
	private Integer day;

	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public MyDate(Integer year, Integer month, Integer day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof MyDate){
			MyDate obj = (MyDate) o;
			if(this.year.equals(obj.year)){
				if(this.month.equals(obj.month)){
					return this.day.compareTo(obj.day);
				}else{
					return this.month.compareTo(obj.month);
				}
			}else
				return this.year.compareTo(obj.year);
		}
		return 0;
	}
	
}
