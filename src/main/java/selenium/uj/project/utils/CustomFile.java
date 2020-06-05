package selenium.uj.project.utils;

import java.io.File;
import java.nio.file.Paths;

public class CustomFile {

    public String getDriverFilePath(String driverFileName) {
        return getResourceFilePath(driverFileName);
        // return getResourceFilePath("drivers/" + driverFileName);
    }

    private String getResourceFilePath(String fileName) {
        try {
            return Paths.get(
                    new File(getClass()
                            .getClassLoader()
                            .getResource(fileName)
                            .getFile())
                            .getAbsolutePath()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // [DO ZASTANOWIENIA] Czy stworzyć bezwględną ścieżkę do pliku drivera??
        }
    }

    public static String getProjectPath () {
        return  System.getProperty("user.dir");
    }
}