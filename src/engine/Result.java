import java.util.Iterator;
import java.util.List;

public class Result implements Comparable<Result>{
    private int x = 0;
    private double y = 0;
    private Doc z;
    List<Match> g;

    public Result(Doc d, List<Match> matches){
        this.g = matches;
        this.z = d;
        int q = 0;
        int i = 0;
        while (i < matches.size()) {
            x = x + matches.get(i).getFreq();
            q += matches.get(i).getFirstIndex();
            i++;
        }
        y =  q/matches.size();
    }

    public List<Match> getMatches(){
        return g;
    }

    public Doc getDoc(){
        return z;
    }

    public int getTotalFrequency(){
        return x;
    }

    public double getAverageFirstIndex(){
        return y;
    }

    public String htmlHighlight(){
        StringBuffer l = new StringBuffer("<h3>");
        List<Word> u = z.getTitle();
        for (int i = 0, k = u.size(); i < k; i++) {
            Word r = u.get(i);
            for (Match match : g) {
                String textPart = match.getWord().getText();
                if (!r.getText().equalsIgnoreCase(textPart)) {
                    continue;
                }
                String h = "<u>" + r.getText() + "</u>";
                r.setWord(r.getPrefix() + h + r.getSuffix());
            }
        }
        for (int i = 0; i < z.getTitle().size(); i++) {
            Word t1 = z.getTitle().get(i);
            String t1S = t1.toString();
            l.append(t1S + " ");
        }
        l.deleteCharAt(l.length()-1);
        l.append("</h3>"); l.append("<p>");
        for (Iterator<Word> k = z.getBody().iterator(); k.hasNext(); ) {
            Word b = k.next();
            int i = 0, gSize = g.size();
            while (i < gSize) {
                Match h = g.get(i);
                String textPart = h.getWord().getText();
                if (b.getText().equalsIgnoreCase(textPart)) {
                    String tag = "<b>" + b.getText() + "</b>";
                    b.setWord(b.getPrefix() + tag + b.getSuffix());
                }
                i+=1;
            }
        }
        for (Iterator<Word> m = z.getBody().iterator(); m.hasNext(); ) {
            Word t = m.next();
            String str = t.toString();
            l.append(str + " ");
        }
        l.deleteCharAt(l.length()-1);
        l.append("</p>");
        return l.toString();
    }
    public int compareTo(Result o){
        int bg = getMatches().size();
        int bn = o.getMatches().size();
        int nj = getTotalFrequency();
        int nm = o.getTotalFrequency();
        double ab = getAverageFirstIndex();
        double cd = o.getAverageFirstIndex();
        if(bg > bn) {
            return 1;
        } else if(bg == bn) {
            if (nj != nm) {
                if (nj > nm) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if (ab == cd) {
                    return 0;
                } else {
                    if (!(ab < cd)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        }
        return -1;
    }
}
