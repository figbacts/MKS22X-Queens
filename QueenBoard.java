public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  public boolean addQueen(int r, int c){
    board[r][c] = -1;
    return true;
  }
  //private boolean removeQueen(int r, int c){

  //}
  public String toString(){
    String ans = "";
    for (int row = 0; row < board.length; row ++){
      for (int col = 0; col < board[row].length; col++){
      ans = ans + board[row][col] + " ";
    }
    ans = ans + "\n";
    }
    return ans;
  }
public static void main(String[] args){
QueenBoard test = new QueenBoard(10);
test.addQueen(4,4);
System.out.println(test);
}
}
