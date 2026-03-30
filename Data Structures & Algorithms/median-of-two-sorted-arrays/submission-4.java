class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
                    
           return  findMedianSortedArrays(nums2, nums1);  
        }

        int n1=nums1.length;
        int n2=nums2.length;

        int N=n1+n2+1;

        int left=0;
        int right=n1;

        while(left<=right){

            int cut1=left+(right-left)/2;
            int cut2=N/2-cut1;

            int l1=(cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            int l2=(cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];

            int r1=(cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
            int r2=(cut2==n2)?Integer.MAX_VALUE:nums2[cut2];

            if(l1<=r2 && l2<=r1){
                if(N%2==0){

                    return (double) Math.max(l1,l2);
                }else{

                    return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }

            }
          else if(l1<r2){

                left=cut1+1;
            }else{
                right=cut1-1;
                
            }


        }
        return -1.0;
    }
}
