class Solution {
    public boolean isAnagram(String s, String t) {
        char S[] = s.toCharArray();
        char T[] = t.toCharArray();
        if(S.length!=T.length){
            return false;
        }
        Arrays.sort(S);
        Arrays.sort(T);
        for(int i=0;i<S.length;i++){
            if(S[i]!=T[i]){
                return false;
            }
        }
        return true;
    }
}