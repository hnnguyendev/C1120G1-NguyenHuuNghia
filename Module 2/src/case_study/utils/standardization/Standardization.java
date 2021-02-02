package case_study.utils.standardization;

public class Standardization {

    public static String standardizedName(String str) {
        String result = "";
        str = str.trim().toLowerCase().replaceAll("\\s+", " ");
        for (int i = 0; i < str.length(); i++) {
            String _char = str.substring(i, i + 1);
            if (i == 0 || str.substring(i - 1, i).equals(" ")) {
                result += _char.toUpperCase();
            } else {
                result += _char;
            }
        }

        return result;
    }

    public static String standardizedFirstName(String str) {
        String[] fullName = str.split(" ");

        return fullName[fullName.length - 1];
    }
}
