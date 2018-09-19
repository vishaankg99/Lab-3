import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.lang.String;

public class Main {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {

        String url = "http://erdani.com/tdpl/hamlet.txt";
        String script;
        script = urlToString(url);
        script = script.toLowerCase();
        String[] scriptSplit = script.split(" ");
        int count = 0;
        //for (String val : scriptSplit) {
        //     System.out.println(val);

        for(int i = 0; i < scriptSplit.length; i++) {

            if (scriptSplit[i].contains("prince")) {
                count++;
            }
        }
        System.out.println(count);

    }
}



