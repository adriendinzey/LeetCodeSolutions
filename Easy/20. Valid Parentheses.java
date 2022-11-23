/*
* This solution creates a stack and every time we see an opening bracket,
* that character is added to the top of the stack.
* Every time we see a closing bracket it will pop the stack and attempt to match the brackets.
* If the closing bracket matches the opening bracket then we keep going. If not, the string is invalid.
* Finally, at the end of the loop, if the stack is not empty (i.e. there are opening brackets that were not closed) we say the string is invalid.
* If the stack is empty, then the string is valid.
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int index=0;
        stack.push(s.charAt(index++));
        while(index<s.length()){
            if(isOpen(s.charAt(index))){ // if it is an open bracket
                stack.push(s.charAt(index));
            }
            else{
                if(stack.empty()){ //If it's empty then there were no brackets that were opened, so none can be closed here
                    return false;
                }
                char open = stack.pop();
                if(!matchParentheses(open,s.charAt(index))){
                    return false; // the most recent open bracket is not a match for the current closing bracket so we return false
                }
            }
            index++;
        }
        return stack.empty(); // If the stack is empty at this point (all opened brackets were closed properly) then the string is valid
        // If not, then we have unclosed brackets and the string is invalid.
    }

    public boolean matchParentheses(char open,char close){
        return (open=='(' && close==')') || (open=='[' && close==']') || (open=='{' && close=='}');
    }
    
    public boolean isOpen(char c){
        return c=='(' || c=='[' || c=='{';
    }
}
