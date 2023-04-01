package test;

public class InputDataSet {
	String category;
	String planname;
	int hour;
	int minute;
	int end_h;
	int end_m;
	public InputDataSet(String category, String planname, int hour,	int minute, int end_h, int end_m) {
		this.category = category;
		this.planname = planname;
		this.hour = hour;
		this.minute = minute;
		this.end_h = end_h;
		this.end_m = end_m;
	}
	public String toString(InputDataSet i) {
		return String.format("%s|%s|%02d:%02d ~ %02d:%02d\n", i.category, i.planname, i.hour, i.minute, i.end_h, i.end_m);
	}
	public String toStringToRead(InputDataSet i) {
		if (i.category.equals("수업")) {
			return String.format("%02d시 %02d분에 %s 수업이 있습니다. 지각하지 마세요!\n", i.hour, i.minute, i.planname);
		}
		else if (i.category.equals("시험")) {
			return String.format("%02d시 %02d분에 %s 시험이 있습니다. 시험 잘 치세요!\n", i.hour, i.minute, i.planname);
		}
		else if (i.category.equals("과제 제출")) {
			return String.format("%02d시 %02d분까지 %s 과제 제출을 하셔야합니다. 잊지 마세요!\n", i.end_h, i.end_m, i.planname);
		}
		else if (i.category.equals("식사")) {
			return String.format("%02d시 %02d분에 식사가 예정되어 있습니다. 일정 이름은 %s입니다. 맛있게 드세요!\n", i.hour, i.minute, i.planname);
		}
		else if (i.category.equals("약속")) {
			return String.format("%02d시 %02d분에 %s 약속이 있습니다. 약속을 잘 지키는 사람이 됩시다!\n", i.hour, i.minute, i.planname);
		}
		return null;
	}
	public String toStringToFile(InputDataSet i) {
		return String.format("%s/%s/%02d/%02d/%02d/%02d\n", i.category, i.planname, i.hour, i.minute, i.end_h, i.end_m);
	}
}
