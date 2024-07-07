class Trie {
    Trie[] children;
    boolean isEnd;

    Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    void insertWord(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        Trie trie = new Trie();
        List<String> wordsList = new ArrayList<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            if (search(word, trie, 0, 0)) {
                wordsList.add(word);
            } else {
                trie.insertWord(word);
            }
        }
        return wordsList;
    }

    private boolean search(String word, Trie trie, int currIndex, int completeWordCount) {
        if (currIndex == word.length()) {
            return (completeWordCount > 1);
        }
        Trie node = trie;
        for (int index = currIndex; index < word.length(); ++index) {
            int id = word.charAt(index) - 'a';
            if (node.children[id] == null) return false;
            node = node.children[id];
            if (node.isEnd) {
                if (search(word, trie, index + 1, completeWordCount + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}