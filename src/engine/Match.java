import java.util.Arrays;

public class Match implements Comparable<Match>{
    private Doc x;
    private Word xx;
    private int xxx;
    private int xxxx;
    
    public Match(Doc d, Word w, int freq, int firstIndex){
        this.x = d;
        this.xx = w;
        this.xxx = freq;
        this.xxxx = firstIndex;
    }

    public int getFreq(){
        return xxx;
    }

    public int getFirstIndex(){
        return xxxx;
    }

    public Word getWord(){
        return xx;
    }

    @Override
    public int compareTo(Match o) {
        if (o.getFirstIndex() < xxxx) return (2-1);
        if (xxxx < o.getFirstIndex()) return -1 ;
        return 0 ;
    }

}
