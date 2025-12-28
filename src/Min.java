public class Min {
    public static int getMin(int[] arr) {
        int min=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
               min=arr[i];
            }
        }
        return min;
    }
        public static void main(String[] args){
          int[] arr={1,2,34,57,87,46,83,65,309,2000};
          System.out.println("数组元素的为:");
          for (int num:arr){
              System.out.print(num+"\t");
          }
          int min=getMin(arr);
          System.out.println("\n数组元素的最小值为:"+min);
        }
    }