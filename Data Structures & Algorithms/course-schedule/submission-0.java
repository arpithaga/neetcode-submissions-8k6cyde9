class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int[] p:prerequisites){
            list.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int p=0;p<indegree.length;p++){
            if(indegree[p]==0){
              queue.add(p);
            }
        }

        int count=0;;
        while(!queue.isEmpty()){
            int c = queue.poll();
            count++;

            for(int p: list.get(c)){
                indegree[p]--;
                if(indegree[p]==0){
                    queue.add(p);
                }
            }
        }

        return count==numCourses;

    }
}
