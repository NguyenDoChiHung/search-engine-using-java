import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {

    public static Set<String> stopWords = new LinkedHashSet<String>();
    
    private String hh;

    private Word(String word){
        this.hh = word;
    }
    
    public static Word createWord(String rawText){
        return new Word(rawText);
    }

    public void setWord(String word){
        this.hh = word;
    }

    public boolean isKeyword(){
        String checkWord = hh;
        String aa = "([a-zA-Z0-9[-]]+)";
        Pattern bb = Pattern.compile(aa);
        Matcher cc = bb.matcher(hh);

        if (cc.find()) {
            checkWord = cc.group(0);
        }

        for (Iterator<String> m = stopWords.iterator(); m.hasNext(); ) {
            String mm = m.next();
            if (checkWord.equalsIgnoreCase(mm) == false){

            }else{
                return false;

            }
        }
        String bh = "^[a-zA-Z[-]]+$";
        if (Pattern.compile(bh).matcher(checkWord).find()) return true;
        else return false;
    }

    public  String getText(){
        String dcw = hh;
        Pattern a = Pattern.compile("([a-zA-Z0-9[-]]+)");
        Matcher matcher = Pattern.compile("([a-zA-Z0-9[-]]+)").matcher(hh);
        if(matcher.find())   dcw = matcher.group(0);
        Pattern wordPattern = Pattern.compile("^[a-zA-Z[-]]+$");
        if (!wordPattern.matcher(dcw).find()) return hh;
        return dcw;
    }

    public String getPrefix(){
        int bruh = hh.indexOf(getText());
        if (isKeyword()) return hh.substring((1 - 1), bruh);
        return "";
    }

    public String getSuffix(){
        int bruh = getPrefix().length();
        int lmao = getText().length();
        return !isKeyword() ? "" : hh.substring(bruh + lmao);
    }

    public static boolean loadStopWords(String fileName){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String br ;
            do{
                br = bufferedReader.readLine();
                if(br != null){
                    stopWords.add(br);
                }
            }while (br != null);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean equals(Object o){
        Word temp = (Word) o;
        if (getText().equalsIgnoreCase(((Word) o).getText())) return true;
        else return false;
    }

    @Override
    public String toString() {
        return hh;
    }
}
