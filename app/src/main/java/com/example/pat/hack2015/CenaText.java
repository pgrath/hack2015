package com.example.pat.hack2015;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by ANNIE on 11/7/2015.
 */
public class CenaText {
    List<String> idDict = Arrays.asList("is", "the", "are", "was", "were");
    List<String> suffDict = Arrays.asList("able", "ible", "al", "ial", "ed", "en", "er", "est", "ful", "ic",
            "ing", "ion", "tion", "ation", "ition", "ity", "ty", "ive",
            "ative", "itive", "less", "ly", "ment", "ness", "ous", "eous",
            "ious");
    List<String> preDict = Arrays.asList("anti", "de", "dis", "en", "em", "fore", "in", "im",
            "in", "il", "ir", "inter", "mid", "mid", "mis", "non",
            "non", "over", "pre", "re", "semi", "sub", "super", "trans",
            "un", "under");
    String vowDict = "aeiou";
    //char[] endDict = {' ', '/0', '/n', '.'};
    List<String> keyWords = Arrays.asList("John", "Cena");

    boolean nextWordFlag = true;

    public String getPrefix( String word )
    {
        int count = 0;
        List<String> genDict = new ArrayList<String>();
        for( int i = 0; i < word.length(); i++)
        {
            genDict.clear();
            for (String item : preDict) {
                if (item.length() > count) {
                    genDict.add(item.substring(0,count));
                }
            }
            for (String item: genDict) {
                if (word.substring(0, count).equals(item))
                {
                    return word.substring(0,count);
                }
            }
        }
        return "";
    }

    public String getSuffix( String word )
    {
        int count = 0;
        List<String> genDict = new ArrayList<String>();
        for( int i = 0; i < word.length(); i++)
        {
            genDict.clear();
            for (String item : preDict) {
                if (item.length() > count) {
                    genDict.add(item.substring(-count));
                }
            }
            for (String item: genDict) {
                if (word.substring(-count).equals(item))
                {
                    return word.substring(-count);
                }
            }
        }
        return "";
    }

    public String Cenafy( String word )
    {
        String prefix = getPrefix( word );
        String suffix = getSuffix( word );
        if ( vowDict.contains(word.substring(-suffix.length()))  )
        {
            return prefix + keyWords.get(0) + suffix;
        }
        return prefix + keyWords.get(1) + suffix;
    }

    



}
