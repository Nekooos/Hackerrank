import org.junit.jupiter.api.Test;

public class Task9 {
    //Todo remake with substring
    @Test
    public void task9() {
        String time = "12:45:54PM";

        String[] timeArray = time.split(":");
        if(timeArray[2].endsWith("PM")) {
            if(timeArray[0].startsWith("0")) {
                String[] hour = timeArray[0].split("");
                int newHours = Integer.parseInt(hour[1])+12;
                timeArray[0] = Integer.toString(newHours);

            } else if(!timeArray[0].equals("12")){
                int newHours = Integer.parseInt(timeArray[0])+12;
                timeArray[0] = Integer.toString(newHours);
            }
        }
        if(timeArray[2].endsWith("AM")) {
            if(timeArray[0].equals("12")) {
                timeArray[0] = "00";
            }
            if(timeArray[0].equals("11")) {
                int newHours = Integer.parseInt(timeArray[0])+12;
                timeArray[0] = Integer.toString(newHours);
            }

        }
        timeArray[2] = timeArray[2].replaceAll("PM", "");
        timeArray[2] = timeArray[2].replaceAll("AM", "");
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i<timeArray.length; i++) {
            stringBuilder.append(timeArray[i]);
            if(i<2) {
                stringBuilder.append(":");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
