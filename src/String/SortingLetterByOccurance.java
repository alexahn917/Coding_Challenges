//Sort the letters in one word by the order they occur in another in linear time

/*
1. Build a linked hash map with the order definition with key as the letter, 0 as the value 
2. scan the word, increase the value for every letter 
3. re-scan the hash, output every letter with the frequency of value 
*/
