/**
 * @param {string} word
 * @return {boolean}
 */
var isValid = function(word) {
  if (word.length < 3) 
  return false;
  if (!/^[a-zA-Z0-9]+$/.test(word))
   return false;
  if (!/[aeiouAEIOU]/.test(word))
   return false;
  if (!/[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]/.test(word))
   return false;

  return true;

};