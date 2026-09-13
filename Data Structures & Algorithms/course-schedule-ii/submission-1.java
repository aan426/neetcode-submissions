class CourseOrder{
    List<Integer> courseOrder;
    int[] retCourseOrder;
    int numCourses;
    int[][] prerequisites;
    Map<Integer, List<Integer>> prereqToCourse;
    int[] remainingPreReqs;
    Deque<Integer> hasNoPrereqsQueue;
    public CourseOrder(int numCourses, int[][] prerequisites){
        courseOrder = new ArrayList<>();
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;
        prereqToCourse = new HashMap<>();
        remainingPreReqs = new int[numCourses];
        retCourseOrder = new int[numCourses];
        hasNoPrereqsQueue = new LinkedList<>();
    }

    public int[] getCourseOrder(){
        fillPrereqMap();
        topologicalSort();

        if(courseOrder.size() == numCourses){
            convertList();
            return retCourseOrder;
        }
        
        return new int[0];
        // return retCourseOrder;
    }

    private void fillPrereqMap(){
        for(int i = 0; i < prerequisites.length; i++){
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];

            remainingPreReqs[course]++;

            List<Integer> courses = new ArrayList<>();
            if(isPrereqToMutliCourses(prereq)){
                courses = prereqToCourse.get(prereq);
            }
            courses.add(course);
            prereqToCourse.put(prereq, courses);
        }
    }

    private void topologicalSort(){
        fillQueue();

        while(!hasNoPrereqsQueue.isEmpty()){
            int currCourse = hasNoPrereqsQueue.pollFirst();
            courseOrder.add(currCourse);

            for(Integer course: prereqToCourse.getOrDefault(currCourse, new ArrayList<>())){
                remainingPreReqs[course]--;
                if(remainingPreReqs[course] == 0){
                    hasNoPrereqsQueue.offer(course);
                }
            }
        }
    }

    private void convertList(){
        for(int i = 0; i < numCourses; i++){
            retCourseOrder[i] = courseOrder.get(i);
        }
    }

    private void fillQueue(){
        for(int i = 0; i < numCourses; i++){
            if(remainingPreReqs[i] == 0){
                hasNoPrereqsQueue.offer(i);
            }
        }
    }

    private boolean isPrereqToMutliCourses(int prereq){
        return prereqToCourse.get(prereq) != null ? true : false;
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        CourseOrder getOrder = new CourseOrder(numCourses, prerequisites);
        return getOrder.getCourseOrder();
    }
}
