package AlgorithmSunday.week4.hw;

import java.util.*;

public class CCC10S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        switch (n) {
            case 0:
                System.out.println();
                System.exit(0);
            case 1:
                String nm = sc.next();
                sc.nextInt();
                sc.nextInt();
                sc.nextInt();
                System.out.println(nm);
                System.exit(0);

            case 2:
                String s1 = sc.next();
                int c1 = sc.nextInt();
                int c2 = sc.nextInt();
                int c3 = sc.nextInt();

                String s2 = sc.next();
                int c4 = sc.nextInt();
                int c5 = sc.nextInt();
                int c6 = sc.nextInt();

                int d1 = c1*2 + c2 * 3 + c3;
                int d2 = c4*2 + c5 * 3 + c6;

                if(d1>d2){
                    System.out.println(s1);
                    System.out.println(s2);
                }else if(d1<d2){
                    System.out.println(d2);
                    System.out.println(d1);
                }else{
                    if(s1.compareTo(s2)>0){
                        System.out.println(s2);
                        System.out.println(s1);
                    }else{
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
                System.exit(0);


            default:
                Map<String, Integer> mapScore = new TreeMap<>();
                List<Integer> scoreList = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    String name = sc.next();
                    int r = sc.nextInt();
                    int s = sc.nextInt();
                    int d = sc.nextInt();
                    int score = 2 * r + 3 * s + d;
                    mapScore.put(name, score);

                    if(!scoreList.contains(score)) {
                        scoreList.add(score);
                    }
                }

                Collections.sort(scoreList);
                int first = scoreList.get(scoreList.size() - 1);
                List<String> firstList = new ArrayList<>();
                List<String> remove = new ArrayList<>();

                Set<Map.Entry<String, Integer>> entrySet = mapScore.entrySet();

                for (Map.Entry<String, Integer> entry: entrySet
                     ) {
                    if(entry.getValue()==first){
                        firstList.add(entry.getKey());
                        remove.add(entry.getKey());
                    }
                }
                for (String x: remove
                     ) {
                    mapScore.remove(x);
                }
                scoreList.remove((Integer) first);

                int second = scoreList.get(scoreList.size() - 1);
                List<String> secondList = new ArrayList<>();

                Set<Map.Entry<String, Integer>> entrySet2 = mapScore.entrySet();

                for (Map.Entry<String, Integer> entry: entrySet2
                ) {
                    if(entry.getValue()==second){
                        secondList.add(entry.getKey());
                    }
                }


                Collections.sort(firstList);
                Collections.sort(secondList);

                if(firstList.size() > 1){
                    System.out.println(firstList.get(0));
                    System.out.println(firstList.get(1));
                }else{
                    System.out.println(firstList.get(0));
                    System.out.println(secondList.get(0));
                }


        }
    }
}
