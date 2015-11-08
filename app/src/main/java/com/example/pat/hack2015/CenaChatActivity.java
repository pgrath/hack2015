package com.example.pat.hack2015;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CenaChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cena_chat);
    }

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

    //work
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cena, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    boolean nextWordFlag = true;

    public String getPrefix( String word )
    {
        List<String> genDict = new ArrayList<String>();
        for( int i = 0; i < word.length(); i++)
        {
            genDict.clear();
            //for (String item : preDict) {
            //    if (item.length() > i) {
            //        genDict.add(item.substring(0,i+1));
            //    }
            //}
            for (String item: preDict) {
                if (word.substring(0, i+1).equals(item))
                {
                    return word.substring(0,i+1);
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
            //  for (String item : suffDict) {
            //   if (item.length() > i) {
            //     genDict.add(item.substring(word.length()-i-1));
            //}
            //}
            for (String item: suffDict) {
                if (word.substring(word.length()-i-1).equals(item))
                {
                    return word.substring(word.length()-i-1);
                }
            }
        }
        return "";
    }

    public String Cenafy( String word )
    {
        String prefix = getPrefix(word);
        String suffix = getSuffix( word );
        Random ran=new Random();
        int number=ran.nextInt(2);
        if ( vowDict.contains(suffix.substring(0))  )
        {
            return prefix + keyWords.get(number) + suffix;
        }
        return prefix + keyWords.get(0) + suffix;
    }

    public void processsSentance(View view) throws IOException {
        EditText abc;
        abc = (EditText) findViewById(R.id.editText2);
        TextView tv;
        tv = (TextView) findViewById(R.id.text_main);
        ArrayList<String> theInfo = new ArrayList<String>();
        String def = abc.getText().toString();

        for (String word : def.split(" ")) {
            theInfo.add(word);
        }


        boolean done = false;
        boolean nextWordFlag = false;
        int prev = 0;
        int count;
        String word;
        tv.setText("");
        try {
            for (count = 0; count < theInfo.size(); count++) {
                if (theInfo.get(count).equals("is") || theInfo.get(count).equals("the") || theInfo.get(count).equals("are") || theInfo.get(count).equals("was") || theInfo.get(count).equals("were")) {
                    word = theInfo.remove(count + 1);
                    theInfo.add(count + 1, Cenafy(word));

                }
            }
        } catch (IndexOutOfBoundsException e) {
            tv.append("JOHN CENA");
        }
        for (count = 0; count < theInfo.size(); count++) {
            tv.append(theInfo.get(count) + " ");

        }
        // while(!done)
        // {
        //  if(count==theInfo.size())
        //{
        //   done = true;
        // continue;
        //}
        //boolean wordFin = false;
        //while(!wordFin)
        //{
        // word=theInfo.get(count);
        //count+=1;
        //if(theInfo.get(count).equals("")||theInfo.get(count).equals(".")||theInfo.get(count).equals("!")||theInfo.get(count).equals("?"))
        //{
        //if(nextWordFlag)
        //{
        // theInfo.add(count,theInfo.get(prev));
        // prev=count;
        // }
        // if(theInfo.get(count).equals("is")||theInfo.get(count).equals("the")||theInfo.equals("are")||theInfo.equals("was")||theInfo.equals("were"))
        //{
        //nextWordFlag=true;
        // }
        //}
        //}
        //}
        //for(int i=0;i<theInfo.size();i++)
        //{
        //  tv.append(theInfo.get(count));
        //}

        //   }
    }

}
