import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.PortableInterceptor.ServerRequestInfo;
import sun.util.BuddhistCalendar;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.text.DecimalFormat;

public class Search {
    public static void main(String... aArgs) throws IOException, FileNotFoundException {

            try {
                FileReader reader = new FileReader("C:\\Users\\Даулет\\Desktop\\EY\\src\\input.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;
                line = bufferedReader.readLine();
                String text = line;
                    String found = new String();
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    found = br.readLine();
                    found = found.toString();

                DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(text);
                otherSymbols.setDecimalSeparator('.');
                otherSymbols.setGroupingSeparator(',');
                DecimalFormat df = new DecimalFormat(text);
                    //System.out.println(found);
                text.replace("%s.%s","%s,%s");

                System.out.println(Search(found, text));
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    public static String Search(String search, String text){
        String statement = new String();

        search = search.toLowerCase().replace(" when ", "");
        search = search.toLowerCase().replace(" he ", "");
        search = search.toLowerCase().replace(" she ", "");
        search = search.toLowerCase().replace(" it ", "");
        search = search.toLowerCase().replace(" what ", "");
        search = search.toLowerCase().replace(" where ", "");
        search = search.toLowerCase().replace(" which ", "");
        search = search.toLowerCase().replace(" if ", "");
        search = search.toLowerCase().replace(" then ", "");
        search = search.toLowerCase().replace(" or ", "");
        search = search.toLowerCase().replace(" else ", "");
        search = search.toLowerCase().replace(" why ", "");
        search = search.toLowerCase().replace(" when ", "");
        search = search.toLowerCase().replace(" is ", "");
        search = search.toLowerCase().replace(" when ", "");
        search = search.toLowerCase().replace(" need ", "");
        search = search.toLowerCase().replace(" do ", "");
        search = search.toLowerCase().replace(" you ", "");
        search = search.toLowerCase().replace(" i ", "");
        search = search.toLowerCase().replace(" me ", "");
        search = search.toLowerCase().replace(" we ", "");
        search = search.toLowerCase().replace(" they ", "");
        search = search.toLowerCase().replace(" there ", "");
        search = search.toLowerCase().replace(" how ", "");
        search = search.toLowerCase().replace(" much ", "");
        search = search.toLowerCase().replace(" many ", "");
        search = search.toLowerCase().replace(" are ", "");
        search = search.toLowerCase().replace(" ? ", "");
        search = search.toLowerCase().replace(" the ", "");
        search = search.toLowerCase().replace(" , ", "");
        search = search.toLowerCase().replace(" . ", "");
        search = search.toLowerCase().replace(" when ", "");
        search = search.toLowerCase().replace(" our ", "");
        search = search.toLowerCase().replace(" can ", "");
        search = search.toLowerCase().replace(" cannot ", "");
        search = search.toLowerCase().replace(" should ", "");
        search = search.toLowerCase().replace(" must ", "");
        search = search.toLowerCase().replace(" when ", "");
        search = search.toLowerCase().replace(" to ", "");
        search = search.toLowerCase().replace(" of ", "");
        search = search.toLowerCase().replace("?", "");
        search = search.toLowerCase();

        String []strArray = search.split(" ");
        int i =0;
        for( i=0; i<strArray.length;i++) {
        }
        if (search.trim().length() == 0){
            statement = "Enter valid statement";
            return statement;
        }else{
            int min=0;
            int max=0;
            int F2min=0;
            int L2max=0;
            int maxMatches=0;
            int mathc=0;
            String header;
            min = text.indexOf('#')+1;
            max = text.indexOf('#', min);
            header = text.substring(min, max);
            for(int j=0;j<i;j++){
                if(header.toLowerCase().contains(strArray[j].toLowerCase())){
                    mathc++;
                }
            }
            maxMatches = mathc;
            F2min = text.trim().indexOf('#', max+1)+1;
            L2max = text.trim().indexOf('#', F2min+1);
            do{
                header = text.substring(F2min, L2max);
                //System.out.println(header);
                mathc = 0;
                for(int j=0;j<i;j++){
                    if(header.toLowerCase().contains(strArray[j].toLowerCase())){
                        mathc++;
                    }
                }
                if(mathc>maxMatches){
                    min = F2min;
                    max = L2max;
                    maxMatches = mathc;
                }
                F2min = text.trim().indexOf('#', L2max+1)+1;
                L2max = text.trim().indexOf('#', F2min+1);
            }while(F2min!=0);
            if(maxMatches>0){
                min = max;
                header = text.substring(min+1, text.indexOf('#', min+1));


                ArrayList<String> items = new ArrayList<String>(Arrays.asList(header.split("[\\.|\\?|\\!]")));
                int l =0;
                for (l = 0; l < items.size(); l++) {
                }

                String[] sentences = new String[l];
                int k = 0;
                for(k =0; k<l;k++){
                    sentences[k] = items.get(k).trim()+".";
                }

                l=0;
                int match =0;
                int subMaxMatches =0;
                Integer[] chooser = new Integer[k];
                do{
                    match =0;
                    for(int p=0; p<i;p++) {
                        if (sentences[l].toLowerCase().contains(strArray[p].toLowerCase())){
                            match++;
                        }
                    }
                    if(match>subMaxMatches){
                        subMaxMatches = match;
                    }
                    chooser[l] = match;
                    l++;
                }while(l!=k);
                String output="";
                for(int p=0;p<k;p++){
                    if(chooser[p]==subMaxMatches){
                        output+=sentences[p];
                    }
                }
                output.replace('#',' ');
                output.replace('@', ' ');
                output.replace('*', ' ');
                return output;
            }else{
                String output = "";
                ArrayList<String> items = new ArrayList<String>(Arrays.asList(text.split("[\\.|\\?|\\!]")));
                int l =0;
                for (l = 0; l < items.size(); l++) {
                }

                String[] sentences = new String[l];
                int k = 0;
                for(k =0; k<l;k++){
                    sentences[k] = items.get(k).trim()+".";
                }

                l=0;
                int match =0;
                int subMaxMatches =0;
                Integer[] chooser = new Integer[k];
                do{
                    match =0;
                    for(int p=0; p<i;p++) {
                        if (sentences[l].toLowerCase().contains(strArray[p].toLowerCase())){
                            match++;
                        }
                    }
                    if(match>subMaxMatches){
                        subMaxMatches = match;
                    }
                    chooser[l] = match;
                    l++;
                }while(l!=k);
                for(int p=0;p<k;p++){
                    if(chooser[p]==subMaxMatches){
                        output+=sentences[p];
                    }
                }
                output.replace('#',' ');
                output.replace('@', ' ');
                output.replace('*', ' ');
                return output;
            }
        }
    }

    /*
    public static Queue Header(String text){
        text = text.replace("\n", "").replace("\r", "");
        Queue<String> headers = new LinkedList();
        int Findex = text.trim().indexOf('#')+1;
        int Lindex = text.trim().indexOf('#',Findex);
        do{
            headers.add(text.trim().substring(Findex, Lindex));
            Findex = text.trim().indexOf('#', Lindex+1)+1;
            Lindex = text.trim().indexOf('#', Findex+1);
        }while (Findex!=0);
        return headers;
    }*/

    public static int countWords(String s){

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
