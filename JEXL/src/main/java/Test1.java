import org.apache.commons.jexl3.*;

public class Test1 {

    public static void runTest1(){
        //String scriptText = "/home/zemoso/Desktop/JEXL/src/expression.txt";

        JexlEngine jexl = new JexlBuilder().create();
        JexlExpression script = jexl.createExpression("`${user}`");
        JexlContext context = new MapContext();
        context.set("user","Zemo");
        Object result = script.evaluate(context);

        System.out.println(result);
    }
}

