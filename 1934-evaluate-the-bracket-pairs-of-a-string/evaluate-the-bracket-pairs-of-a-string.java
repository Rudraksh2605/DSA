class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> p : knowledge){
            map.put(p.get(0), p.get(1));
        }         

        StringBuilder res = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean ib = false;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                ib = true;
                key.setLength(0);
            } else if(c == ')'){
                ib = false;
                String k = key.toString();
                res.append(map.getOrDefault(k, "?"));
            } else {
                if(ib) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

}