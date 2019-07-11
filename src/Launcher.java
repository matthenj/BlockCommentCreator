import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Launcher {


    public static final int COMMENT_WIDTH = 80;
    private static String startComment;
    private static String endComment;
    private static String commentPrefix;
    private static String date;


    public static void main(String[] args){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < COMMENT_WIDTH-1; i++) {
            sb.append("*");
        }

        startComment = "/" + sb.toString() + System.lineSeparator();
        endComment = sb.toString() + "/" + System.lineSeparator();
        commentPrefix = " *\t";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date currentdate = new Date();
        date = (dateFormat.format(currentdate)); //2016/11/16 12:08:43

        if(args.length == 0){
            CommentCreator.createAndShowGUI();
        }



    }

    public static String format(String fileName, String author, String description){

        StringBuilder sb = new StringBuilder(startComment);
        //oneline whitespace
        String nl = System.lineSeparator();
        String eli = commentPrefix + nl;
        sb.append(eli);
        sb.append(commentPrefix).append("Filename   :\t").append(fileName).append(nl);
        sb.append(eli);
        sb.append(commentPrefix).append("Author     :\t").append(author).append(nl);
        sb.append(eli);
        sb.append(eli);
        sb.append(commentPrefix).append("Description:\t").append(nl);
        sb.append(eli);
        sb.append(formatDescription(description));
        sb.append(eli);
        sb.append(commentPrefix).append("Version History: ").append(date).append(" (initial version)").append(nl);
        sb.append(eli);
        sb.append(endComment);


        return sb.toString();
    }

    private static String formatDescription(String strToFormat){

        String tmp = strToFormat.replace(System.lineSeparator(), " ") + " ";

        StringBuilder sbr = new StringBuilder();

        int sOfC = 0;

        while(sOfC < tmp.length()){



            int eOfC = sOfC + COMMENT_WIDTH-7;
            eOfC = (eOfC > tmp.length()) ? tmp.length() : eOfC;


            char c = tmp.charAt(eOfC-1);
            while(Character.isAlphabetic(c)){
                c = tmp.charAt(--eOfC);
            }

            sbr.append(commentPrefix).append(tmp.substring(sOfC, eOfC).trim()).append(System.lineSeparator());
            sOfC = eOfC;

        }


        return sbr.toString();


    }

}

