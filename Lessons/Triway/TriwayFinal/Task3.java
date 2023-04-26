package Problems.TriwayFinal;

import java.util.PriorityQueue;

public class Task3 {
    static class Student implements Comparable<Student>{
        String name;
        int mathMark;
        int scienceMark;
        int englishMark;

        public Student(String name, int mathMark, int scienceMark, int englishMark) {
            this.name = name;
            this.mathMark = mathMark;
            this.scienceMark = scienceMark;
            this.englishMark = englishMark;
        }

        public int findaverage(){
            return (this.englishMark + this.mathMark + this.scienceMark) / 3;
        }

        public int compareTo(Student student){
            return this.findaverage() - student.findaverage();
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Johnny",100,100,100));
        pq.add(new Student("Johnson", 10, 20, 30));
        pq.add(new Student("John",40,50,60));
        while (!pq.isEmpty()){
            System.out.println(pq.poll().name);
        }
    }
}
