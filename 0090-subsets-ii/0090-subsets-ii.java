class Solution {
    /* Idea: recursive solution */
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Arrays.sort(nums);
    //     List<Integer> subset = new ArrayList<>();
    //     List<List<Integer>> subsets = new ArrayList<>();
    //     dfs(nums, 0, subset, subsets);
    //     return subsets;
    // }
    // private void dfs(int[] A, int index, List<Integer> subset, List<List<Integer>> subsets) {
    //     subsets.add(new ArrayList<>(subset));
    //     for (int next = index; next < A.length; ++next) {
    //         if (next != index && A[next] == A[next - 1])
    //             continue;
    //         subset.add(A[next]);
    //         dfs(A, next + 1, subset, subsets);
    //         subset.remove(subset.size() - 1);
    //     }
    // }

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        // sort the array for help in de-duplication
        Arrays.sort(arr);
        // first add the empty subset
        subsets.add(Collections.emptyList());
        // prevElementContributionIndex = the index from which onwards,
        // the last element gave his contribution (was added to it)
        // initally prevElementContributionIndex = 0, since no elements
        // were used and the contribution started at index 0.
        int prevElementContributionIndex = 0;
        for (int currIndex = 0; currIndex < arr.length; ++currIndex) {
            // currElementContributionIndex = the index from which onwards,
            // the current element will be added to subsets.
            int currElementContributionIndex = -1;
            // if current index is starting index or the current element
            // does not match the element at previous index, then the
            // current element can be added to all the subsets that have
            // been generated so far, i.e starting from index 0.
            if (currIndex == 0 || arr[currIndex] != arr[currIndex - 1]) {
                currElementContributionIndex = 0;
            } // else we can only add current element only to the subsets,
              // that last element formed, otherwise there will be duplicates
              // since current element is same as last element
            else {
                currElementContributionIndex = prevElementContributionIndex;
            }
            // endIndex = the index till which we can iterate over
            int endIndex = subsets.size() - 1;
            while (currElementContributionIndex <= endIndex) {
                subsets.add(new ArrayList<>(subsets.get(currElementContributionIndex)));
                // push the current element to end of the pushed subset
                subsets.get(subsets.size() - 1).add(arr[currIndex]);
                ++currElementContributionIndex;
            }
            // update currElementContributionIndex to endIndex + 1, since
            // from this index current element's contribution started.
            prevElementContributionIndex = endIndex + 1;
        }
        return subsets;
    }
}