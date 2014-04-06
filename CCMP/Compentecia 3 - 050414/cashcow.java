import java.util.ArrayList;
import java.util.Scanner;

public class cashcow {

    static final int W = 10;
    static final int H = 12;
    static int count = 120;
    static int removeCount = 0;
    static ArrayList<ArrayList<Integer>> tmp;
    static ArrayList<ArrayList<Character>> game;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, r, c;
        do {
            n = in.nextInt();
            if (n == 0) {
                break;
            }
            game = new ArrayList<ArrayList<Character>>();
            count = 120;
            removeCount = 0;
            for (int i = 0; i < W; ++i) {
                game.add(new ArrayList<Character>(H));
            }
            for (int i = 0; i < H; ++i) {
                char[] values = in.next().toCharArray();
                for (int j=0; j < W; ++j) {
                    game.get(j).add(values[j]);
                }
            }
            for (int i = 0; i < n; ++i) {
                r = in.next().charAt(0) - 'a';
                c = 12 - in.nextInt();
                tmp = new ArrayList<ArrayList<Integer>>();
                process(r, c, getChar(r, c));                
                if(removeCount<3) {
                    for(int j=0;j<tmp.size();++j) {
                        game.get(tmp.get(j).get(0)).set(tmp.get(j).get(1), (char)tmp.get(j).get(2).intValue());
                    }
                    count += removeCount;
                }
                compress();
                removeCount = 0;
            }
            System.out.println(count);
        } while (true);
    }

    static char getChar(int i, int j) {
        if(i>-1 && j>-1 && game.size()>i && game.get(i).size()>j) {
            return game.get(i).get(j);
        }
        return '*';      
    }
    
    static void process(int i, int j, char c) {
        if(c!='*' && game.get(i).get(j)==c) {
            tmp.add(new ArrayList<Integer>());
            tmp.get(tmp.size()-1).add(i);
            tmp.get(tmp.size()-1).add(j);
            tmp.get(tmp.size()-1).add((int)game.get(i).get(j));
            game.get(i).set(j,'*');
            count--;
            removeCount++;
            if(getChar(i-1, j)!='*') {
                process(i-1, j, c);
            } 
            if(getChar(i+1, j)!='*') {
                process(i+1, j, c);
            }            
            if(getChar(i, j-1)!='*') {
                process(i, j-1, c);
            }            
            if(getChar(i, j+1)!='*') {
                process(i, j+1, c);
            }            
        }
    }
    
    static void compress() {
        boolean empty;
        int aux = 0;
        for(int i=0;i<W && aux<W;++i) {
            empty = true;
            for(int j=0;j<H;++j) {
                if(game.get(i).get(j)!='*') {
                    empty = false;
                    break;
                }
            }
            if(empty) {
               game.add(game.get(i));
               game.remove(i);
               i--;
            }else{
                for(int k=0;k<W;++k) {
                    for(int l=H-1;l>=0;--l) {
                        if(game.get(k).get(l)=='*') {
                            game.get(k).remove(l);
                            game.get(k).add(0,'*');
                        }
                    }
                }
            }
            aux++;
        }        
    }
}