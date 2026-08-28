class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        // [1, 2, 4, 5]
        // [1, 2, 2, 3, 3]

        int l = 0;
        int r = people.length - 1;
        int boat = 0;

        while(l <= r){
            if(people[l] + people[r] <= limit){
                boat++;
                l++;
                r--;
            }
            else if(people[r] <= limit){
                boat++;
                r--;
            }
            else{
                boat++;
                l++;
            }
        }

        return boat;
    }
}