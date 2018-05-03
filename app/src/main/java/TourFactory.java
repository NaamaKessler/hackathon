
import com.jniwrapper.win32.jexcel.Application;
import com.jniwrapper.win32.jexcel.ExcelException;
import com.jniwrapper.win32.jexcel.Range;
import com.jniwrapper.win32.jexcel.Workbook;
import com.jniwrapper.win32.jexcel.Worksheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Math;

public class TourFactory {
    private static final int ITEM_OBSERVATION_DURATION = 10;

    public ArrayList<Tour> getTour(String visitorType, int tourDuration){
        ArrayList<Tour> Tour;
        int numItems = (int)Math.floor(tourDuration/ITEM_OBSERVATION_DURATION);

        Application application;
        try {
            application = new Application();
            if (!application.isVisible()) {
                application.setVisible(true);
            }
            File xlsFile = new File("C:\\Users\\Naama\\Dropbox\\hackathon\\app\\src\\main\\asset");
            Workbook workbook = application.openWorkbook(xlsFile, true, null);
            Worksheet sheet = workbook.getActiveWorksheet();
            Range data = sheet.getUsedRange();
            data.sort(visitorType, false, false);

        } catch (ExcelException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//        Worksheet customSheet = workbook.getWorksheet("Custom sheet");


        return null;

    }

}
