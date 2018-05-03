// ------------------------- imports -------------------------
import com.jniwrapper.win32.jexcel.Application;
import com.jniwrapper.win32.jexcel.Cell;
import com.jniwrapper.win32.jexcel.ExcelException;
import com.jniwrapper.win32.jexcel.Range;
import com.jniwrapper.win32.jexcel.Workbook;
import com.jniwrapper.win32.jexcel.Worksheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Math;


// ------------------------- factory -------------------------
public class TourFactory {
    private static final int ITEM_OBSERVATION_DURATION = 10;

    /**
     * Creates tour according to visitor specifications.
     * @param visitorType adult/child/expert
     * @param tourDuration minutes.
     * @return Tour obj.
     */
    public ArrayList<Item> getTour(String visitorType, int tourDuration){
        ArrayList<Item> tour = new ArrayList<>();
        int numItems = (int)Math.floor(tourDuration/ITEM_OBSERVATION_DURATION);

        try {
            // open excel and sort items according to visitorType ranking:
            Application application = new Application();
//            if (!application.isVisible()) {
//                application.setVisible(true);
//            }
            File xlsFile = new File("Data1.xlsx");
            Workbook workbook = application.openWorkbook(xlsFile, true, "");
            Worksheet sheet = workbook.getActiveWorksheet();
            Range data = sheet.getUsedRange();
            data.sort(visitorType, false, false);

            // select k-best:
            for (int i = 0; i < numItems; i++){
                java.util.List itemData = sheet.getRow(i).getCells();
                tour.add(new Item(sheet.getRow(i).getCells()));
            }
            return tour;

        } catch (ExcelException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }


    }

}
