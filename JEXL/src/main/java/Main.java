import org.apache.commons.jexl3.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args){

        //ScriptFromFile
        String TEST1 = "/home/zemoso/Desktop/JEXL/src/main/java/myscript.jexl";
        File testScript = new File(TEST1);
        JexlEngine JEXL = new JexlBuilder().create();
        JexlScript s = JEXL.createScript(testScript);
        JexlContext jc = new MapContext();
        jc.set("out", System.out);
        Object result = s.execute(jc);
        System.out.println(result);

        //ArgScriptFromFile
        String TEST2 = "/home/zemoso/Desktop/JEXL/src/main/java/myscript2.jexl";
        testScript = new File(TEST2);
        JEXL = new JexlBuilder().create();
        s = JEXL.createScript(testScript,new String[]{"x","y"});
        jc = new MapContext();
        jc.set("out", System.out);
        result = s.execute(jc, 33, 29);
        System.out.println(result);

        // MasterPatient and NewRecord with ArgScript

        Date mDate = new Date();
        Date newDate = new Date();

        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        try{
        mDate = ft.parse("17-07-2017");
        newDate = ft.parse("16-11-2017");
        }catch (ParseException e) {
            System.out.println("Unparseable Date using format : " + ft);
        }

        String TEST3 = "/home/zemoso/Desktop/JEXL/src/main/java/myscript3.jexl";
        testScript = new File(TEST3);

        MasterPatient masterPatient = new MasterPatient("Devendra","Choudhary","A119,IIT Kanpur", mDate);
        NewRecord   newRecord = new NewRecord("Deven","Choudhary","plot 237, Prashanit Hill, Hyderabad", newDate);

        JEXL = new JexlBuilder().create();
//        s = JEXL.createScript(testScript,new String[]{"masterPatient","newRecord"});
        s = JEXL.createScript(testScript);
        jc = new MapContext();
        jc.set("out", System.out);
        jc.set("masterPatient",masterPatient);
        jc.set("newRecord",newRecord);

        MasterPatient updatedMaster = new MasterPatient();
//        updatedMaster = s.execute(jc, masterPatient, newRecord);
        updatedMaster = (MasterPatient) s.execute(jc);

        System.out.println("New add:"+ updatedMaster.getAddress());


    }
}
