class Solution {
    HashSet<String> dictionary;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.dictionary = new HashSet<>(wordDict);
        List<String> wordsList = generateWords(s, 0);
        return wordsList;
    }

    private List<String> generateWords(String s, int index) {
        if (index == s.length()) {
            return Collections.emptyList();
        } else {
            List<String> words = new ArrayList<>();
            for (int next = index + 1; next <= s.length(); ++next) {
                String prefix = s.substring(index, next);
                String suffix = s.substring(next);
                if (dictionary.contains(prefix)) {
                    List<String> wordsList = generateWords(suffix, 0);
                    if (!wordsList.isEmpty()) {
                        for (String word : wordsList) {
                            words.add(prefix + " " + word);
                        }
                    } else if (suffix.isEmpty()) {
                        words.add(prefix);
                    }
                }
            }
            return words;
        }
    }
}