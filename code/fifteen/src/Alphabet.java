/**
 * Created with IntelliJ IDEA.
 * User: rrd09
 * Date: 30/09/13
 * Time: 14:27
 */
public class Alphabet {

    public static Character getCharacter(int code) {
        if (code == -1) return ' ';
        if (code == -2) return ',';
        if (code == -3) return '.';
        if (code == -4) return '!';
        if (code > 100) return (char) (code - 36);
        return (char) (code + 96);
    }

}
