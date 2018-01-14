/**
HashMapRunner
@author Akash Kumar
@version 11/28/16
*/

public class HashMapRunner
{
    public static void main(String[] args)
    {
        HashMap<String,String> tester = new HashMap();
        System.out.println("Testing isEmpty; should print true");
        System.out.println(tester.isEmpty());
        System.out.println("Testing isEmpty; should print out false");
        tester.put("Key 1","Value 1");
        System.out.println(tester.isEmpty());
        System.out.println("Testing put; should print out Value 1");
        tester.printValues();
        System.out.println("Testing remove; should print out Value 1 followed by true");
        System.out.println(tester.remove("Key 1"));
        System.out.println(tester.isEmpty());
        HashMap<String,String> test = new HashMap(3,0.5);
        System.out.println("Testing if values are NULL; should print out 3 NULLs");
        test.printEntries();
        System.out.println("Testing grow; should print out 4 NULLs and two entries");
        test.put("Key 1","Value 1");
        test.put("Key 2","Value 2");
        test.printEntries();
        System.out.println("Testing size; should print out 2");
        System.out.println(test.size());
        System.out.println("Testing containsValue; should print out true followed by false");
        System.out.println(test.containsValue("Value 2"));
        System.out.println(test.containsValue("tomato"));
        System.out.println("Testing containsKey; should print out true followed by false");
        System.out.println(test.containsKey("Key 2"));
        System.out.println(test.containsKey("potato"));
        System.out.println("Testing keySet; should print out Key 1 followed by Key 2");
        System.out.println(test.keySet().toString());
        System.out.println("Testing values; should print out Value 1 followed by Value 2");
        System.out.println(test.values().toString());
    }
}