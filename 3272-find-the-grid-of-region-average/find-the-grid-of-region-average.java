class Solution {
    private int intenseImage(int nums[][],int x,int y,int t){
        boolean res = Math.abs(nums[x][y] - nums[x-1][y]) <= t &&
         Math.abs(nums[x][y] - nums[x+1][y]) <= t && 
         Math.abs(nums[x][y] - nums[x][y-1]) <= t &&
         Math.abs(nums[x][y] - nums[x][y + 1]) <= t && 
         Math.abs(nums[x - 1][y - 1] - nums[x-1][y]) <= t &&
         Math.abs(nums[x - 1][y + 1] - nums[x-1][y]) <= t && 
         Math.abs(nums[x - 1][y - 1] - nums[x][y - 1]) <= t && 
         Math.abs(nums[x - 1][y + 1] - nums[x][y + 1]) <= t &&
         Math.abs(nums[x + 1][y] - nums[x+1][y-1]) <= t &&
         Math.abs(nums[x + 1][y - 1] - nums[x][y-1]) <= t && 
         Math.abs(nums[x + 1][y + 1] - nums[x][y+1]) <= t && 
         Math.abs(nums[x + 1][y + 1] - nums[x + 1][y]) <= t;
         if(!res) return -1;
         else{
            int sum = 0;
            for(int l = -1 ; l < 2 ; l++){
                for(int m = -1 ; m < 2 ; m++){
                    int tx = l + x;
                    int ty = m + y;
                    sum = sum + nums[tx][ty];
                }
            }
            return sum / 9;
         }
    } 
    public int[][] resultGrid(int[][] image, int threshold) {
        int grid[][] = new int[image.length][image[0].length];
        int count[][] = new int[image.length][image[0].length];
        for(int i = 1 ; i < image.length - 1 ; i++){
            for(int j = 1 ; j < image[0].length - 1 ; j++){
                int retVal = 0;
                if((retVal = intenseImage(image, i, j, threshold)) != -1){
                    for(int l = -1 ; l < 2 ; l++){
                        for(int m = -1 ; m < 2 ; m++){
                            int x = l + i;
                            int y = m + j;
                            grid[x][y] += retVal;
                            count[x][y]++;
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < image.length ; i++){
            for(int j = 0; j < image[0].length ;j++){
                if(count[i][j] != 0){
                    image[i][j] = grid[i][j] / count[i][j];
                }
            }
        }
        return image;
    }
}