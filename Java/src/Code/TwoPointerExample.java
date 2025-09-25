public class TwoPointerExample {
    public static void main(String[] args) {
        int[] arr={1,2,4,7,11,15};
        int target=15;
        int left=0;
        int right=arr.length-1;
        boolean found=false;
        while (left<right) {
            int sum=arr[left]+arr[right];
            if (sum==target) {
            System.out.println("Pair found: " + arr[left] + "+" + arr[right] + "=" + target);
            found=true;
            break;
        } else if (sum<target) {
                left++;
            }else {
                right--;
            }
        }
        if (!found) {
            System.out.println("No such pair found");
        }
    }
}