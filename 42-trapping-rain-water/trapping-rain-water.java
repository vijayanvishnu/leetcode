class Solution {
    public int trap(int[] a) {
        int n=a.length;
        int leftMax[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            if(a[i]>max) max=a[i];
            leftMax[i]=max;
        }
        max=0;
        int rightMax[]=new int[n];
        for(int i=n-1;i>=0;i--){
            if(a[i]>max) max=a[i];
            rightMax[i]=max;
        }
        max=0;
        for(int i=0;i<n;i++){
            max+=min(leftMax[i],rightMax[i])-a[i];
        }
        return max;
    }
    static int min(int a,int b){
        return a<b?a:b;
    }
}