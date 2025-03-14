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
            System.out.println(binary);
        }
        return binary.toString();
    }

    public static String[] split(String k) {
        
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
        String ans = binaryConvertion(k);
        System.out.println(ans.length());
    }
}
