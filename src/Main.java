import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Message> messages = new ArrayList<>();
            Message message = null;
            File file = new File("Validation_Schema.xsd");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            Pattern patternLength = Pattern.compile("\\W*<xsd:element dfdl:length=\"\\d+\"");
            Pattern patternName = Pattern.compile("\\W*name=\"[A-Za-z]*\"");
            Pattern patternMessageLength = Pattern.compile("\\d+");
            Pattern patternMessageName = Pattern.compile("\"[A-Za-z]*\"");
            while (line != null) {
                if(patternLength.matcher(line).find()) {
                    Matcher matcherLength = patternLength.matcher(line);
                    Matcher matcherName = patternName.matcher(line);
                    matcherLength.find();
                    matcherName.find();
                    Matcher matcherMessageLength = patternMessageLength.matcher(matcherLength.group());
                    Matcher matcherMessageName = patternMessageName.matcher(matcherName.group());
                    matcherMessageLength.find();
                    matcherMessageName.find();
                    String messageName = matcherMessageName.group().replaceAll("\"","");
                    String lenght = matcherMessageLength.group();
                    int messageLenght = Integer.parseInt(lenght);
                    message = new Message(messageLenght,messageName);
                    messages.add(message);
                }
                line = reader.readLine();
            }
            reader.close();
            StringBuilder result = new StringBuilder();
            for(Message m : messages){
                Scanner in = new Scanner(System.in);
                System.out.print("Введите " + m.getName() + " ");
                String name = in.nextLine();
                result.append(name);
                int spaceCount = m.getLength()-name.length();
                String spaces = " ".repeat(spaceCount);
                result.append(spaces);
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
