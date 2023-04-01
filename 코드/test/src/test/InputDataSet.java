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
		if (i.category.equals("����")) {
			return String.format("%02d�� %02d�п� %s ������ �ֽ��ϴ�. �������� ������!\n", i.hour, i.minute, i.planname);
		}
		else if (i.category.equals("����")) {
			return String.format("%02d�� %02d�п� %s ������ �ֽ��ϴ�. ���� �� ġ����!\n", i.hour, i.minute, i.planname);
		}
		else if (i.category.equals("���� ����")) {
			return String.format("%02d�� %02d�б��� %s ���� ������ �ϼž��մϴ�. ���� ������!\n", i.end_h, i.end_m, i.planname);
		}
		else if (i.category.equals("�Ļ�")) {
			return String.format("%02d�� %02d�п� �Ļ簡 �����Ǿ� �ֽ��ϴ�. ���� �̸��� %s�Դϴ�. ���ְ� �弼��!\n", i.hour, i.minute, i.planname);
		}
		else if (i.category.equals("���")) {
			return String.format("%02d�� %02d�п� %s ����� �ֽ��ϴ�. ����� �� ��Ű�� ����� �˽ô�!\n", i.hour, i.minute, i.planname);
		}
		return null;
	}
	public String toStringToFile(InputDataSet i) {
		return String.format("%s/%s/%02d/%02d/%02d/%02d\n", i.category, i.planname, i.hour, i.minute, i.end_h, i.end_m);
	}
}
