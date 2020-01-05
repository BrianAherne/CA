package CA;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by t00160248 on 29/11/2017.
 */
public class Save {
    public static void objectOutputStream() throws Exception{
        File save = new File("save.data");
        FileOutputStream fileOutputStream = new FileOutputStream(save);
        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);

        os.writeObject(GUI.users);
        os.close();
    }

    public static void objectInputStream() throws Exception{
        File inFile = new File("save.data");
        FileInputStream fileInputStream = new FileInputStream(inFile);
        ObjectInputStream in = new ObjectInputStream(fileInputStream);

        ArrayList<User> users = (ArrayList<User>) in.readObject();

        String usersSave = "";
        for(User u : users){
            usersSave += u.toString();
        }
        in.close();
    }
}
