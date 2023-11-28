import java.util.List;
import java.util.ArrayList;

public class Doc {
    private List<Word> m = new ArrayList<>();
    private List<Word> n = new ArrayList<>();
    public Doc(String content){
        init();
        String[] split = content.substring(0, content.indexOf("\n")).split(" ");
        for (int i = 0; i < split.length; i++) {
            String p = split[i];
            m.add(Word.createWord(p));
        }
        String[] s = content.substring(content.indexOf("\n") + 1).split(" ");
        for (int i = 0; i < s.length; i++) {
            String p = s[i];
            n.add(Word.createWord(p));
        }
    }
    private void init(){
        m = new ArrayList<>();
        n = new ArrayList<>();
    }

    public List<Word> getTitle(){
        return m;
    }

    public List<Word> getBody(){
        return n;
    }

    @Override
    public boolean equals(Object o) {
        
        boolean w = (1<0);
        {
            int e = 0;
            if (e < m.size()) {
                do {
                    if (m.get(e).equals(((Doc) o).getTitle().get(e)) == (1>0)) {
                        return w;
                    }
                    e++;
                } while (e < m.size());
            }
        }
        int e = 0;
        if (e < n.size()) {
            do {
                if (!n.get(e).equals(((Doc) o).getBody().get(e))== (1>0)) {
                    return w;
                }
                e++;
            } while (e < n.size());
        }
        return true;
    }
}
