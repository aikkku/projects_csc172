import java.util.*;

public class Subkeys {

    public static String binaryConvertion(String k) {
        int n = k.length();
        char[] kchar = k.toCharArray();
        StringBuilder binary = new StringBuilder();
//        char charToAdd = '0';
        for (int i=0; i<n; i++){
            char ch = kchar[i];
            int val = (int) ch;
            StringBuilder binaryChar = new StringBuilder();

            while (val > 0) {
                if (val % 2 == 0) {
                    binaryChar.insert(0,'0');
                } else {
                    binaryChar.insert(0, '1');
                }
                val = val/2;
            }
            while (binaryChar.length()<8) {
                binaryChar.insert(0,'0');
            }
            binary.append(binaryChar);
        }
        return binary.toString();
    }

    public static String[] split(String k) {
        String[] newString = new String[2];
        char[] kCharArray = k.toCharArray();
        String c = "";
        String d = "";
        int midIndex = k.length()/2;

        for (int i=0; i<midIndex; i++) {
            c += k.charAt(i);
        }
        for (int i=midIndex; i< kCharArray.length;i++) {
            d += k.charAt(i);
        }
        newString[0] = c;
        newString[1] = d;
        return newString;
    }

    public static String[] transFuction(String binaryString) {
        String[] half = split(binaryString);
        String c = half[0];
        String d = half[1];
        char temp1 = c.charAt(0);
        char temp2 = d.charAt(0);
        String cShifted = c.substring(1) + temp1;
        String dShifted = d.substring(1) + temp2;

        return new String[]{cShifted, dShifted};
    }

//    public static String getKey() {
//
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String k;

        do {
            System.out.println("Enter a 7-character key: ");
            k = scanner.nextLine();

            if (k.length() != 7) {
                System.out.println("Invalid input. Please enter exactly 7 characters.");
            }
        } while (k.length() != 7);
        scanner.close();
//
        String binaryString = binaryConvertion(k);
        String[] half = split(binaryString);
        String C = half[0];
        String D = half[1];
//        String key = result[0] + result[1];
//        System.out.println("First half after shift: " + result[0]);
//        System.out.println("Second half after shift: " + result[1]);
//        System.out.println(key);

        for (int i = 1; i<11; i++) {
//            String newKey = "";
            String[] shiftedHalves = transFuction(C + D);
            C = shiftedHalves[0];
            D = shiftedHalves[1];

            String newKey = (C+D).substring(0,32);
            System.out.println("Subkey k" + i + ": " + newKey);


//            for (int j=0; j<32; j++) {
//                newKey += key.charAt(j);
//                binaryString = binaryConvertion(newKey);
//                result = transFuction(binaryString);
//                key = result[0] + result[1];
//            }
//            System.out.println("Subkey k" + i + ": " + newKey);
        }
    }
}
