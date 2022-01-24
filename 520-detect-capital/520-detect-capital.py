class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        capital="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        capita=0;
        for i in word:
            if i in capital:
                capita+=1;
        if capita==len(word):
            return True;
        if capita==1 and word[0] in capital:
            return True;
        if capita==0:
            return True;
        return False;