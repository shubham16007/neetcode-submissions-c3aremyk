class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb= new StringBuilder();

        for(String str:strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        int i=0;

        List<String> result=new ArrayList<>();

        while(i<str.length()){
        int j=i;

        while(str.charAt(j)!='#'){
            j++;
        }


        int len=Integer.parseInt(str.substring(i,j));
        j++;

        result.add(str.substring(j,j+len));

        i=len+j;
        }
    return result;

    }
}
