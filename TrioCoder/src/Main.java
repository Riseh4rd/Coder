import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static String ALPHAword,BETAword,text;
    static char[] myCharArray = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H',
            'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r',
            'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z',
            'а', 'А', 'б', 'Б', 'в', 'В', 'г', 'Г', 'д', 'Д', 'е', 'Е', 'ё', 'Ё', 'ж', 'Ж', 'з', 'З', 'и',
            'И', 'й', 'Й', 'к', 'К', 'л', 'Л', 'м', 'М', 'н', 'Н', 'о', 'О', 'п', 'П', 'р', 'Р', 'с', 'С',
            'т', 'Т', 'у', 'У', 'ф', 'Ф', 'х', 'Х', 'ц', 'Ц', 'ч', 'Ч', 'ш', 'Ш', 'щ', 'Щ', 'ъ', 'Ъ', 'ы',
            'Ы', 'ь', 'Ь', 'э', 'Э', 'ю', 'Ю', 'я', 'Я',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '[', ']', '{', '}',
            '|', '\\', ';', ':', '\'', '"', ',', '<', '.', '>', '/', '?', ' ', '№', '£', '€', '¥', '₽', '₴', '§',
            'ª', 'µ', '¿', '¡', '¤', '¥', '¨', '©', '®', '°', '±', '¶', '·', '¸', '¹', 'º', '¾', '¿','Á', 'á', 'À',
            'à', 'Â', 'â', 'Ã', 'ã', 'Ä', 'ä', 'Å', 'å', 'Æ', 'æ', 'Ç', 'ç', 'È', 'è', 'É', 'é', 'Ê', 'ê', 'Ë', 'ë',
            'Ì', 'ì', 'Í', 'í', 'Î', 'î', 'Ï', 'ï'};

    public static void main(String[] args) {
        System.out.println(myCharArray.length);
        System.out.println("Enter [ALPHA Word]\n      [BETA Word]\n      [your text]");
        Scanner input = new Scanner(System.in);
        ALPHAword = input.nextLine();
        BETAword = input.nextLine();
        text = input.nextLine();
        WordLengthEqualizer();
        System.out.println("After Equalizing: "+ALPHAword+" "+BETAword+" "+text );
        text = CODER(BETAword,text);
        System.out.println("After CODER1: "+text);
        text += BETAword;
        System.out.println("ADD BETA: "+text);
        WordLengthEqualizer();
        text = CODER(ALPHAword,text);
        System.out.println("After CODER2:["+text+"]\n\n");

        System.out.println("DECODING!!!");
        System.out.println("Enter [ALPHA Word]\n"+"[your text]");
        ALPHAword = input.nextLine();
        text = input.nextLine();
        WordLengthEqualizer();
        text = CODER(ALPHAword,text);
        //text = text.substring(0, (text.length()/2));
        System.out.println("After DECODER:["+text+"]");
        System.out.println("Enter [BETA Word]\n"+"[your text]");
        BETAword = input.nextLine();
        text = input.nextLine();
        WordLengthEqualizer();
        text = CODER(BETAword,text);
        text = text.substring(0, (text.length()/2));
        System.out.println("After DECODER:["+text+"]");


    }
    public static void WordLengthEqualizer() {
        int A,B,T;
        A = ALPHAword.length();
        B = BETAword.length();
        T = text.length();
        while (!(T==A))
        {
         if (A<T) {ALPHAword = ALPHAword+ALPHAword;}
         if (A>T) {ALPHAword = ALPHAword.substring(0,A-(A-T));}
        // System.out.println(ALPHAword+"\t \t"+text);
            A = ALPHAword.length();
        }
        while (!(T==B))
        {
            if (B<T) {BETAword = BETAword+BETAword;}
            if (B>T) {BETAword = BETAword.substring(0,B-(B-T));}
         //   System.out.println(BETAword+"\t \t"+text);
            B = BETAword.length();
        }



    }
    public static String CODER(String ONE,String TWO) {
        char[] MASSCODER = ONE.toCharArray();
        char[] MASSTEXT = TWO.toCharArray();
        String Final = "";

        System.out.println("~~~~ CODER IN: "+ Arrays.toString(MASSCODER)+" "+Arrays.toString(MASSTEXT));

        for (int i = 0; i <MASSCODER.length ; i++) {
           int IndexOne = FindIndex(MASSCODER[i]);
           int IndexTwo = FindIndex(MASSTEXT[i]);
           char Resilt = FindChar(IndexTwo ^ IndexOne);
            System.out.println("~~~~ CODER I="+i+" :"+MASSCODER[i]+" "+IndexOne+" ^ "+MASSTEXT[i]+" "+IndexTwo+" = "+Resilt+" "+(IndexTwo ^ IndexOne));
            Final += Resilt;
            System.out.println("~~~~ CODER Fin I="+i+" "+Final);
           }
        return Final;
        }
    public static int FindIndex(char A ) {
        return new String(myCharArray).indexOf(A);
    }
    public static char FindChar(int A ) {
        while(A>myCharArray.length){A=myCharArray.length-A;}
        while(A<0){A=myCharArray.length+A;}
        return myCharArray[A];
    }
    }
