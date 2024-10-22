class MergeSort {
    public static void mergesort(int arr[],int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            mergesort(arr,l,mid);
            mergesort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    public static void merge( int arr[],int l,int mid,int r){
        int n1=mid+1-l;
        int n2=r-mid;
        int L[]=new int[n1];
        int R[]=new int[n2];
            for(int i=0;i<n1;i++){
                L[i]=arr[l+i];
            }
            for(int j=0;j<n2;j++){
                R[j]=arr[mid+1+j];
            }
        int i=0,j=0;
        int k=l;
            while(i<n1 && j<n2){
                if(L[i]<=R[j]){
                    arr[k++]=L[i++];
                }
                else{
                    arr[k++]=R[j++];
                }
            }
            while(i<n1){
                arr[k++]=L[i++];
            }
            while(j<n2){
                arr[k++]=R[j++];
            }
        }
    public int[] sortArray(int[] nums){
        int l=0;
        int r = nums.length-1;
        mergesort(nums,l,r);
        return nums;
    }
    public static void main(String[] args) {
       MergeSort array = new MergeSort();
        int[] nums = {56,45,24,67,48,13,55,26,74,23,65};
        System.out.println("Original Array:");
        for(int num:nums) {
            System.out.print(num+" ");
        }
        array.sortArray(nums);
        System.out.println("\nSorted Array:");
        for(int num:nums) {
            System.out.print(num+" ");
        }
    }
}
