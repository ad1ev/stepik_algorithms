package org.stepik.module3;


import java.io.ByteArrayInputStream;
import java.util.*;

public class Huffman {


    public static void main(String[] args) {
//        code("abacabad");
//        code("beep boop beer!");
//        encode("a");
//        code("accepted");
//        code("adieevaadi");

        String input1 =
                "1 1\n" +
                "a: 0\n" +
                "0";

        String input2 =
                "4 14\n" +
                "a: 0\n" +
                "b: 10\n" +
                "c: 110\n" +
                "d: 111\n" +
                "01001100100111";
        Scanner sc = new Scanner(new ByteArrayInputStream(input1.getBytes()));



        Map<String, Character> decoder = new HashMap<>();
        String line = null;
        while (sc.hasNext()) {
            line = sc.nextLine();
            int colon = line.indexOf(':');
            if (colon != -1) {
                decoder.put(line.substring(colon + 2), line.charAt(0));
            }
        }
//
//        for (String s : decoder.keySet()) {
//            System.out.println(s + ": " + decoder.get(s));
//        }
//        System.out.println(line);
        decode(line, decoder);
    }

    public static void encode(String s) {
        HuffmanTree tree = new HuffmanTree(s);

        String compressed = tree.compressedText();
        System.out.println(tree.numberOfElements() + " " + compressed.length());
        tree.printAllCodes();
        System.out.println(compressed);
    }

    static void decode(String codes, Map<String, Character> decoder) {
        int left = 0;
        int right = 1;
        Character ch;
        do {
            ch = decoder.get(codes.substring(left, right));
            if (ch != null) {
                System.out.print(ch);
                left = right;
            }
            right++;
        } while (right <= codes.length());
    }
}


