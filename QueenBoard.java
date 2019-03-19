public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  public boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    }
    else {
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
}

  private boolean removeQueen(int r, int c){
    if (board[r][c] > 0){
      return false;
    }
    else {
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
}
  public String toString(){
    String ans = "";
    for (int row = 0; row < board.length; row ++){
      for (int col = 0; col < board[row].length; col++){
        if (board[row][col] < 0){
          ans = ans + "Q ";
        }
        else{
      ans = ans +"_ ";
    }
    }
    ans = ans + "\n";
    }
    return ans;
  }
  public boolean solve(){
    for (int row = 0; row < board.length; row ++) {
      for (int col = 0; col < board[row].length; col ++) {
        if (board[row][col] != 0) {
          throw new IllegalStateException("Invalid Board");
        }
      }
    }
    return helper1(this,board,0);
  }
  public static boolean helper1(QueenBoard test, int[][] board, int col){
  if (col >= board.length){
    return true;
  }
  for(int r = 0; r < board.length; r ++){
    if (test.addQueen(r,col)){
      //System.out.println(Text.go(1,1));
      //System.out.println(test);Text.wait(500); //adjust this delays
      if (helper1(test,board,col+1)){
        return true;
      }
      test.removeQueen(r,col);
    }
    }

  return false;
}
public int countSolutions(){
  for (int row = 0; row < board.length; row ++) {
    for (int col = 0; col < board[row].length; col ++) {
      if (board[row][col] != 0) {
        throw new IllegalStateException("Invalid Board");
      }
    }
  }
  return helper2(this,board,0);
}
public static int helper2(QueenBoard test, int [][] board, int col){
  int ans = 0;
  if (col >= board.length){
    return 1;
  }
  for(int r = 0; r < board.length; r ++){
    if (test.addQueen(r,col)){
      //System.out.println(Text.go(1,1));
      //System.out.println(test);Text.wait(5); //adjust this delays
      ans += helper2(test,board,col+1);
    }
      test.removeQueen(r,col);
    }
    return ans;
}
<<<<<<< HEAD
public static void main(String[] args){
=======
public static void runTest(int i){
  QueenBoard b;
  int[]tests =   {1,2,3,4,5,8};
  int[]answers = {1,0,0,2,10,92};
  if(i >= 0 && i < tests.length ){
    int size = tests[i];
    int correct = answers[i];
    b = new QueenBoard(size);
    int ans  = b.countSolutions();

    if(correct==ans){
      System.out.println("PASS board size: "+tests[i]+" "+ans);
    }else{
      System.out.println("FAIL board size: "+tests[i]+" "+ans+" vs "+correct);
    }
  }
}

public static void main(String[] args){
  //runTest(0);
  //runTest(1);
  //runTest(2);
  //runTest(3);
  //runTest(4);
  //runTest(5);
>>>>>>> ec051f40a70ed673c27238bc17d556e0987c6135
//QueenBoard test = new QueenBoard(5);
//System.out.println(test.countSolutions());
//System.out.println(test.solve());
//test.addQueen(0,0);
//test.addQueen(0,1);
//test.removeQueen(0,0);

//System.out.println(test);
}
}
