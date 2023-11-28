import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Query {
    private List<Word> keyWords  = new ArrayList<>();;
    public Query(String searchPhrase){
        String[] s = searchPhrase.split(" ");
        int t = 0;
        while (t < s.length) {
            String p = s[t];
            if (!Word.createWord(p).isKeyword() == true) {
            } else {
                keyWords.add(Word.createWord(p));
            }
            t++;
        }
    }

    public List<Word> getKeywords(){
        return keyWords;
    }

    public List<Match> matchAgainst(Doc d){
        List<Match> y = new ArrayList<>();
        for (Word keyWord : keyWords) {
            int freq = (int) d.getTitle().stream().filter(keyWord::equals).count();
            freq += d.getBody().stream().filter(keyWord::equals).count();
            if(d.getBody().contains(keyWord))y.add(new Match(d, keyWord, freq, d.getBody().indexOf(keyWord))) ;
            else if(d.getTitle().contains(keyWord)) y.add(new Match(d, keyWord, freq, d.getTitle().indexOf(keyWord)));
        }
        Collections.sort(y,(m1,m2)->m1.compareTo(m2));
        return y;
    }
}

