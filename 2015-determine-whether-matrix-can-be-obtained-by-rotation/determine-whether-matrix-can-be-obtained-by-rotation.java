class Solution {
    int n, m;
    public int[][] rotate(int[][] mat)
    {
        int[][] ans = new int[n][m];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                ans[i][j] = mat[n -1 -j][i];
            }
        }
        return ans;
    }
    public boolean check(int[][] mat, int[][] target)
    {
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
    public void display(int[][] mat)
    {
        System.out.println("Krishna222" + n);

        for(int i =0;i<n;i++)
        {

            System.out.println(Arrays.toString(mat[i]));
        }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        
        n = mat.length;
        m = mat[0].length;
        // display(mat);
        if(check(mat, target))
        {
            return true;
        } 
        for(int j = 0;j<3;j++)
        {
            mat = rotate(mat);
            // display(mat);
            if(check(mat, target))
            {
                return true;
            } 
        }
        return false;
    }
}