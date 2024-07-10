class Solution {
    private List<Integer> permutation;
    private List<List<Integer>> permutations;

    public List<List<Integer>> permute(int[] arr) {
        this.permutation = new ArrayList<>();
        this.permutations = new ArrayList<>();
        dfs(arr, 0);
        return permutations;
    }

    private void dfs(int[] arr, int currentIndex) {
        if (currentIndex == arr.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        int indexToBeSwapped = currentIndex;
        while (indexToBeSwapped < arr.length) {
            swap(arr, indexToBeSwapped, currentIndex);
            permutation.add(arr[currentIndex]);
            dfs(arr, currentIndex + 1);
            permutation.remove(permutation.size() - 1);
            swap(arr, indexToBeSwapped, currentIndex);
            ++indexToBeSwapped;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}