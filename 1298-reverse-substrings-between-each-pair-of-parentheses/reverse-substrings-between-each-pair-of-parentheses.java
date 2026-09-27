class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char c : s.toCharArray()){

            if(c == ')'){
                List<Character> ls = new ArrayList<>();
                while(!st.isEmpty() && st.peek() != '('){
                    ls.add(st.pop());
                }

                if(!st.isEmpty()) st.pop();

                for(char ch : ls){
                    st.push(ch);
                }
            } else {
                st.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.reverse().toString();
         
    }
}