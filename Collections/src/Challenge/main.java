package Challenge;

import java.util.*;

public class main {
    public static void main(String[] args) {

        Comparator<Task> comparator = Comparator.comparing(Task::getPriority);


        var carolTask = TaskData.getTask("carol");
        printTasks("carol tasks",carolTask,comparator);

        var anaTask = TaskData.getTask("ann");
        printTasks("anns tasks",anaTask,comparator);

        var bobsTask = TaskData.getTask("bob");
        printTasks("bobs tasks",bobsTask,comparator);

        var allTasks = TaskData.getTask("all");
//        Comparator<Task> new_comperator = Comparator.comparing(Task::getAssignee);
        printTasks("all tasks",allTasks,comparator);

        var unionTasks = getUnion(allTasks,anaTask,bobsTask,carolTask);
        var difference = getDifference(unionTasks,allTasks);
        printTasks("Missing tasks",difference,comparator);

        var intersection = getIntersection(bobsTask,allTasks);
        printTasks("intersection of bobs and all tasks",intersection, comparator);

        var assigned_tasks = getUnion(bobsTask,anaTask,carolTask);
        printTasks("teams task",assigned_tasks,comparator);

        System.out.println(unionTasks.size() + " " + assigned_tasks.size());

        Set<Task> not_assigned = getDifference(allTasks,assigned_tasks);
        printTasks("Not assigned",not_assigned,comparator);

//        Comparator<Task> taskSorter = Comparator.comparing(Task::getPriority);
//
//        var bobsTaskSorted = TaskData.getTask("bobs");
//        printTasks("bobs tasks",bobsTaskSorted,taskSorter);


    }
    public static void printTasks(String header, Collection<Task> collection){
        printTasks(header,collection,null);
    }
    public static void printTasks(String header, Collection<Task> collection, Comparator<Task> sorter){
        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);

    }

    public static Set<Task> getUnion(Set<Task>... allSets){
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : allSets ){
            unionSet.addAll(set);
        }
        return unionSet;
    }

    public static Set<Task> getIntersection(Set<Task> task1, Set<Task> task2){
        Set<Task> intersectionSet = new HashSet<>(task1);
        intersectionSet.retainAll(task2);
        return intersectionSet;

    }

    public static Set<Task> getDifference(Set<Task> task1, Set<Task> task2){
        Set<Task> differenceSet = new HashSet<>(task1);
        differenceSet.removeAll(task2);
        return differenceSet;
    }

}
