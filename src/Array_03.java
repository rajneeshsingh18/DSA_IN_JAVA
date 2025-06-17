public class Array_03 {

    //container with most water
    static int maxArea(int[] arr){
        int maxArea=0;
        int left = 0 ;
        int right = arr.length-1;

        while(left<right){
            int height = Math.min(arr[left],arr[right]);
            int distance= right-left;
            int area = height * distance;

            maxArea = Math.max(maxArea,area);

            if(arr[left]<arr[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxArea;
    }

    //Trappping Rain Water Problem using DP approch
    public static int rainWaterTrapped(int[] arr){
        if( arr == null || arr.length ==0) return 0;

        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        //Left max array
        maxLeft[0] = arr[0];
        for(int i=1 ; i<n;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],arr[i]);
        }


        //Right max array
        maxRight[n-1] = arr[n-1];
        for(int i=n-2 ; i>=0;i--){
            maxRight[i] = Math.max(maxRight[i+1],arr[i]);
        }

        //trapped water
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(maxLeft[i], maxRight[i]) - arr[i];
        }

        return water;
    }



    public static  void  main(String[] args){

        int[] a = {1,8,6,2,4,5,8,3,7};
        int maxWaterHold = maxArea(a);
        System.out.println(maxWaterHold);


        int[] buildingHeight = {3,0,0,2,0,4};
//        int[] buildingHeight = {0,1,0,2,1,0,1,3,2,1,2,1};
        int answer = rainWaterTrapped(buildingHeight);
        System.out.println(answer);

    }
}
