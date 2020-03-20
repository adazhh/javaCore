package algorithmBuck.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q06DogCatQueue {
    public static class Pet{
        private String type;
        public Pet(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
    }
    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }
    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    public static class PetQueue {
        private Pet pet;
        private int count;
        public PetQueue(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }
        public int getCount() {
            return count;
        }
        public Pet getPet() {
            return pet;
        }
        public String getPetQueueType(){
            return pet.getType();
        }
    }
    public static class DogCatQueue{
        private Queue<PetQueue> dogQ;
        private Queue<PetQueue> catQ;
        private int count;

        public DogCatQueue() {
            dogQ = new LinkedList<PetQueue>();
            catQ = new LinkedList<PetQueue>();
            count = 0;
        }
        public void add(Pet pet){
            if (pet.getType().equals("dag")){
                dogQ.add(new PetQueue(pet, count++));
            } else if (pet.getType().equals("cat")){
                catQ.add(new PetQueue(pet, count));
            } else {
                throw new RuntimeException("not dog or not cat");
            }
        }
        public Pet pollAll(){
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("err, queue is empty!");
            }
        }
        public Dog pollDog() {
            if (!this.isDogEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat() {
            if (!this.isCatEmpty()) {
                return (Cat) this.catQ.poll().getPet();
            } else
                throw new RuntimeException("Cat queue is empty!");
        }

        public boolean isEmpty(){
            return dogQ.isEmpty() && catQ.isEmpty();
        }
        public boolean isDogEmpty(){
            return dogQ.isEmpty();
        }
        public boolean isCatEmpty(){
            return catQ.isEmpty();
        }
    }
}
