import java.util.*;

public class Decrypt {

    // Convert a 7-character string to a 56-bit binary string
    public static String binaryConvertion(String k) {
        StringBuilder binary = new StringBuilder();
        for (char ch : k.toCharArray()) {
            binary.append(String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0'));
        }
        return binary.toString();
    }

    // Split a 56-bit binary string into two 28-bit halves
    public static String[] split(String k) {
        int midIndex = k.length() / 2;
        return new String[] { k.substring(0, midIndex), k.substring(midIndex) };
    }

    // Perform a left shift on the two halves of the key
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

    // Generate subkeys from the initial 56-bit key
    public static List<String> keyScheduleTransform(String inputKey) {
        if (inputKey.length() != 56) {
            throw new IllegalArgumentException("Input key must be 56 bits long.");
        }

        List<String> subkeys = new ArrayList<>();

        // Split the initial key into two halves
        String[] halves = split(inputKey);
        String C = halves[0];
        String D = halves[1];

        // Generate 10 subkeys
        for (int i = 0; i < 10; i++) {
            // Apply left shift to both halves
            String[] shiftedHalves = transFuction(C + D);
            C = shiftedHalves[0];
            D = shiftedHalves[1];

            // Concatenate the two halves and take the first 32 bits as the subkey
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

        // Convert the 7-character key to a 56-bit binary string
        String binaryKey = binaryConvertion(k);

        // Generate subkeys from the binary key
        List<String> subkeys = keyScheduleTransform(binaryKey);

        // Print the generated subkeys
        System.out.println("Generated Subkeys:");
        for (int i = 0; i < subkeys.size(); i++) {
            System.out.println("Subkey k" + (i + 1) + ": " + subkeys.get(i));
        }

        // Reverse the subkeys for decryption
        Collections.reverse(subkeys);
        System.out.println("\nReversed Subkeys for Decryption:");
        for (int i = 0; i < subkeys.size(); i++) {
            System.out.println("Subkey k" + (i + 1) + ": " + subkeys.get(i));
        }
    }
}