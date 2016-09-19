package comp1110.ass2.logic;


/**
 * Created by Allen Huang on 15/08/2016.
 * Edited by Marvin and William on 15/08/2016.
 */

public class Score {
    static Colour[][] greencolor=new Colour[26][26];
    static int[][]greenheight=new int[26][26];
    static int maxgreeenheight=0;

    static Colour[][] redcolor=new Colour[26][26];
    static int[][]redheight=new int[26][26];
    static int maxredheight=0;

    // Calculates Score for given player
    public static  int GreenScore(BoardState board) {

        greencolor=board.getColourArray().clone();
        greenheight=board.getHeightArray().clone();
        int maxarea=0;
        int height=0;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(greencolor[i][j]==Colour.Green){
                    int area= explore_from_green(i,j);
                    if(area>maxarea){
                        maxarea=area;
                        height=maxgreeenheight;
                    }
                    maxgreeenheight=0;
                }
            }
        }
        return maxarea*height;

    }
    private static int explore_from_green(int i, int j) {
        int area=1;
        greencolor[i][j]=Colour.Black;
        if(greenheight[i][j]>maxgreeenheight){
            maxgreeenheight=greenheight[i][j];
        }
        if(i>0&&greencolor[i-1][j]==Colour.Green){
            area+=explore_from_green(i-1,j);
        }else if(i<25&&greencolor[i+1][j]==Colour.Green){
            area+=explore_from_green(i+1,j);
        }else if(j>0&&greencolor[i][j-1]==Colour.Green){
            area+=explore_from_green(i,j-1);
        }else if(j<25&&greencolor[i][j+1]==Colour.Green){
            area+=explore_from_green(i,j+1);
        }
        return area;

    }

    private static int explore_from_red(int i, int j) {
        int area=1;
        redcolor[i][j]=Colour.Black;
        if(redheight[i][j]>maxredheight){
            maxredheight=redheight[i][j];
        }
        if(i>0&&redcolor[i-1][j]==Colour.Red){
            area+=explore_from_red(i-1,j);
        }else if(i<25&&redcolor[i+1][j]==Colour.Red){
            area+=explore_from_red(i+1,j);
        }else if(j>0&&redcolor[i][j-1]==Colour.Red){
            area+=explore_from_red(i,j-1);
        }else if(j<25&&redcolor[i][j+1]==Colour.Red){
            area+=explore_from_red(i,j+1);
        }
        return area;

    }

    public static int RedScore(BoardState board){
        redcolor=board.getColourArray().clone();
        redheight=board.getHeightArray().clone();
        int maxarea=0;
        int height=0;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(redcolor[i][j]==Colour.Red){
                    maxredheight=0;
                    int area= explore_from_red(i,j);
                    if(area>maxarea){
                        maxarea=area;
                        height=maxredheight;
                    }
                }
            }
        }
        return maxarea*height;
    }

    public static int getScore(BoardState board, boolean color) {

        if(color){
            return GreenScore(board);
        }
        return RedScore(board);
    }


}

