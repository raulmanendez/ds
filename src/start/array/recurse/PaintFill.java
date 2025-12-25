package start.array.recurse;

enum Color  {
	red,blue,black,yellow
}

public class PaintFill {

	boolean paintFill(Color screen[][],int r,int c,Color color) {
		if(screen[r][c]==color) return false;
		return paintFillRecurse(screen, r, c, screen[r][c], color);
	}

	boolean paintFillRecurse(Color screen[][],int r,int c,Color ocolor,Color ncolor) {
		if(r<0 || r>=screen.length || c<0 || c>=screen.length) {
			return false;
		}


		if(screen[r][c]==ocolor) {
			screen[r][c]=ncolor;

			paintFillRecurse(screen, r - 1, c, ocolor, ncolor);
			paintFillRecurse(screen, r + 1, c, ocolor, ncolor);
			paintFillRecurse(screen, r, c - 1, ocolor, ncolor);
			paintFillRecurse(screen, r, c + 1, ocolor, ncolor);
		}

		return true;
	}


}
