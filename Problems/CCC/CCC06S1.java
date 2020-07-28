package Problems.CCC;

import java.util.Scanner;

public class CCC06S1 {
    static int[] geneArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String aGene = sc.nextLine();
        String bGene = sc.nextLine();
        geneArr = new int[aGene.length()/2];
        boolean yes = true;

        char[] genes = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e'};

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < aGene.length(); i += 2) {
            makeGene(aGene.charAt(i), aGene.charAt(i + 1), bGene.charAt(i), bGene.charAt(i + 1), i, genes[i], genes[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            String gene = sc.nextLine();
            for (int j = 0; j < 5; j++) {
                char current = gene.toCharArray()[j];
                switch (geneArr[j]) {
                    case -1:
                        if(current != genes[2*j + 1]){
                            yes = false;
                        }
                        break;
                    case 0:
                        break;
                    case 1:
                        if(current != genes[2*j]){
                            yes = false;
                        }
                        break;
                }

            }
            System.out.println(yes?"Possible baby.":"Not their baby!");
            yes = true;
        }
    }


    private static void makeGene(char a1, char a2, char b1, char b2, int i, char big, char small) {
        if (a1 == a2 && b1 == b2 && a1 == b1 && a1 == big) {
            geneArr[i / 2] = 1;
        } else if ((a1 == a2 && a1 == big && b1 != b2) || (b1 == b2 && b1 == big && a1 != a2)) {
            geneArr[i / 2] = 1;
        } else if (a1 == a2 && b1 == b2 && a1 != b1) {
            geneArr[i / 2] = 1;
        } else if ((a1 == a2 && a1 == small && b1 != b2) || (a1 != a2 && b1 == b2 && b1 == small)) {
            geneArr[i / 2] = 0;
        } else if (a1 == a2 && b1 == b2 && a1 == small) {
            geneArr[i / 2] = -1;
        } else {
            geneArr[i / 2] = 0;
        }
    }
}
