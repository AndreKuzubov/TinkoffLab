import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by andre on 21.02.2017.
 */
public class CommandLineProcess {

    private static final String com_help = "help";
    private static final String com_about = "about";
    private static final String com_quit = "quit";
    private static final String com_get_pairs = "get_pairs";


    private static final String mes_err_null_input = "type something or use the helper";
    private static final String mes_com_bad = "the command is not known";
    private static final String mes_params_bad = "the parameters are invalid";


    private static final String mes_goodbye = "goodbye";
    private static final String mes_about = "Made for Tinkoff. Copyright Andre Kuzubov https://github.com/AndreKuzubov";


    private static final String mes_help = com_get_pairs + " [base] [currency] " + "\n" +
            "   Get the latest foreign exchange reference rates\n" +
            "   [base] - quote against a different currency\n" +
            "   [currency] - the bought currency, may be specify multiple space-separated\n" +
            "    currencies: AUD BGN BRL CAD CHF CNY CZK DKK GBP HKD HRK HUF IDR ILS INR JPY KRW\n" +
            "                MXN MYR NOK NZD PHP PLN RON RUB SEK SGD THB TRY USD ZAR\n" +
            com_about + "  get info about the program" + "\n" +
            com_quit + "  quit from program" + "\n";

    private static String[] excs;


    public static void run(final CommandLineListener commandLineListener) {
        final String sAll = "AUD BGN BRL CAD CHF CNY CZK DKK GBP HKD HRK HUF IDR ILS INR JPY KRW MXN MYR NOK NZD PHP PLN RON RUB SEK SGD THB TRY USD ZAR";
        excs = sAll.split(" ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String s = br.readLine();
                if (s.isEmpty()) continue;

                List<String> words = new ArrayList<String>(Arrays.asList(s.split(" ")));
                if (words.size() == 0) {
                    System.out.println(mes_err_null_input);
                    continue;
                }

                for (int i = words.size() - 1; i >= 0; i--) {
                    if (words.get(i).isEmpty())
                        words.remove(i);
                }


                switch (words.get(0)) {
                    case com_help:
                        if (words.size() > 1) {
                            System.out.println(mes_params_bad);
                            continue;
                        }
                        System.out.println(mes_help);
                        continue;
                    case com_get_pairs: {
                        List<String> args = words.subList(1, words.size());
                        if (!checkParams(args)) {
                            System.out.println(mes_params_bad);
                            continue;
                        }
                        if (commandLineListener != null) {
                            commandLineListener.userComGetRates(args.get(0),
                                    args.subList(1, args.size()).toArray(new String[args.size() - 1]));
                        }

                    }

                    continue;
                    case com_quit:
                        if (words.size() > 1) {
                            System.out.println(mes_params_bad);
                            continue;
                        }
                        System.out.println(mes_goodbye);
                        return;
                    case com_about:
                        if (words.size() > 1) {
                            System.out.println(mes_params_bad);
                            continue;
                        }
                        System.out.println(mes_about);
                        continue;
                    default:
                        System.out.println(mes_com_bad);
                        continue;

                }

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static boolean checkParams(List<String> args) {
        if (args == null || args.size() < 2) return false;
        for (int i = 0; i < args.size(); i++) {
            boolean b = false;
            for (int j = 0; j < excs.length; j++) {
                if (excs[j].equals(args.get(i))) {
                    b = true;
                    break;
                }
            }
            if (!b) return false;
        }
        return true;
    }


    public interface CommandLineListener {
        void userComGetRates(String base, String[] exchanges);
    }

}
