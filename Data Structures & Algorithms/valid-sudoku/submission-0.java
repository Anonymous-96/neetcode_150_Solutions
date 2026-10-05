//Brute Force ==> Check first that row doesnt have dup;icate values 
// 2. For columns also check for duplicates
// 3. square of 3*3 check for them also
class Solution {
    boolean valid(char[][] board,int sr,int er,int sc, int ec){
        Set<Character> st = new HashSet<>();
        for(int i=sr;i<=er;i++){
            for(int j=sc;j<=ec;j++){
                if(board[i][j]=='.') continue;
                if(st.contains(board[i][j])) return false;
                st.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        //check for row
        for(int i=0;i<9;i++){
            Set<Character> st = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(st.contains(board[i][j])) return false;
                st.add(board[i][j]);
            }
        }
        //check for col
        for(int j=0;j<9;j++){
            Set<Character> st = new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][j]=='.') continue;
                if(st.contains(board[i][j])) return false;
                st.add(board[i][j]);
            }
        }
        //check for the square
        for(int sr=0;sr<9;sr+=3){
            int er=sr+2; 
            for(int sc=0;sc<9;sc+=3){
                int ec=sc+2;
                if(!valid(board,sr,er,sc,ec)) return false;
            }
        }
        return true;
    }
}
