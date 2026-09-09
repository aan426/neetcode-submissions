class Courses{
    int numCourses;
    int[][] prerequisites;
    Map<Integer, Set<Integer>> coursePrereqs;
    boolean canBeCompleted;
    public Courses(int numCourses, int[][] prerequisites){
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;
        coursePrereqs = new HashMap<>();
        canBeCompleted = true;
    }

    public boolean canCompleteCourses(){
        fillPrereqs();
        Set<Integer> completed = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            dfsCourse(i, new HashSet<>(), completed);
        }

        return canBeCompleted;
    }

    private void fillPrereqs(){
        for(int i = 0; i < prerequisites.length; i++){
            int courseB = prerequisites[i][1];
            int courseA = prerequisites[i][0];
            if(!courseNumHasPrereqs(courseA)){
                Set<Integer> prereqs = new HashSet<>();
                prereqs.add(courseB);
                coursePrereqs.put(courseA, prereqs); 
            }
            else{
                Set<Integer> prereqs = coursePrereqs.get(courseA);
                prereqs.add(courseB);
                coursePrereqs.put(courseA, prereqs);
            }
        }
    }

    private boolean courseNumHasPrereqs(int courseNum){
        return coursePrereqs.get(courseNum) != null ? true : false;
    }

    private boolean courseNumVisited(int courseNum, Set<Integer> visited){
        return visited.contains(courseNum) == true ? true : false;
    }

    private void dfsCourse(int courseNum, Set<Integer> visited, Set<Integer> completed){
        if(!courseNumHasPrereqs(courseNum) || completed.contains(courseNum)){
            return; //course can be completed
        }

        if(courseNumVisited(courseNum, visited)){
            canBeCompleted = false;
            return; //course can't be completed
        }

        Set<Integer> prereqSet = coursePrereqs.get(courseNum);
        visited.add(courseNum);
        for(Integer prereq: prereqSet){
            dfsCourse(prereq, visited, completed);           
        }

        if(canBeCompleted){
            visited.remove(courseNum);
            completed.add(courseNum);
        }
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Courses canComplete = new Courses(numCourses, prerequisites);
        return canComplete.canCompleteCourses();
    }
}
