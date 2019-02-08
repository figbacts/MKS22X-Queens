public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  public boolean addQueen(int r, int c){
    board[r][c] = -1;
    for (int h = c + 1; h < board[r].length; h ++){
      board[r][h] = board[r][h] + 1;
      if (r+h-c < board.length){
        board[r + h - c][h] += 1;
      }
      if(r - h  +c > -1 ){
        board[r - h + c][h] += 1;
      }
    }
    return true;
  }
  private boolean removeQueen(int r, int c){
    board[r][c] = 0;
    for (int h = c + 1; h < board[r].length; h ++){
      board[r][h] = board[r][h] -1;
      if (r+h-c < board.length){
        board[r + h - c][h] -= 1;
      }
      if(r - h  +c > -1 ){
        board[r - h + c][h] -= 1;
      }
    }
    return true;
  }
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
QueenBoard test = new QueenBoard(4);
test.addQueen(2,1);
test.removeQueen(2,1);
System.out.println(test);
}
}
