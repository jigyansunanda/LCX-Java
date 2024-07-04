class Trie {
    private Trie[] children;
    boolean isWordEnd;

    Trie() {
        this.children = new Trie[26];
        this.isWordEnd = false;
    }

    public void addWord(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isWordEnd = true;
    }

    public boolean searchWord(String word) {
        Trie node = this;
        return searchWord(node, word, 0);
    }

    private boolean searchWord(Trie node, String word, int index) {
        if (node == null) return false;
        if (index == word.length()) return node.isWordEnd;
        char c = word.charAt(index);
        if (c != '.') {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            return searchWord(node.children[idx], word, index + 1);
        } else {
            for (int i = 0; i < 26; ++i) {
                if (node.children[i] == null) continue;
                if (searchWord(node.children[i], word, index + 1)) return true;
            }
            return false;
        }
    }
}

class WordDictionary {

    private Trie dictionary;

    public WordDictionary() {
        this.dictionary = new Trie();
    }

    public void addWord(String word) {
        dictionary.addWord(word);
    }

    public boolean search(String word) {
        return dictionary.searchWord(word);
    }
}