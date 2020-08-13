public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        return str1.trim().concat(str2.trim());
    }

    public Integer getIndexOrNull(String str1, char letter) {
        if (str1.indexOf(letter) != -1) {
            return str1.indexOf(letter);
        } else {
            return null;
        }
    }

    public Integer getIndexOrNull(String str1, String substring) {
        if (str1.indexOf(substring) != -1) {
            return str1.indexOf(substring);
        } else {
            return null;
        }
    }

    public String concatSubstring(String str1, int num1, int num2, String str2) {
        return str1.substring(num1, num2).concat(str2);
    }
}