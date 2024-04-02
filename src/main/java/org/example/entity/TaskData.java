package org.example.entity;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    // Belirli bir çalışanın üzerindeki taskları döndürür
    public Set<Task> getTasks(String name) {
        switch (name) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks );
        }
        return new HashSet<>();
    }

    // Verilen set listesini birleştirir
    public Set<Task> getUnion(Set<Task>... sets) { //varargs
        HashSet<Task> total = new HashSet<>();
        for (Set<Task> taskSet: sets) {
            total.addAll(taskSet);
        }
        return total;
    }

    // İki set'in kesişim kümesini döndürür
    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersections = new HashSet<>(set1);
        intersections.retainAll(set2);
        return intersections;
    }

    // İki set'in farkını döndürür
    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> differences = new HashSet<>(set1);
        differences.removeAll(set2);
        return differences;
    }

}