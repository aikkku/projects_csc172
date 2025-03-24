import java.util.*;

public class Subkeys {

//    public static String binaryConvertion(String k) {
//        StringBuilder binary = new StringBuilder();
//        for (char ch : k.toCharArray()) {
//            binary.append(String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0'));
//        }
//        return binary.toString();
//    }

    public static String binaryConvertion(String k) {
        int n = k.length();
        char[] kchar = k.toCharArray();
        StringBuilder binary = new StringBuilder();
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
        int midIndex = k.length() / 2;
        return new String[] { k.substring(0, midIndex), k.substring(midIndex) };
    }

    public static String[] transFuction(String binaryString) {
        String[] halves = split(binaryString);
        String c = halves[0];
        String d = halves[1];
        char tempC = c.charAt(0);
        char tempD = d.charAt(0);
        String cShifted = c.substring(1) + tempC;
        String dShifted = d.substring(1) + tempD;
        return new String[] { cShifted, dShifted };
    }

    public static Stack<String> keyScheduleTransform(String inputKey) {
        if (inputKey.length() != 56) {
            throw new IllegalArgumentException("Input key must be 56 bits long.");
        }

        Stack<String> subkeys = new Stack<>();
        String[] halves = split(inputKey);
        String C = halves[0];
        String D = halves[1];

        for (int i = 0; i < 10; i++) {
            String[] shiftedHalves = transFuction(C + D);
            C = shiftedHalves[0];
            D = shiftedHalves[1];

            String subkey = (C + D).substring(0, 32);
            subkeys.add(subkey);
        }

        return subkeys;
    }

    public static Queue<String> keyTransform(String inputKey) {
        if (inputKey.length() != 56) {
            throw new IllegalArgumentException("Input key must be 56 bits long.");
        }

        Queue<String> subkeys = new LinkedList<>();
        String[] halves = split(inputKey);
        String C = halves[0];
        String D = halves[1];

        for (int i = 0; i < 10; i++) {
            String[] shiftedHalves = transFuction(C + D);
            C = shiftedHalves[0];
            D = shiftedHalves[1];

            String subkey = (C + D).substring(0, 32);
            subkeys.add(subkey);
        }

        return subkeys;
    }

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

        String binaryKey = binaryConvertion(k);
        List<String> subkeys = keyScheduleTransform(binaryKey);

        System.out.println("Generated Subkeys:");
        for (int i = 0; i < subkeys.size(); i++) {
            System.out.println("Subkey k" + (i + 1) + ": " + subkeys.get(i));
        }

        Collections.reverse(subkeys);
        System.out.println("\nReversed Subkeys for Decryption:");
        for (int i = 0; i < subkeys.size(); i++) {
            System.out.println("Subkey k" + (i + 1) + ": " + subkeys.get(i));
        }
    }
}