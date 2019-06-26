package models;
import models.VisualizationForm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SiriCsvForm extends VisualizationForm {

    public SiriCsvForm() {

    }


    /**
     * @return description of chosen parameters
     */
    public String getParametersList(){
        String strDate="";
        String strDate2="";
        if(startDate!=null) {
            Date date = startDate;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            strDate = formatter.format(date);
        }
        if(endDate!=null) {
            Date date2 = endDate;
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            strDate2= formatter2.format(date2);
        }

        return "Start Date: "+strDate+", "+
                "End Date: "+strDate2+", "+
                "Day: "+day+", "+
                "Start Hour: "+startHour+", "+
                "End Hour: "+endHour+", "+
                "Minimum Passengers For Public Lane: "+1;

    }
}
