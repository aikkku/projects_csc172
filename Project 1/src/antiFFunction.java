import java.util.List;

public class antiFFunction {
    public static String xorGate(String a, String b) {
        if(a.length() != b.length()){
            return "Strings do not have equal lengths!";
        }

        String ans = "";

        for(int i = 0; i < a.length(); i++){
            ans += ((((a.charAt(i) == '1') ^ (b.charAt(i) == '1'))? 1 : 0));
        }

        return ans;
    }

    public static List<String> splitTo8(String a) {
        return List.of(a.substring(0, 8), a.substring(9, 17), a.substring(18, 26), a.substring(27, 35));
    }

    public static String permutationS(String a) {
        if (a.length() != 8) return "String is not length of 8";
        int[] sTable = {2, 3, 1, 4, 6, 7, 5, 8};
        char[] ans = new char[8];

        for(int i = 0; i < a.length(); i++) {
            ans[i] = a.charAt(sTable[i] - 1);
        }

        return String.valueOf(ans);
    }

    public static String permutationP(String a) {
        if (a.length() != 32) return "String is not length of 32";
        int[] pTable = {
                16, 7, 30, 11, 29, 12, 28, 17,
                1, 15, 23, 26, 5, 18, 31, 10,
                2, 8, 24, 14, 32, 27, 3, 9,
                19, 13, 20, 6, 22, 21, 4, 25
        };
        char[] ans = new char[32];

        for(int i = 0; i < a.length(); i++) {
            ans[i] = a.charAt(pTable[i] - 1);
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(xorGate("10", "01"));
        System.out.println(splitTo8("01100001011000100110001101100100001100010011001000110011").toString());
        System.out.println(permutationS("10111100"));
    }
}
