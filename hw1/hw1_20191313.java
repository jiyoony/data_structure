import java.util.*;
import java.util.Stack;

class offsets{
	int a,b;
	public offsets(int _a, int _b){
 a = _a;
 b = _b;
}
};
// offset


class MazeCell{
	int f; int q; int w;
	public MazeCell(int _f, int _q, int _w){
		f= _f;
		q= _q;
		w= _w;
	}
};
/**
 * Maze Class
 *
 */

class Maze {
	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking

	public Maze(int m, int p) {
		maze = new int[m + 2][p + 2];
		mark = new int[m + 2][p + 2];
		for(int i = 0; i < m + 2; i++)
			for(int j = 0; j < p + 2; j++) {
				maze[i][j] = 1;
				mark[i][j] = 0;
			}
	}

	// create the maze structure
	public void SetWall(int i, int j, int val) {
		maze[i][j] = val;
	}

	offsets[] move ={
			new offsets(1,0),//S
			new offsets(1,-1),//SW
			new offsets(0,-1),//W
			new offsets(-1,-1),//NW
			new offsets(-1,0),//N
			new offsets(-1,1),//NE
			new offsets(0,1),//E
			new offsets(1,1) //SE

	};

	public void Path(int m, int p) {
		boolean first = true;
		String str="";
		int d=0;
		Stack <MazeCell> stack= new Stack<MazeCell>();
		int i=1; int j=1;
		mark[i][j]=1;
		stack.push(new MazeCell(1,1,0));
		while (stack.isEmpty()!=true){
			i=stack.peek().f;
			j=stack.peek().q;
			d=stack.peek().w;
			stack.pop();
		while(d<8){
		int g= i + move[d].a;
		int h= j + move[d].b;
		if((g==m)&&(h==p)){
			first=false;
			stack.push(new MazeCell(i,j,d));
			stack.push(new MazeCell(g,h,d));
		 while(!stack.empty()){
			 str=("("+stack.peek().f+","+stack.peek().q+")"+"\n")+str;
			 stack.pop();
}
			System.out.print(str);
			break;
		 }
		if ((maze[g][h]!=1)&& (mark[g][h]!=1)){
			mark[g][h]=1;
			stack.push(new MazeCell(i,j,d));
			i=g;
			j=h;
			d=0;
		}
		else {d++;}
}
}
 if (first){
		System.out.println("No path in the maze.");
	}
}
};
