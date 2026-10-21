class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] ross = s.toCharArray();
        char[] rach = s.toCharArray();
        Arrays.sort(rach);
        boolean Sorted = true;

        for(int i = 0; i < n; i++){
            if(ross[i] != rach[i]){
                Sorted = false;
                break;
            }
        }
        if(Sorted) return 0;
        if(n <= 2) return -1;
        int c = 0;
        while(c <n && ross[c] == rach[c]){ c++;}

        int b = n-1;
        while(b >= 0 & ross[b] == rach[b]){b--;}
        if(c >0 || b <n-1){return 1;}

        char monica = rach[0];
        char joey = rach[n-1];

        boolean phoebe = false;
        for(int i = 0; i < n-1; i++){
            if(ross[i] == monica){
                phoebe =true;
                break;
            }
        }

        boolean chand = false;
        for(int i = 1; i < n; i++){
            if(ross[i] == joey){
                chand = true;
                break;
            }
        }

        if(phoebe || chand){
            return 2;
        }

        return 3;
    }
}