function possibleStringCount(word: string): number {
    let count = 1;

    for(let i = 1; i < word.length; i++) {
        if(word[i-1] === word[i]){
            count++;
        }
    }
    return count;
};