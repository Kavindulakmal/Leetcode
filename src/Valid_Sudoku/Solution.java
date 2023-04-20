//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.

//Input: board =
        //[["5","3",".",".","7",".",".",".","."]
        //,["6",".",".","1","9","5",".",".","."]
       // ,[".","9","8",".",".",".",".","6","."]
       // ,["8",".",".",".","6",".",".",".","3"]
       // ,["4",".",".","8",".","3",".",".","1"]
       // ,["7",".",".",".","2",".",".",".","6"]
        //,[".","6",".",".",".",".","2","8","."]
        //,[".",".",".","4","1","9",".",".","5"]
        //,[".",".",".",".","8",".",".","7","9"]]
       // Output: true//

package Valid_Sudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        int validFrequecy[]={1,1,1,1,1,1,1,1,1};

        //For all rows
        for(int i=0;i<9;i++)
        {
            int[] tempFrequencyOfRow=new int[9];
            int[] tempFrequencyOfColumn=new int[9];

            //For Row & Column
            for(int j=0;j<9;j++)
            {
                char tempOfRow=board[i][j];
                char tempOfColumn=board[j][i];

                if(tempOfRow!='.')
                    tempFrequencyOfRow[Character.getNumericValue(tempOfRow)-1]++;

                if(tempOfColumn!='.')
                    tempFrequencyOfColumn[Character.getNumericValue(tempOfColumn)-1]++;
            }

            if(!isValid(tempFrequencyOfRow) || !isValid(tempFrequencyOfColumn))
                return false;
        }
        //For 3x3 cells
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                int[] tempFrequency=new int[9];
                for(int m=0;m<3;m++)
                {
                    for(int n=0;n<3;n++)
                    {
                        char temp=board[i*3+m][j*3+n];
                        if(temp!='.')
                            tempFrequency[Character.getNumericValue(temp)-1]++;
                    }
                }
                if(!isValid(tempFrequency))
                    return false;
            }
        }
        return true;
    }

    boolean isValid(int arr[])
    {
        for(int i=0;i<9;i++)
            if(arr[i]>1)
                return false;
        return true;
    }
}
