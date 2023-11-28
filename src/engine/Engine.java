import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Engine{
    private Doc[] docs ;

    public int loadDocs(String dirname) {
        try{
            File[] m = (new File(dirname)).listFiles();
            int n = m.length;
            docs = new Doc[n];
            int b = 0;
            if (b < m.length) {
                do {
                    try {
                        BufferedReader v = new BufferedReader(new FileReader(m[b]));
                        String l1 = v.readLine();
                        String l2 = v.readLine();
                        String nextLine  = "\n";
                        String totalLine = l1 + nextLine + l2;
                        docs[b] = new Doc( totalLine);
                        v.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    b++;
                } while (b < m.length);
            }
            return m.length;
        }catch (Exception e){
            return 0;
        }
    }

    public Doc[] getDocs(){
        return  docs;
    }

    public List<Result> search(Query q){
        List<Result> m = new ArrayList<>();
        List<Doc> e = new ArrayList<>();
        Arrays.stream(docs).forEach(x->e.add(x));
        e.forEach(x-> {if(q.matchAgainst(x).size() != 0) m.add(new Result(x, q.matchAgainst(x)));});
        m.sort((p,o)-> o.compareTo(p));
    return m;
    }

    public String htmlResult(List<Result> results){
        String m = "";
        Iterator<Result> iterator = results.iterator();
        while (iterator.hasNext()) {
            Result result = iterator.next();
            m = m + result.htmlHighlight();
        }
        return m.toString();
    }
}