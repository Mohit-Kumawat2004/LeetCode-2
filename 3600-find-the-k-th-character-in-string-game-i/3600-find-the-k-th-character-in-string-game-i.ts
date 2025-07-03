function kthCharacter(k: number): string {
    function helper(str: string): string {
        if (str.length > k) {
            return str[k - 1];
        }

        let newString = str;

        for (const char of str) {
            const charCode = char.charCodeAt(0) + 1;
            const shiftedCharCode = charCode > 122 ? 97 : charCode;
            newString += String.fromCharCode(shiftedCharCode);
        }

        return helper(newString);
    }

    return helper('a');
};