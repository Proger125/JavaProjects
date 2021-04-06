package sample;

public final class RegularExpressions {
    public static final String NATURAL_REGEXP = "^(\\+?[1-9][0-9]*)$";
    public static final String INTEGER_REGEXP = "^(0|[-\\+]?[1-9][0-9]*)$";
    public static final String DOUBLE_REGEXP = "^([+-]?((\\d+\\.\\d*)|(\\d*\\.\\d+))([eE][+-]?(0*)?((30[0-8])|([0-2]?[0-9]{0,2})))?)|([+-]?\\d*[eE][+-]?(0*)?((30[0-8])|([0-2]?[0-9]{0,2})))$";
    public static final String DATE_REGEXP = "(^(((0[1-9]|1[0-9]|2[0-8])[\\.](0[1-9]|1[012]))|((29|30|31)[\\.](0[13578]|1[02]))|((29|30)[\\.](0[4,6,9]|11)))[\\.](19|[2-9][0-9])\\d\\d$)|(^29[\\.]02[\\.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
    public static final String EMAIL_REGEXP = "[a-z].?([-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(com|net|org|pro|tel|travel)";
    public static final String TIME_REGEXP = "^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$";
    private RegularExpressions(){}
}
