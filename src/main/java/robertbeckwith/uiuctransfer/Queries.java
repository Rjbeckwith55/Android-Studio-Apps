package robertbeckwith.uiuctransfer;

/**
 * Created by rjbec on 5/6/2017.
 */

public class Queries {
    public static String selectAll = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20%2A&key=1jJLek-Y_6n9JoBqEBNj88WaE_WBbgwrAdgvqharpnvI";
    public static String selectAllSS = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20*%20where%20G%20contains%20%27SS%27&key=1jJLek-Y_6n9JoBqEBNj88WaE_WBbgwrAdgvqharpnvI";
    public static String selectAllHum = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20*%20where%20G%20contains%20%27LA%27&key=1jJLek-Y_6n9JoBqEBNj88WaE_WBbgwrAdgvqharpnvI";
    public static String selectAllWCC = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20*%20where%20H%20contains%20%27WCC%27&key=1jJLek-Y_6n9JoBqEBNj88WaE_WBbgwrAdgvqharpnvI";
    public static String selectAllUS = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20*%20where%20H%20contains%20%27US%27&key=1jJLek-Y_6n9JoBqEBNj88WaE_WBbgwrAdgvqharpnvI";
    public static String selectAllNW = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20*%20where%20H%20contains%20%27NW%27&key=1jJLek-Y_6n9JoBqEBNj88WaE_WBbgwrAdgvqharpnvI";
    public static String selectNoTransfers = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20*%20where%20D%20%3D%20%27NO%27&key=1iaicgtX-kDgNigWAfvERlcGH7_Nn9UzMgucSo0p6d40";
    public static String selectTransfers = "https://spreadsheets.google.com/tq?tqx=out:JSON&tq=select%20*%20where%20D%20%3C%3E%20%27NO%27&key=1iaicgtX-kDgNigWAfvERlcGH7_Nn9UzMgucSo0p6d40";
}
