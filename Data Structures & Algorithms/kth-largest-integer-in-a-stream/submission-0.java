class KthLargest {

    List<Integer> numsList=new ArrayList<>();
    int k=-1;
    public KthLargest(int k, int[] nums) {
        this.numsList=Arrays.stream(nums) // Creates an IntStream
                             .boxed()         // Boxes int to Integer
                             .collect(Collectors.toList());
        this.k=k;
    }
    
    public int add(int val) {
        numsList.add(val);
        Collections.sort(numsList);
        return numsList.get(numsList.size() - 1-(k-1));
    }
}
