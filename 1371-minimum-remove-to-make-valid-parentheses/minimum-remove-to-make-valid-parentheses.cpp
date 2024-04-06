class Solution {
public:
    string minRemoveToMakeValid(string s) {
        stack<int> stack;
        int size = s.length();
        set<int> remove ;
        for(int i=0;i<size;i++){
            if(s[i]=='('){
                stack.push(i);
            }
            else if(s[i]==')'){
                if(stack.empty()){
                    remove.insert(i);
                }
                else{
                    stack.pop();
                }
            }
            else{
                continue;
            }
        }
        while(!stack.empty()){
            remove.insert(stack.top());
            stack.pop();
        }
        string res;
        for(int i=0;i<size;i++){
            if(!remove.contains(i)){
                res+=(s[i]);
            }
        }
        return res;
    }
};