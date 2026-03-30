class Solution {

    List<String> result=new ArrayList<>();

    String[] values={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

        if(digits.length()==0) return result;


        dfs(digits,new StringBuilder(),0);

        return result;
        
    }

    public void dfs(String digits,StringBuilder temp,int start){


        if(temp.length()==digits.length()){
            result.add(temp.toString());
            return;
        }

        char ch=digits.charAt(start);
        String s=values[ch-'0'];

        for(char c:s.toCharArray()){

            temp.append(c);
            dfs(digits,temp,start+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
