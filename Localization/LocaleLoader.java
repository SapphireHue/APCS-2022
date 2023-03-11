import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class LocaleLoader {

  public static void main(String[] args) {
    ArrayList<AbstractLocale> locales = getLocales();
    Scanner scan = new Scanner(System.in);
    int i = 1;
    for (AbstractLocale locale : locales){
      System.out.println(i++ + ". " + locale.getLocation() + " (" + locale.getLanguage() + ")");
    }
    System.out.print("What locale do you want? ");
    int localeInt = scan.nextInt()-1;
    AbstractLocale locale = locales.get(localeInt);
    System.out.println(locale.getGreeting());
    System.out.print("What's the hour? ");
    int hour = scan.nextInt();
    System.out.print("What's the minute? ");
    int min = scan.nextInt();
    System.out.println("The local time is: " + locale.getLocalTime(hour, min));
    System.out.print("How much money do you have in your wallet or purse? ");
    int money = scan.nextInt();
    System.out.println("In " + locale.getLocation()+", that's worth " + locale.getCurrencySymbol() + String.format("%.2f", locale.getCurrencyValue(money)));
    //System.out.println(locales);

  }

  /**
   * DO NOT MODIFY THIS METHOD.
   * Scans the directory of your .java file for all implementations of
   * AbstractLocale, instantiates them, and puts them in an ArrayList.
   * @return the list of locale implementations.
   */
  public static ArrayList<AbstractLocale> getLocales() {
    ArrayList<AbstractLocale> locales = new ArrayList<AbstractLocale>();
    File pwd = new File(
        ClassLoader.getSystemClassLoader().getResource("").getPath());
    File[] classFiles = pwd.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.endsWith(".class");
        }});
    for(File f : classFiles) {
      String className = f.getName().replace(".class", "");
      try {
        Class<?> c = Class.forName(className);
        if (!c.getName().equals("AbstractLocale")) {
          Object obj = c.newInstance();
          if (obj instanceof AbstractLocale)
            locales.add((AbstractLocale)obj);
        }
      } catch (ClassNotFoundException e) {
        System.err.println("Class not found: " + className);
      } catch (InstantiationException e) {
        System.err.println("Error instantiating the object: " + className);
      } catch (IllegalAccessException e) {
        System.err.println("Invalid method access for " + className);
      }
    }
    return locales;
  }
}
