package com.dsr.day4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaHeapApi {
    public static void main(String[] args) {
        Comparator<Person> comparator=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getId()-o1.getId();
            }
        };
        PriorityQueue javaHeap =new PriorityQueue(comparator);
        Person p1=new Person(5);
        Person p2=new Person(8);
        Person p3=new Person(4);
        javaHeap.add(p1);
        javaHeap.offer(p2);
        javaHeap.add(p3);

        System.out.println(javaHeap);
    }
    private static class Person{
        private int id;
        public Person(int id){
            this.id=id;
        }
        public int getId(){
            return this.id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    '}';
        }
    }
}
