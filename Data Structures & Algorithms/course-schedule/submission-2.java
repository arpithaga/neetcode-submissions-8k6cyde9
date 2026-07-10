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
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int count=0;

        while(!queue.isEmpty()){
            int v =queue.poll();
            count++;

            for(int a:list.get(v)){
                indegree[a]--;
                if(indegree[a]==0){
                    queue.add(a);
                }
            }
        }

        return count==numCourses;

    }
}
