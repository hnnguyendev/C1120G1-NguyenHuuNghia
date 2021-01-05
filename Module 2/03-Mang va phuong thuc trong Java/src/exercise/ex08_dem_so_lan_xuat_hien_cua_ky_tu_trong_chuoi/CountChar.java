package exercise.ex08_dem_so_lan_xuat_hien_cua_ky_tu_trong_chuoi;

public class CountChar {

	public static String str = "Nguyen Huu Nghia";
	public static char ch = 'n';
	public static int count = 0;
	public static char[] array;

	public static char[] addLast(char[] array, char element) {
		char newArray[];
		if (array == null) {
			newArray = new char[1];
		} else {
			newArray = new char[array.length + 1];
			for (int index = 0; index < array.length; index++) {
				newArray[index] = array[index];
			}
		}
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	public static void main(String[] args) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				array = addLast(array, str.charAt(i));
			}
		}

		for (char element : array) {
			System.out.println(element + " - " + (int) element);
		}

		for (char element : array) {
			if (element == ch) {
				count++;
			}
		}
		System.out.println(count);

	}

}
